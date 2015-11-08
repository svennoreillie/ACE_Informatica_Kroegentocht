/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Zet bindings voor de Dependency injection
 */

package application;
 
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

import helpers.Log4JTypeListener;
import helpers.factories.VisitFactory;
import helpers.factories.VisitFactoryService;
import model.*;
import services.*;
import services.classwrappers.AddressClassWrapper;
import services.classwrappers.ClassWrapperService;
import services.classwrappers.EstablishmentClassWrapper;
import services.classwrappers.TypeOfBusinessClassWrapper;
import services.classwrappers.VisitClassWrapper;
import services.events.DataChangedEventFiringService;
import services.events.DataChangedEventFiringSource;
import view.*;

 
public class AppInjector extends AbstractModule {
 

    protected void configure() {

    	bindListener(Matchers.any(), new Log4JTypeListener());
    	
    	
    	bind(MainWindowService.class).to(MainWindow.class);
    	bind(AnalyseWindowService.class).to(AnalyseWindow.class);
    	bind(InputEstablismentWindowService.class).to(InputEstablishmentWindow.class);
    	bind(InputVisitWindowService.class).to(InputVisitWindow.class);
        bind(DataAnalyseService.class).to(DataAnalyse.class);
        bind(VisitFactoryService.class).to(VisitFactory.class);
        
        bind(new TypeLiteral<ClassWrapperService<Visit>>(){}).to(VisitClassWrapper.class).asEagerSingleton();
        bind(new TypeLiteral<ClassWrapperService<Address>>(){}).to(AddressClassWrapper.class).asEagerSingleton();
        bind(new TypeLiteral<ClassWrapperService<Establishment>>(){}).to(EstablishmentClassWrapper.class).asEagerSingleton();
        bind(new TypeLiteral<ClassWrapperService<TypeOfBusiness>>(){}).to(TypeOfBusinessClassWrapper.class).asEagerSingleton();

        bind(new TypeLiteral<GenericDataService<Visit>>(){}).to(new TypeLiteral<GenericData<Visit>>(){}).asEagerSingleton();
        bind(new TypeLiteral<GenericDataService<Address>>(){}).to(new TypeLiteral<GenericData<Address>>(){}).asEagerSingleton();
        bind(new TypeLiteral<GenericDataService<Establishment>>(){}).to(new TypeLiteral<GenericData<Establishment>>(){}).asEagerSingleton();
        bind(new TypeLiteral<GenericDataService<TypeOfBusiness>>(){}).to(new TypeLiteral<GenericData<TypeOfBusiness>>(){}).asEagerSingleton();
        
        bind(new TypeLiteral<StreamGeneratorService<Visit>>(){}).to(new TypeLiteral<StreamGenerator<Visit>>(){}).asEagerSingleton();
        bind(new TypeLiteral<StreamGeneratorService<Address>>(){}).to(new TypeLiteral<StreamGenerator<Address>>(){}).asEagerSingleton();
        bind(new TypeLiteral<StreamGeneratorService<Establishment>>(){}).to(new TypeLiteral<StreamGenerator<Establishment>>(){}).asEagerSingleton();
        bind(new TypeLiteral<StreamGeneratorService<TypeOfBusiness>>(){}).to(new TypeLiteral<StreamGenerator<TypeOfBusiness>>(){}).asEagerSingleton();
        
        
    
        bind(new TypeLiteral<DataChangedEventFiringService<Visit>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<Visit>>(){}).asEagerSingleton();
        bind(new TypeLiteral<DataChangedEventFiringService<Address>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<Address>>(){}).asEagerSingleton();
        bind(new TypeLiteral<DataChangedEventFiringService<Establishment>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<Establishment>>(){}).asEagerSingleton();
        bind(new TypeLiteral<DataChangedEventFiringService<TypeOfBusiness>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<TypeOfBusiness>>(){}).asEagerSingleton();
    }


 
}


