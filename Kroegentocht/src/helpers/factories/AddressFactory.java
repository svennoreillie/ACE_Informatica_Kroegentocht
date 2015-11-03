/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Auto generator voor random adres objecten(namen etc afkomstig uit enums)
 */


package helpers.factories;

import java.util.Random;
import helpers.enums.*;
import model.Address;


public class AddressFactory {

	public static Address getAddress(Random rand){
		Address address = new Address();
		address.setStreet(EnumStreet.values()[rand.nextInt(EnumStreet.values().length)].getStreet());
		address.setNumber(Integer.toString(1+rand.nextInt(999)));
		address.setBox(Integer.toString(1+rand.nextInt(99)));
		EnumCity city = EnumCity.values()[rand.nextInt(EnumCity.values().length)];
		address.setCity(city.getCity());
		address.setZipCode(city.getZipCode());
		address.setPhone(
				city.getPrefix()+
				"/"+
				EnumPhone.values()[rand.nextInt(EnumPhone.values().length)]);
		address.setEmail(
				EnumFirstName.values()[rand.nextInt(EnumFirstName.values().length)]+
				"."+
				EnumLastName.values()[rand.nextInt(EnumLastName.values().length)]+
				"@gmail.com"
				);
		// TO-DO:
		// address.setMobilePhone();
		// address.setfax();
		return address;
	}
}
