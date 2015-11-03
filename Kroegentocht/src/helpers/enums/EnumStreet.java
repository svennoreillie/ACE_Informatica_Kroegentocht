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
