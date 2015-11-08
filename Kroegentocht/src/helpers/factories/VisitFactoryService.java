/**
 * @Autor: Peter Vervoort
 * @Team: Team13
 * @Date: 03/11/2015
 * @Project: KroegenTocht
 * @Purpose: Interface of VisitFactory
 */

package helpers.factories;

import java.util.Random;

import helpers.DBException;
import helpers.DBMissingException;
import model.Visit;

public interface VisitFactoryService {

	Visit getVisit(Random rand) throws DBMissingException, DBException;

}