/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Levert getallen aan ter analyse op basis van filters
 */

package services;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.InjectLogger;
import model.Visit;
import services.helpers.Filter;

@Singleton
public class DataAnalyse implements DataAnalyseService {

	private GenericDataService<Visit> visitService;

	@InjectLogger Logger logger;
	
	@Inject
	public DataAnalyse(GenericDataService<Visit> visitService) {
		this.visitService = visitService;
	}
	
	public void Show() {
		logger.debug("Show method called");
	}

	@Override
	public int getTotalMinutes(Filter filter) throws DBMissingException, DBException {
		Stream<Visit> list = filterVisits(filter);

		// todo improve this line
		int total = 0;
		for (Visit v : list.collect(Collectors.toList())) {
			total += v.getDurationMinutes();
		}

		return total;
	}

	@Override
	public int getAverageMinutes(Filter filter) throws DBMissingException, DBException {
		Stream<Visit> list = filterVisits(filter);

		// todo improve this line
		int total = 0;
		int count = 0;
		for (Visit v : list.collect(Collectors.toList())) {
			total += v.getDurationMinutes();
			count++;
		}

		if (count == 0) return 0;
		return total / count;
	}

	@Override
	public int getTotalConsumptions(Filter filter) throws DBMissingException, DBException {
		Stream<Visit> list = filterVisits(filter);

		// todo improve this line
		int total = 0;
		for (Visit v : list.collect(Collectors.toList())) {
			total += v.getAmountOfConsumptions();
		}

		return total;
	}

	@Override
	public int getLongestVisit(Filter filter) throws DBMissingException, DBException {
		Stream<Visit> list = filterVisits(filter);

		// todo improve this line
		int total = 0;
		for (Visit v : list.collect(Collectors.toList())) {
			if (total < v.getDurationMinutes()) total = v.getDurationMinutes();
		}

		return total;
	}
	
	private Stream<Visit> filterVisits(Filter filter) throws DBMissingException, DBException {
		Stream<Visit> list = this.visitService.getAll().parallelStream();
		if (filter.getStartDate() != null) {
			list = list.filter(v -> v.getDate().compareTo(filter.getStartDate()) >= 0);
		}
		if (filter.getEndDate() != null) {
			list = list.filter(v -> v.getDate().compareTo(filter.getEndDate()) <= 0);
		}
		
		return list;
	}
}
