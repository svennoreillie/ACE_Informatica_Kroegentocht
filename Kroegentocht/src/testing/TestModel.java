/**
 * @Autor: Sven Noreillie
 * @Team: Team13
 * @Date: 05/11/2015
 * @Project: KroegenTocht
 * @Purpose: test model voor in unit tests de streamgenerator te kunnen testen
 */

package testing;

import model.ModelBase;

public class TestModel extends ModelBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String testString;
	private int testNumber;
	
	public String getTestString() {
		return testString;
	}
	public void setTestString(String testString) {
		this.testString = testString;
	}
	public int getTestNumber() {
		return testNumber;
	}
	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}
	
	
}
