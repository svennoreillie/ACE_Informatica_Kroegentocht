/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Interface om KPIs uit te rekenen
 */

package services;

import helpers.DBException;
import helpers.DBMissingException;
import services.helpers.Filter;

public interface DataAnalyseService {

	int getTotalMinutes(Filter filter) throws DBMissingException, DBException;

	int getAverageMinutes(Filter filter) throws DBMissingException, DBException;

	int getTotalConsumptions(Filter filter) throws DBMissingException, DBException;

	int getLongestVisit(Filter filter) throws DBMissingException, DBException;
	
	int getTotalVisits(Filter filter) throws DBMissingException, DBException;

}