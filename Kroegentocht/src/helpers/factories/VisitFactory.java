/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Factory to auto generate visit objects (date: max day 28 & between 2009 and 2014)
 */

package helpers.factories;

import java.util.GregorianCalendar;
import java.util.Random;

import com.google.inject.Inject;

import helpers.DBException;
import helpers.DBMissingException;
import model.Establishment;
import model.Visit;
import services.GenericDataService;

public class VisitFactory implements VisitFactoryService {
	
	private GenericDataService<Establishment> dataEstablishmentService;

	@Inject
	public VisitFactory(GenericDataService<Establishment> dataEstablishment) throws Exception {
		this.dataEstablishmentService = dataEstablishment;
		
	}
	
	/* (non-Javadoc)
	 * @see helpers.factories.VisitFactoryService#getVisit(java.util.Random)
	 */
	@Override
	public Visit getVisit(Random rand) throws DBMissingException, DBException{
		Visit visit = new Visit();
		
		visit.setEstablishment(dataEstablishmentService.getAll().get(rand.nextInt(dataEstablishmentService.getAll().size())));
		int day, month, year;
		day = 1+rand.nextInt(28);
		month = 1+rand.nextInt(12);
		year = 2014-rand.nextInt(5);
		GregorianCalendar date = new GregorianCalendar(day,month,year);
		visit.setDate(date);
		visit.setAmountOfConsumptions(1+rand.nextInt(10));
		visit.setDurationMinutes(1+rand.nextInt(240));
		return visit;
	}
}
