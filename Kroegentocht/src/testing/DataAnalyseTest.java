package testing;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;

import helpers.DBException;
import helpers.DBMissingException;
import model.Visit;
import services.DataAnalyse;
import services.GenericData;
import services.GenericDataService;
import services.StreamGenerator;
import services.classwrappers.VisitClassWrapper;
import services.events.DataChangedEventFiringSource;
import services.helpers.Filter;

public class DataAnalyseTest {

	
	@Before
	public void setUpBefore() throws Exception {
		this.filter = new Filter();
	}

	private DataAnalyse analyse;
	private Filter filter;

	
	public DataAnalyseTest() {
		analyse = new DataAnalyse(new TestDataService());
		// GenericData<Visit>(new StreamGenerator<Visit>(new VisitClassWrapper()), new DataChangedEventFiringSource<Visit>()));
		this.filter = new Filter();
	}
	

	@Test
	public void testDataAnalyse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalMinutesNoFilter() throws DBMissingException, DBException {
		assertEquals(240, analyse.getTotalMinutes(filter));
	}
	
	@Test
	public void testGetTotalMinutesFilterDate() throws DBMissingException, DBException {
		Calendar date = Calendar.getInstance();
		date.set(2015, 1, 2);
		this.filter.setStartDate(date);
		assertEquals(180, analyse.getTotalMinutes(filter));
	}

	@Test
	public void testGetAverageMinutes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalConsumptions() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLongestVisit() {
		fail("Not yet implemented");
	}

}
