package services.classwrappers;

import model.*;

public class VisitClassWrapper implements ClassWrapperService<Visit> {

	public Class<Visit> getModelClass() {
		return Visit.class;
	}
	
}


