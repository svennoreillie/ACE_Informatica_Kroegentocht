/**
 * @Autor: Sven Noreillie, Peter Vervoort
 * @Team: Team13
 * @Date: 26/10/2015
 * @Project: KroegenTocht
 * @Purpose: Opstartklasse
 */

package application;

import com.google.inject.Guice;
import com.google.inject.Injector;

import helpers.AppInjector;
import view.Main;

public class App {
	public static void main(String[] args) throws Exception {
		 Injector injector = Guice.createInjector(new AppInjector());        

		
		Main mainView =new Main();
		mainView.Show();
	}

	
}
