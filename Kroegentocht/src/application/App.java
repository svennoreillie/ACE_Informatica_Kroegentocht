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
import com.google.inject.Injector;

import helpers.AppInjector;
import view.Analyse;
import view.MainWindow;

public class App {
	static Logger log = LogManager.getLogger("default");
	
	public static void main(String[] args) throws Exception {
		// Injector injector = Guice.createInjector(new AppInjector());        

		
		MainWindow mainView =new MainWindow();
		mainView.Show();
		
		log.trace("This is a trace message."); 
		log.debug("This is  a debug message."); 
		log.info("This is an info message."); 
		log.error("This is an error message");
	}

	
}
