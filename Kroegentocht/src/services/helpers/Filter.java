/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Filter voor analyse
 */

package services.helpers;

import java.util.GregorianCalendar;

import model.TypeOfBusiness;

public class Filter {
	
	private TypeOfBusiness businessType;
	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	
	
	public TypeOfBusiness getBusinessType() {
		return businessType;
	}
	public void setBusinessType(TypeOfBusiness businessType) {
		this.businessType = businessType;
	}
	public GregorianCalendar getStartDate() {
		return startDate;
	}
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	public GregorianCalendar getEndDate() {
		return endDate;
	}
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessType == null) ? 0 : businessType.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Filter other = (Filter) obj;
		if (businessType == null) {
			if (other.businessType != null)
				return false;
		} else if (!businessType.equals(other.businessType))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	
	
}
