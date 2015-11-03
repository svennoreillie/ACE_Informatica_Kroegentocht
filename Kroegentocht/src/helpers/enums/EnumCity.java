/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Enum of city's, to be used in factories to inisiate objects
 */

package helpers.enums;

public enum EnumCity {
	LONDERZEEL("1840","Londerzeel","052"),
	BUGGENHOUT("9255","Buggenhout","052"),
	BIERBEEK("3360","Bierbeek","016"),
	LEUVEN("3000", "Leuven","016"),
	HASSELT("3500","Hasselt","011"),
	GENK("3600", "Genk","089"),
	AARSCHOT("3200","Aarschot","016"),
	KORTRIJK("8500","Kortrijk","056"),
	HEVERLEE("3001","Heverlee","016");
	
	private String zipCode;
	private String city;
	private String prefix;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix){
		this.prefix = prefix;
	}
	
	private EnumCity(String zipCode, String city, String prefix){
		setZipCode(zipCode);
		setCity(city);
		setPrefix(prefix);
	}
}
