/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Etablissement model, voorziet een adres en soort van etablissment
 */

package model;

public class Establishment extends ModelBase {


	private static final long serialVersionUID = 2149782377134976844L;

	private TypeOfBusiness BusinessType;
	private Address Address;
	private String Name;

	public TypeOfBusiness getBusinessType() {
		return BusinessType;
	}
	public void setBusinessType(TypeOfBusiness businessType) {
		BusinessType = businessType;
	}
	public Address getAddress() {
		return Address;
	}
	public void setAddress(Address address) {
		Address = address;
	}
	public String getName(){
		return Name;
	}
	public void setName(String name){
		Name = name;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Address == null) ? 0 : Address.hashCode());
		result = prime * result + ((BusinessType == null) ? 0 : BusinessType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Establishment other = (Establishment) obj;
		if (Address == null) {
			if (other.Address != null)
				return false;
		} else if (!Address.equals(other.Address))
			return false;
		if (BusinessType == null) {
			if (other.BusinessType != null)
				return false;
		} else if (!BusinessType.equals(other.BusinessType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return this.Name;
	}
	
	
	
}
