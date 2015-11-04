package services.classwrappers;

import model.*;

public class AddressClassWrapper implements ClassWrapperService<Address> {

	public Class<Address> getModelClass() {
		return Address.class;
	}
	
}


