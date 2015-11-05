/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Interface die voorziet in een input en outputservice
 */

package services;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import helpers.DBException;
import helpers.DBMissingException;
import model.ModelBase;

public interface StreamGeneratorService<T extends ModelBase> {

	ObjectInputStream getInputStream() throws DBException, EOFException, DBMissingException;

	ObjectOutputStream getOutputStream() throws DBMissingException, DBException;

}