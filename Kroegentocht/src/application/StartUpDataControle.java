/**
 * @Autor: Mathy Paesen, Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: If data is NULL use factories to auto generate some data.
 */

package application;

import com.google.inject.Inject;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.factories.EstablishmentFactory;
import helpers.factories.VisitFactory;
import model.Establishment;
import model.Visit;
import services.GenericDataService;
import java.util.Random;


public class StartUpDataControle {
	private GenericDataService<Establishment> dataEstablishmentService;
	private GenericDataService<Visit> visitService;

	@Inject
	public StartUpDataControle(GenericDataService<Establishment> dataEstablishment,GenericDataService<Visit> visit ) throws Exception {
		this.dataEstablishmentService = dataEstablishment;
		this.visitService = visit;
	}
	
	public void DataControle() throws DBMissingException, DBException{
		if(dataEstablishmentService.getAll().isEmpty())
		{
			Random rand;
			for(int i = 0; i < 5; i++){
				rand = new Random();
				dataEstablishmentService.add(EstablishmentFactory.getEtablischement(rand));
			}
			for (int i = 0; i < 15; i++) {
				rand = new Random();
				visitService.add(VisitFactory.getVisit(rand));
			}
		}
	}
}