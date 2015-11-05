/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 05/11/2015
 * @Project: KroegenTocht
 * @Purpose: Unit test voor StreamGenerator
 */

package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import helpers.DBException;
import helpers.DBMissingException;
import model.*;
import services.StreamGenerator;
import services.classwrappers.*;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StreamGeneratorTest {
	
	private Path testModelPath = Paths.get("testing.TestModel.db");
	private StreamGenerator<TestModel> testGenerator = new StreamGenerator<TestModel>(new TestModelClassWrapper());

	@Before
	public void setUp() throws Exception {
		Files.createFile(testModelPath);
	}

	@After
	public void tearDown() throws Exception {
		Files.deleteIfExists(testModelPath);
	}
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	

	@Test
	public void testPathCreation() {
		String testString = "testing.TestModel.db";
		assertEquals(testModelPath, testGenerator.getDbPath());
		assertEquals(testString, testGenerator.getDbPath().toString());
		
		StreamGenerator<Visit> visitGen = new StreamGenerator<Visit>(new VisitClassWrapper());
		String visitString = "model.Visit.db";
		Path visitPath = Paths.get(visitString);
		assertEquals(visitPath, visitGen.getDbPath());
		assertEquals(visitString, visitGen.getDbPath().toString());
		
		StreamGenerator<Address> addressGen = new StreamGenerator<Address>(new AddressClassWrapper());
		String addressString = "model.Address.db";
		Path addressPath = Paths.get(addressString);
		assertEquals(addressPath, addressGen.getDbPath());
		assertEquals(addressString, addressGen.getDbPath().toString());
	}
	
	@Test(expected=EOFException.class)
	public void testErrorOnEmptyFile() throws DBException, DBMissingException, IOException {
		//remove path created by setup of test
		Files.deleteIfExists(testModelPath);
		testGenerator.getInputStream();
	}
	
	@Test
	public void testAutoCreateNonExistingPath() throws DBException, DBMissingException, IOException {
		//remove path created by setup of test
		Files.deleteIfExists(testModelPath);
		
		try {
			testGenerator.getInputStream();
		} catch (EOFException e) {
			//We expect this because file is empty
		}
		assertTrue(Files.exists(testModelPath));
	}
	

}
