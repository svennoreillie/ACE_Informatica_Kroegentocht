/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Model die gebruikt wordt voor een bezoek te registreren
 */

package model;

import java.util.Calendar;

public class Visit extends ModelBase {


	private static final long serialVersionUID = -3604904455350828003L;
	private Establishment Establishment;
	private Calendar Date;
	private int AmountOfConsumptions;
	private int DurationMinutes;
	
	public Establishment getEstablishment() {
		return Establishment;
	}
	public void setEstablishment(Establishment establishment) {
		Establishment = establishment;
	}
	public Calendar getDate() {
		return Date;
	}
	public void setDate(Calendar date) {
		Date = date;
	}
	public int getAmountOfConsumptions() {
		return AmountOfConsumptions;
	}
	public void setAmountOfConsumptions(int amountOfConsumptions) {
		AmountOfConsumptions = amountOfConsumptions;
	}
	public int getDurationMinutes() {
		return DurationMinutes;
	}
	public void setDurationMinutes(int durationMinutes) {
		DurationMinutes = durationMinutes;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AmountOfConsumptions;
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());
		result = prime * result + DurationMinutes;
		result = prime * result + ((Establishment == null) ? 0 : Establishment.hashCode());
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
		Visit other = (Visit) obj;
		if (AmountOfConsumptions != other.AmountOfConsumptions)
			return false;
		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		if (DurationMinutes != other.DurationMinutes)
			return false;
		if (Establishment == null) {
			if (other.Establishment != null)
				return false;
		} else if (!Establishment.equals(other.Establishment))
			return false;
		return true;
	}
	
	
}
