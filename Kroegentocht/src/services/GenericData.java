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

import com.google.inject.Singleton;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.MagicStrings;
import model.Address;
import model.ModelBase;

@Singleton
public class GenericData<T extends ModelBase> implements GenericDataService<T> {

	private List<T> internalList;
	private final Class<T> type;
	
	public GenericData(Class<T> type) {
		this.type = type;
	}

	@Override
	public List<T> getAll() throws DBMissingException, DBException {
		if (this.internalList == null) {
			try {
				StreamGeneratorService<T> g = new StreamGenerator<T>(this.type);
				ObjectInputStream stream = g.getInputStream();
				
				this.internalList = (List<T>)stream.readObject();
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
				StreamGeneratorService<T> g = new StreamGenerator<T>(this.type);
				ObjectOutputStream stream = g.getOutputStream();
				
				stream.writeObject(this.internalList);
			} catch (IOException e) {
				throw new DBException(MagicStrings.DBWriteError, e);
			}
		}
	}


}
