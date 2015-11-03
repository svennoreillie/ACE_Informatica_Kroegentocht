/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Enum of phone numbers exclusive prefix and country code, to be used in factories to initiate objects
 */

package helpers.enums;

public enum EnumPhone {
	P1("345678"),
	P2("789123"),
	P3("123456"),
	P4("258963"),
	P5("369741"),
	P6("258741"),
	P7("456321"),
	P8("489324"),
	P9("654987");
	
	private String phone;
	
	public String getPhone () {
		return phone;
	}

	public void setPhone (String phone){
		this.phone = phone;
	}
	
	private EnumPhone (String phone){
		setPhone(phone);
	}
}
