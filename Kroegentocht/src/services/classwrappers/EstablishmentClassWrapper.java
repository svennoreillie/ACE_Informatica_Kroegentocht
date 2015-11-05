/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 05/11/2015
 * @Project: KroegenTocht
 * @Purpose: Class nodig in constructor gaat niet voor Guice, deze klasse lost dat op voor elk model
 */

package services.classwrappers;

import model.*;

public class EstablishmentClassWrapper implements ClassWrapperService<Establishment> {

	public Class<Establishment> getModelClass() {
		return Establishment.class;
	}
	
}


