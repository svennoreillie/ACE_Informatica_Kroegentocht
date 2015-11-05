/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 05/11/2015
 * @Project: KroegenTocht
 * @Purpose: Class wrapper voor in unit tests de streamgenerator te kunnen testen
 */

package testing;

import services.classwrappers.ClassWrapperService;

public class TestModelClassWrapper implements ClassWrapperService<TestModel> {

	@Override
	public Class<TestModel> getModelClass() {
		return TestModel.class;
	}

}
