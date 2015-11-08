package helpers.factories;

import java.util.Random;

import helpers.DBException;
import helpers.DBMissingException;
import model.Visit;

public interface VisitFactoryService {

	Visit getVisit(Random rand) throws DBMissingException, DBException;

}