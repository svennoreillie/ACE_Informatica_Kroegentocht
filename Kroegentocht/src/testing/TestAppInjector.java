/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 08/11/2015
 * @Project: KroegenTocht
 * @Purpose: Zet test bindings voor de Dependency injection
 */

package testing;
 
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

import helpers.Log4JTypeListener;
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

 
public class TestAppInjector extends AbstractModule {
 

    protected void configure() {

    	bindListener(Matchers.any(), new Log4JTypeListener());

    	bind(MainWindowService.class).to(MainWindow.class);
    	bind(AnalyseWindowService.class).to(AnalyseWindow.class);
    	bind(InputEstablismentWindowService.class).to(InputEstablishmentWindow.class);
    	bind(InputVisitWindowService.class).to(InputVisitWindow.class);
        bind(DataAnalyseService.class).to(DataAnalyse.class);
        
        bind(new TypeLiteral<ClassWrapperService<TestModel>>(){}).to(TestModelClassWrapper.class).asEagerSingleton();
        bind(new TypeLiteral<GenericDataService<Visit>>(){}).to(TestDataService.class).asEagerSingleton();   
        bind(new TypeLiteral<StreamGeneratorService<TestModel>>(){}).to(new TypeLiteral<StreamGenerator<TestModel>>(){}).asEagerSingleton();
        bind(new TypeLiteral<DataChangedEventFiringService<TestModel>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<TestModel>>(){}).asEagerSingleton();
    
    
        
        bind(new TypeLiteral<ClassWrapperService<Establishment>>(){}).to(EstablishmentClassWrapper.class).asEagerSingleton();
        bind(new TypeLiteral<ClassWrapperService<TypeOfBusiness>>(){}).to(TypeOfBusinessClassWrapper.class).asEagerSingleton();

        bind(new TypeLiteral<GenericDataService<Establishment>>(){}).to(new TypeLiteral<GenericData<Establishment>>(){}).asEagerSingleton();
        bind(new TypeLiteral<GenericDataService<TypeOfBusiness>>(){}).to(new TypeLiteral<GenericData<TypeOfBusiness>>(){}).asEagerSingleton();
        
        bind(new TypeLiteral<StreamGeneratorService<Establishment>>(){}).to(new TypeLiteral<StreamGenerator<Establishment>>(){}).asEagerSingleton();
        bind(new TypeLiteral<StreamGeneratorService<TypeOfBusiness>>(){}).to(new TypeLiteral<StreamGenerator<TypeOfBusiness>>(){}).asEagerSingleton();
    
        bind(new TypeLiteral<DataChangedEventFiringService<Establishment>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<Establishment>>(){}).asEagerSingleton();
        bind(new TypeLiteral<DataChangedEventFiringService<TypeOfBusiness>>(){}).to(new TypeLiteral<DataChangedEventFiringSource<TypeOfBusiness>>(){}).asEagerSingleton();
    
    }
}


