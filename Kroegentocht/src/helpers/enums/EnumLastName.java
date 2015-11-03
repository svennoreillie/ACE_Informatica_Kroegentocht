package helpers.enums;

public enum EnumLastName {
	JANSSEN("Janssen"),
	PEETERS("Peeters"),
	MAES("Maes"),
	SMETS("Smets"),
	DECLERQ("Declerq"),
	CLAES("Claes");
	
	private String lastName;
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName (String lastName){
		this.lastName = lastName;
	}
	
	private EnumLastName (String lastName){
		setLastName(lastName);
	}

}
