/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Basis voor alle modellen, voorziet een logische delete en id 
 */

package model;

import java.io.Serializable;

public class ModelBase implements Serializable {


	private static final long serialVersionUID = -8546391373858034898L;
	private int id;
	//Hold items are 'logically removed'
	private Boolean hold;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean getHold() {
		return hold;
	}
	public void setHold(Boolean hold) {
		this.hold = hold;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hold == null) ? 0 : hold.hashCode());
		result = prime * result + id;
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
		ModelBase other = (ModelBase) obj;
		if (hold == null) {
			if (other.hold != null)
				return false;
		} else if (!hold.equals(other.hold))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
