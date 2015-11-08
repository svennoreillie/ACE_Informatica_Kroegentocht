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

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.InjectLogger;
import helpers.MagicStrings;
import model.ModelBase;
import services.classwrappers.ClassWrapperService;

@Singleton
public class StreamGenerator<T extends ModelBase> implements StreamGeneratorService<T> {

	private final Path dbPath;

	@InjectLogger Logger logger;
	
	@Inject
	public StreamGenerator(ClassWrapperService<T> typeService) {
		this.dbPath = Paths.get(typeService.getModelClass().getName() + ".db");
	}

	public void Show() {
		logger.debug("Show method called");
	}
	
	public Path getDbPath() {
		return this.dbPath;
	}

	@Override
	public ObjectInputStream getInputStream() throws EOFException, DBException, DBMissingException {
		try {
			checkDB();
			ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(this.dbPath));
			return stream;
		} catch (EOFException e) {
			throw e;
		} catch (IOException e) {
			throw new DBException(MagicStrings.DBReadError, e);
		}
	}

	@Override
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
