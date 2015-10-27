/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Service die objecten die overerven van ModelBase kan beheren, 
 * 			houd een interne lijst bij van het generieke type en verzorgt opslaan in 
 * 			de database files
 */

package application;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.*;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.MagicStrings;
import model.ModelBase;


public class GenericDataService<T extends ModelBase> implements IGenericDataSerivce<T> {

	private List<T> businessTypeList;
	private final Path dbPath;

	public GenericDataService(Class<T> type) {
		this.dbPath = Paths.get(type.getName() + ".db");
	}


	@Override
	public List<T> getAll() throws DBMissingException, DBException {
		if (this.businessTypeList == null) {
			try {
				if (Files.exists(this.dbPath)) {
					ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(this.dbPath));
					this.businessTypeList = (List<T>) stream.readObject();
				} else {
					throw new DBMissingException();
				}
			} catch (EOFException e) {
				throw new DBException(MagicStrings.DBEOFFailure, e);
			} catch (ClassNotFoundException e) {
				throw new DBException(MagicStrings.DBClassFailure, e);
			} catch (IOException e) {
				throw new DBException(MagicStrings.DBReadError, e);
			}
		}
		return this.businessTypeList;
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
		if (this.businessTypeList != null) {
			try {

				if (Files.exists(this.dbPath)) {
					ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(this.dbPath));
					stream.writeObject(this.businessTypeList);
				} else {
					throw new DBMissingException();
				}
			} catch (IOException e) {
				throw new DBException(MagicStrings.DBWriteError, e);
			}
		}
	}

}
