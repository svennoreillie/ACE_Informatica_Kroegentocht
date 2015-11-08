/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: event interface voor wijzigingen op database
 */

package services.events;

import model.ModelBase;

public interface DataChangedEventFiringService<T extends ModelBase> {

	void addListener(DataChangedEvent<T> listener);

	void removeListener(DataChangedEvent<T> listener);

	void fireAdded(T model);

}