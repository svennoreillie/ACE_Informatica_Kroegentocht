/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Opstartklasse
 */

package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import helpers.DBException;
import helpers.DBMissingException;
import helpers.InjectLogger;
import model.Establishment;
import services.GenericDataService;
import view.AnalyseWindow;
import view.InputEstablismentWindowService;
import view.MainWindow;

public class App {

	public static void main(String[] args) throws Exception {
		//Registreren van alle services
		Injector i = Guice.createInjector(new AppInjector());        
		StartUpDataControle startUpDataControle = i.getInstance(StartUpDataControle.class);
		startUpDataControle.DataControle();
		
		MainWindow mainView = i.getInstance(MainWindow.class);
		mainView.Show();
		
		
		
	}
	
}
