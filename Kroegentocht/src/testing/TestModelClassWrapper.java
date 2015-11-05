package testing;

import services.classwrappers.ClassWrapperService;

public class TestModelClassWrapper implements ClassWrapperService<TestModel> {

	@Override
	public Class<TestModel> getModelClass() {
		return TestModel.class;
	}

}
