/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Interface voor GeneriekeDataService
 */

package services;

import java.util.List;
import java.util.NoSuchElementException;

import helpers.DBException;
import helpers.DBMissingException;
import model.ModelBase;

public interface GenericDataService<T extends ModelBase> {

	List<T> getAll() throws DBMissingException, DBException;

	T get(int id) throws NoSuchElementException, DBMissingException, DBException;

	void add(T entity) throws DBMissingException, DBException;

	void remove(T entity) throws DBMissingException, DBException;

}