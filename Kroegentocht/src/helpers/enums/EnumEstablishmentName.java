package helpers.enums;

public enum EnumEstablishmentName {
	
		FARRAO("Farrao"),
		LOUVAINLOUVAIN("Louvain Louvain"),
		BIJVETTIGEJAN("Bij Vettige Jan"),
		DEWERELD("De wereld"),
		DENUIVER("Den Uiver"),
		ALLEE("Alee");
		
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
