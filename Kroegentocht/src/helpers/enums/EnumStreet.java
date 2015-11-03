/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Enum of streets, to be used in factories to inisiate objects
 */

package helpers.enums;

public enum EnumStreet {
	DORPSTRAAT("Dorpstraat"),
	HOOGSTRAAT("Hoogstraat"),
	SCHOOLSTRAAT("Schoolstraat"),
	STATIONSTRAAT("Stationstraat"),
	BERGSTRAAT("bergstraat"),
	KERKSTRAAT("Kerkstraat");
	
	private String straat;
	
	public String getStreet (){
		return straat;
	}
	
	public void setStreet(String straat){
		this.straat = straat;
	}
	
	private EnumStreet (String street){
		setStreet(street);
	}
}
