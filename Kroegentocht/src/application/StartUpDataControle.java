/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: If data is NULL use factories to auto generate some data.
 */

package application;

import com.google.inject.Inject;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.enums.EnumEstablishmentName;
import helpers.factories.EstablishmentFactory;
import helpers.factories.VisitFactoryService;
import model.Address;
import model.Establishment;
import model.TypeOfBusiness;
import model.Visit;
import services.GenericDataService;
import java.util.Random;


public class StartUpDataControle {
	private GenericDataService<Establishment> dataEstablishmentService;
	private GenericDataService<Visit> visitService;
	private VisitFactoryService visitFactory;
	private GenericDataService<TypeOfBusiness> dataTypeOfBusinessService;
	private GenericDataService<Address> dataAddressService;

	@Inject
	public StartUpDataControle(GenericDataService<Establishment> dataEstablishment,
			GenericDataService<Visit> visit,
			GenericDataService<Address> address,
			GenericDataService<TypeOfBusiness> typeOfBusiness,
			VisitFactoryService visitFactory ) throws Exception {
		this.dataEstablishmentService = dataEstablishment;
		this.visitService = visit;
		this.visitFactory = visitFactory;
		this.dataTypeOfBusinessService = typeOfBusiness;
		this.dataAddressService = address;
	}
	
	public void DataControle() throws DBMissingException, DBException{
		if(dataEstablishmentService.getAll().isEmpty())
		{
			Random rand;
			for(int i = 0; i < EnumEstablishmentName.values().length; i++){
				rand = new Random();
				Establishment establishment = EstablishmentFactory.getEtablischement(rand,i);
				dataEstablishmentService.add(establishment);
				dataTypeOfBusinessService.add(establishment.getBusinessType());
				dataAddressService.add(establishment.getAddress());
			}
			for (int i = 0; i < 15; i++) {
				rand = new Random();
				visitService.add(visitFactory.getVisit(rand));
			}
		}
	}
}