/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: event controller, houd gekoppelde objecten bij en vuurt events af
 */

package services.events;

import java.util.Enumeration;
import java.util.Vector;

import com.google.inject.Singleton;

import model.ModelBase;

@Singleton
public class DataChangedEventFiringSource<T extends ModelBase> implements DataChangedEventFiringService<T> {

    protected Vector<DataChangedEvent<T>> _listeners;


    @Override
	public void addListener(DataChangedEvent<T> listener)
    {
        if (_listeners == null)
            _listeners = new Vector<DataChangedEvent<T>>();
             
        _listeners.addElement(listener);
    }

    @Override
	public void removeListener(DataChangedEvent<T> listener)
    {
        if (_listeners == null) return;             
        _listeners.removeElement(listener);
    }

    @Override
	public void fireAdded(T model)
    {
        if (_listeners != null && !_listeners.isEmpty())
        {
            Enumeration<DataChangedEvent<T>> e = _listeners.elements();
            while (e.hasMoreElements())
            {
            	DataChangedEvent<T> event = (DataChangedEvent<T>)e.nextElement();
            	event.EntityAdded(model);
            }
        }
    }

}