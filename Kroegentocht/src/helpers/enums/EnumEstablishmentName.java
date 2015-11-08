/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Enum of establishment names, to be used in factories to initiate objects
 */

package helpers.enums;

public enum EnumEstablishmentName {
	
		Farrao("Farrao"),
		LouvainLouvain("Louvain Louvain"),
		VettigeJan("Bij Vettige Jan"),
		Wereld("De wereld"),
		Uiver("Den Uiver"),
		Alee("Alee");
		
		private String Name;
		
		public String getFirstName(){
			return Name;
		}
		
		public void setFirstName(String firstName){
			this.Name = firstName;
		}
		
		private EnumEstablishmentName (String firstName){
			setFirstName(firstName);
		} 
	
}
