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
import model.Visit;

public class VisitFactory {
	
	public static Visit getVisit(Random rand){
		Visit visit = new Visit();
		visit.setEstablishment(EstablishmentFactory.getEtablischement(rand));
		int day, month, year;
		day = 1+rand.nextInt(28);
		month = 1+rand.nextInt(12);
		year = 2014-rand.nextInt(5);
		GregorianCalendar date = new GregorianCalendar(day,month,year);
		visit.setDate(date);
		visit.setAmountOfConsumptions(1+rand.nextInt(30));
		visit.setDurationMinutes(1+rand.nextInt(480));
		return visit;
	}
}
