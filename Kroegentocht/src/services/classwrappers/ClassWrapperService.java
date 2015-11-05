/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 05/11/2015
 * @Project: KroegenTocht
 * @Purpose: Generische interface voor classwrappers die modelspecifiek zijn
 */


package services.classwrappers;

import model.ModelBase;

public interface ClassWrapperService<T extends ModelBase> {
	Class<T> getModelClass();
}
