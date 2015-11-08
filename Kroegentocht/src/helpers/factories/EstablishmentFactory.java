/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Auto generator voor random Etablishment objecten(geg etc afkomstig uit enums)
 */

package helpers.factories;

import java.util.Random;
import helpers.enums.*;
import model.Establishment;
import model.TypeOfBusiness;

public class EstablishmentFactory {

	public static Establishment getEtablischement(Random rand,int i){
		Establishment establishment = new Establishment();
		establishment.setAddress(AddressFactory.getAddress(rand));
		TypeOfBusiness typeOfBusiness = new TypeOfBusiness();
		EnumTypeOfBusiness enumType = EnumTypeOfBusiness.values()[rand.nextInt(EnumTypeOfBusiness.values().length)];
		typeOfBusiness.setType(enumType.getTypeOfBusiness());
		establishment.setBusinessType(typeOfBusiness);
		EnumEstablishmentName enumName = EnumEstablishmentName.values()[i];
		establishment.setName(enumName.toString());
		return establishment;
	}
}
