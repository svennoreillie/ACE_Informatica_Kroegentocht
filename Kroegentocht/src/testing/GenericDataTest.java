/**
 * @Autor: Sven Noreilli
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Junit voor GenericData
 */

package testing;

import static org.junit.Assert.*;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import application.AppInjector;
import helpers.DBException;
import helpers.DBMissingException;
import services.GenericData;
import services.GenericDataService;
import services.StreamGenerator;
import services.events.DataChangedEventFiringSource;

public class GenericDataTest {

	private Path testModelPath = Paths.get("testing.TestModel.db");
	private GenericData<TestModel> data = null;
	private TestModel test = new TestModel();
	private TestModel test2 = new TestModel();
	
	
	@Before
	public void setUp() throws Exception {
		test = new TestModel();
		test.setId(2);
		test.setHold(true);
		test.setTestNumber(3);
		test.setTestString("test");
		test2 = new TestModel();
		test2.setId(4);
		test2.setHold(false);
		test2.setTestNumber(83);
		test2.setTestString("test2");
	}

	@After
	public void tearDown() throws Exception {
		Files.deleteIfExists(testModelPath);
	}
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();

	public GenericDataTest() {
		this.data = new GenericData<TestModel>(new StreamGenerator<TestModel>(new TestModelClassWrapper()), new DataChangedEventFiringSource<TestModel>());
	}
	
	
	@Test
	public void WriteTestObject() throws DBMissingException, DBException {
		assertFalse(Files.exists(testModelPath));
		data.add(test);
		assertTrue(Files.exists(testModelPath));
	}
	
	@Test
	public void WriteMultipleTestObject() throws DBMissingException, DBException {
		assertFalse(Files.exists(testModelPath));
		data.add(test);
		assertTrue(Files.exists(testModelPath));
		data.add(test2);
	}
	
	@Test
	public void ReadTest() throws DBMissingException, DBException {
		this.WriteTestObject();		
		List<TestModel> list = data.getAll();
		
		assertEquals(1, list.size());
		assertEquals(test, list.get(0));
	}
	
	@Test
	public void ReadMultipleTest() throws DBMissingException, DBException {
		this.WriteMultipleTestObject();		
		List<TestModel> list = data.getAll();
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void ReadByIdTest() throws DBMissingException, DBException {
		this.WriteMultipleTestObject();		
		TestModel model = data.get(4);
		
		assertEquals(test2, model);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void RemoveTest() throws DBMissingException, DBException {
		this.WriteMultipleTestObject();
		
		List<TestModel> list = data.getAll();
		
		assertEquals(2, list.size());
		
		data.remove(test);
		
		list = data.getAll();
		assertEquals(1, list.size());
		assertEquals(test2, list.get(0));

		data.get(3);
	}
	
	@Test
	public void testInternalSaveMethod() throws DBMissingException, DBException {
		this.WriteMultipleTestObject();
		
		List<TestModel> list = data.getListFromStream();
		
		assertEquals(2, list.size());
	}

}
