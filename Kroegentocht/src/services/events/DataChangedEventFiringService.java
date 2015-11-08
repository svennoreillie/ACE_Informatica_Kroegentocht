package services.events;

import model.ModelBase;

public interface DataChangedEventFiringService<T extends ModelBase> {

	void addListener(DataChangedEvent<T> listener);

	void removeListener(DataChangedEvent<T> listener);

	void fireAdded(T model);

}