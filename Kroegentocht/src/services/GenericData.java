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

import com.google.inject.Inject;
import com.google.inject.Singleton;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.MagicStrings;
import model.Address;
import model.ModelBase;
import services.classwrappers.ClassWrapperService;

@Singleton
public class GenericData<T extends ModelBase> implements GenericDataService<T> {

	private List<T> internalList;
	private StreamGeneratorService<T> streamService;
	
	@Inject
	public GenericData(StreamGeneratorService<T> streamService) {
		this.streamService = streamService;
	}

	@Override
	public List<T> getAll() throws DBMissingException, DBException {
		if (this.internalList == null) {
			this.internalList = new ArrayList<T>();
			try {
				ObjectInputStream stream = this.streamService.getInputStream();
				this.internalList.add((T)stream.readObject());
			} catch (EOFException e) {
				//end of file read => this is expected
			} catch (ClassNotFoundException | IOException e) {
				throw new DBException(MagicStrings.DBClassFailure, e);
			} 
		}
		return this.internalList;
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
