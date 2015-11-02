/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 31/10/2015
 * @Project: KroegenTocht
 * @Purpose: Service die Input en output stream creert, enige reden van bestaan is zodat dit
 * 			gemocked zou kunnen worden in unittests
 */

package services;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.MagicStrings;
import model.ModelBase;

public class StreamGenerator<T extends ModelBase> {

	private final Path dbPath;

	public StreamGenerator(Class<T> type) {
		this.dbPath = Paths.get(type.getName() + ".db");
	}

	public Path getDbPath() {
		return this.dbPath;
	}

	public ObjectInputStream getInputStream() throws DBMissingException, DBException {
		try {
			checkDB();
			ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(this.dbPath));
			return stream;
		} catch (EOFException e) {
			throw new DBException(MagicStrings.DBEOFFailure, e);
		} catch (ClassNotFoundException e) {
			throw new DBException(MagicStrings.DBClassFailure, e);
		} catch (IOException e) {
			throw new DBException(MagicStrings.DBReadError, e);
		}
	}

	public ObjectOutputStream getOutputStream() throws DBMissingException, DBException {
		try {
			checkDB();
			ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(this.dbPath));
			return stream;
		} catch (IOException e) {
			throw new DBException(MagicStrings.DBWriteError, e);
		}
	}

	private void checkDB() throws DBMissingException {
		if (!Files.exists(this.dbPath)) {
			try {
				Files.createFile(this.dbPath);
			} catch (IOException e) {
				throw new DBMissingException();
			}
		}
	}
}
