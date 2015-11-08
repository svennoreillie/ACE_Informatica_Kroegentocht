/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Service die objecten die overerven van ModelBase kan beheren, 
 * 			houd een interne lijst bij van het generieke type en verzorgt opslaan in 
 * 			de database files
 */

package services;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.InjectLogger;
import helpers.MagicStrings;
import model.Address;
import model.ModelBase;
import services.classwrappers.ClassWrapperService;
import services.events.DataChangedEventFiringService;
import services.events.DataChangedEventFiringSource;

@Singleton
public class GenericData<T extends ModelBase> implements GenericDataService<T> {

	private List<T> internalList;
	private StreamGeneratorService<T> streamService;
	private DataChangedEventFiringService<T> dataEventFiringSource;
	
	@InjectLogger Logger logger;
	
	@Inject
	public GenericData(StreamGeneratorService<T> streamService, DataChangedEventFiringService<T> firingService) {
		this.streamService = streamService;
		this.dataEventFiringSource = firingService;
	}

	@Override
	public List<T> getAll() throws DBMissingException, DBException {
		if (this.internalList == null) {
			this.internalList = getListFromStream(); 
		}
		return this.internalList;
	}

	public List<T> getListFromStream() throws DBException, DBMissingException {
		List<T> list = new ArrayList<T>();
		try {
			ObjectInputStream stream = this.streamService.getInputStream();
			while (true) {
				list.add((T) stream.readObject());
			} 
		} catch (EOFException e) {
			//end of file read => this is expected
		} catch (ClassNotFoundException | IOException e) {
			throw new DBException(MagicStrings.DBClassFailure, e);
		}
		
		return list;
	}

	@Override
	public T get(int id) throws NoSuchElementException, DBMissingException, DBException {
		List<T> entityList = this.getAll();
		return entityList.stream().filter(e -> e.getId() == id).findFirst().get();
	}

	@Override
	public void add(T entity) throws DBMissingException, DBException {
		List<T> tobList = this.getAll();
		if (!tobList.contains(entity)) {
			tobList.add(entity);
			writeDB();
			//Fire event
			dataEventFiringSource.fireAdded(entity);
		}
	}

	@Override
	public void remove(T entity) throws DBMissingException, DBException {
		List<T> tobList = this.getAll();
		if (tobList.contains(entity)) {
			tobList.remove(entity);
			writeDB();
		}
	}

	private void writeDB() throws DBMissingException, DBException {
		if (this.internalList != null) {
			try {
				ObjectOutputStream stream = this.streamService.getOutputStream();
				
				for (T entity : this.internalList) {
					stream.writeObject(entity);
				}
			} catch (IOException e) {
				throw new DBException(MagicStrings.DBWriteError, e);
			}
		}
	}


}
