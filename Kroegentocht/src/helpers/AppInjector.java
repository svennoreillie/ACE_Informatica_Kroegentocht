/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Zet bindings voor de Dependency injection
 */

package helpers;
 
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;

import model.*;
import services.*;
import services.classwrappers.AddressClassWrapper;
import services.classwrappers.ClassWrapperService;
import services.classwrappers.EstablishmentClassWrapper;
import services.classwrappers.TypeOfBusinessClassWrapper;
import services.classwrappers.VisitClassWrapper;
import view.MainWindow;

 
public class AppInjector extends AbstractModule {
 

    protected void configure() {

    	bindListener(Matchers.any(), new Log4JTypeListener());
    	
    	bind(MainWindow.class).toInstance(new MainWindow());
    	
        bind(DataAnalyseService.class).to(DataAnalyse.class);
        
        bind(new TypeLiteral<ClassWrapperService<Visit>>(){}).to(VisitClassWrapper.class);
        bind(new TypeLiteral<ClassWrapperService<Address>>(){}).to(AddressClassWrapper.class);
        bind(new TypeLiteral<ClassWrapperService<Establishment>>(){}).to(EstablishmentClassWrapper.class);
        bind(new TypeLiteral<ClassWrapperService<TypeOfBusiness>>(){}).to(TypeOfBusinessClassWrapper.class);

        bind(new TypeLiteral<GenericDataService<Visit>>(){}).to(new TypeLiteral<GenericData<Visit>>(){});
        bind(new TypeLiteral<GenericDataService<Address>>(){}).to(new TypeLiteral<GenericData<Address>>(){});
        bind(new TypeLiteral<GenericDataService<Establishment>>(){}).to(new TypeLiteral<GenericData<Establishment>>(){});
        bind(new TypeLiteral<GenericDataService<TypeOfBusiness>>(){}).to(new TypeLiteral<GenericData<TypeOfBusiness>>(){});
        
        bind(new TypeLiteral<StreamGeneratorService<Visit>>(){}).to(new TypeLiteral<StreamGenerator<Visit>>(){});
        bind(new TypeLiteral<StreamGeneratorService<Address>>(){}).to(new TypeLiteral<StreamGenerator<Address>>(){});
        bind(new TypeLiteral<StreamGeneratorService<Establishment>>(){}).to(new TypeLiteral<StreamGenerator<Establishment>>(){});
        bind(new TypeLiteral<StreamGeneratorService<TypeOfBusiness>>(){}).to(new TypeLiteral<StreamGenerator<TypeOfBusiness>>(){});
    }


 
}


