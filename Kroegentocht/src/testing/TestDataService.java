/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: Junit voor TestData
 */

package testing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import helpers.DBException;
import helpers.DBMissingException;
import model.Visit;
import services.GenericDataService;

public class TestDataService implements GenericDataService<Visit> {

	List<Visit> internalList = new ArrayList<Visit>();
	
	public TestDataService() {
		Calendar date = Calendar.getInstance();
		date.set(2015, 1, 1);
		
		Calendar date2 = Calendar.getInstance();
		date2.set(2015, 1, 2);
		
		Calendar date3 = Calendar.getInstance();
		date3.set(2015, 1, 3);
		
		
		Visit v = new Visit();
		v.setAmountOfConsumptions(5);
		v.setDurationMinutes(60);
		v.setDate(date);

		internalList.add(v);
		
		v = new Visit();
		v.setAmountOfConsumptions(10);
		v.setDurationMinutes(120);
		v.setDate(date2);

		internalList.add(v);
		
		v = new Visit();
		v.setAmountOfConsumptions(6);
		v.setDurationMinutes(60);
		v.setDate(date3);

		internalList.add(v);
	}
	
	@Override
	public List<Visit> getAll() throws DBMissingException, DBException {
		return internalList;
	}

	@Override
	public Visit get(int id) throws NoSuchElementException, DBMissingException, DBException {
		return internalList.stream().filter(e -> e.getId() == id).findFirst().get();
	}
	
	@Override
	public void add(Visit entity) throws DBMissingException, DBException {
		return;
	}

	@Override
	public void remove(Visit entity) throws DBMissingException, DBException {
		return;
	}

}
