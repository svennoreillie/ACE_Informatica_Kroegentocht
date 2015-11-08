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
		this.filter = new Filter();
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
	public void testGetAverageMinutes() throws DBMissingException, DBException {
		assertEquals(80, analyse.getAverageMinutes(filter));
	}
	
	@Test
	public void testGetAverageMinutesFilterDate() throws DBMissingException, DBException {
		Calendar date = Calendar.getInstance();
		date.set(2015, 1, 2);
		this.filter.setStartDate(date);
		assertEquals(90, analyse.getAverageMinutes(filter));
	}

	@Test
	public void testGetTotalConsumptions() throws DBMissingException, DBException {
		assertEquals(21, analyse.getTotalConsumptions(filter));
	}
	
	@Test
	public void testGetTotalConsumptionsFilterDate() throws DBMissingException, DBException {
		Calendar date = Calendar.getInstance();
		date.set(2015, 1, 2);
		this.filter.setStartDate(date);
		assertEquals(16, analyse.getTotalConsumptions(filter));
		
	}

	@Test
	public void testGetLongestVisit() throws DBMissingException, DBException {
		assertEquals(120, analyse.getLongestVisit(filter));
	}
	
	@Test
	public void testGetLongestVisitFilterDate() throws DBMissingException, DBException {
		Calendar date = Calendar.getInstance();
		date.set(2015, 1, 3);
		this.filter.setStartDate(date);
		assertEquals(60, analyse.getLongestVisit(filter));
	}

}
