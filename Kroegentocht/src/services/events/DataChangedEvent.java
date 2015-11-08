/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: event interface voor wijzigingen op database
 */

package services.events;

import model.ModelBase;

public interface DataChangedEvent<T extends ModelBase> {
	void EntityAdded(T entity);
}
