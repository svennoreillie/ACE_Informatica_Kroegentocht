/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 05/11/2015
 * @Project: KroegenTocht
 * @Purpose: Helper klasse voor logger te kunnen injecteren, 
 * zoekt alle fields van geregistreerde klasses af op @InjectLogger interface en van type Logger om deze vervolgens op te vullen 
 */

package helpers;

import java.lang.reflect.Field;

import org.apache.logging.log4j.Logger;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class Log4JTypeListener implements TypeListener {
    public <T> void hear(TypeLiteral<T> typeLiteral, TypeEncounter<T> typeEncounter) {
      Class<?> clazz = typeLiteral.getRawType();
      while (clazz != null) {
        for (Field field : clazz.getDeclaredFields()) {
          if (field.getType() == Logger.class &&
            field.isAnnotationPresent(InjectLogger.class)) {
            typeEncounter.register(new Log4JMembersInjector<T>(field));
          }
        }
        clazz = clazz.getSuperclass();
      }
    }
  }