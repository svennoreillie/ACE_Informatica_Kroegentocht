/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Enum of first names, to be used in factories to initiate objects
 */

package helpers.enums;

public enum EnumFirstName {
	Jan("Jan"),
	Piet("Piet"),
	Paul("Paul"),
	Els("Els"),
	An("An"),
	Jef("Jef"),
	Fien("Fien");
	
	private String firstName;
	
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	private EnumFirstName (String firstName){
		setFirstName(firstName);
	}

}
