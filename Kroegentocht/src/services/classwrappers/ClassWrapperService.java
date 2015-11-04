package services.classwrappers;

import model.ModelBase;

public interface ClassWrapperService<T extends ModelBase> {
	Class<T> getModelClass();
}
