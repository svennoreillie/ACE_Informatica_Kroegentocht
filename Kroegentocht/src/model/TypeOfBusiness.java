/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Type van het etablissement, alternatief voor enum gebruik maar wou het dynamisch houden
 */

package model;

public class TypeOfBusiness extends ModelBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8689410206194924971L;
	private String Type;

	public TypeOfBusiness (){}
	
	public TypeOfBusiness (String type){
		setType(type);
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
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
		TypeOfBusiness other = (TypeOfBusiness) obj;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		return true;
	}
	
	@Override
	public String toString(){
		return this.Type;
	}
}
