/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 02/11/2015
 * @Project: KroegenTocht
 * @Purpose: Zet bindings voor de Dependency injection
 */

package helpers;
 
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import model.*;
import services.*;

 
public class AppInjector extends AbstractModule {
 
    @Override
    protected void configure() {

        bind(DataAnalyseService.class).to(DataAnalyse.class);
        
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
