/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Enum of types of business, to be used in factories to initiate objects
 */

package helpers.enums;

public enum EnumTypeOfBusiness {
	CAFE("Café"),
	TAVERNE("Taverne"),
	BISTRO("Bistro"),
	BRASSERIE("Brasserie"),
	CAFETARIA("Cafetaria");
	
	private String typeOfBuisiness;
	
	public String getTypeOfBusiness(){
		return typeOfBuisiness;
	}
	
	public void setTypeOfBusiness(String typeOfBusiness){
		this.typeOfBuisiness = typeOfBusiness;
	}
	
	private EnumTypeOfBusiness (String typeOfBusiness){
		setTypeOfBusiness(typeOfBusiness);
	}
}
