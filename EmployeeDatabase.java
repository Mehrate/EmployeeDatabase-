/**
 * 
 * This is a class of EmployeeDatabase, that keep the track of the number of
 * employees stored in metrostate.it has a constructor,and method that
 * add,edit,delete and search. course: ICS 240 summer 2019
 * 
 * @author: Mehrate Gemeda
 * @version: 1.0
 * @since: 06/25/2019
 * @Source: Itroduction_to_Java Programming_Comprehensive_Version copy(book) by
 *          by Daniel Liang
 */
public class EmployeeDatabase {

	

	public EmployeeLogin employeeDepartment[];
	private int numberOfEmployees;
    private String classname;
	/**
	 * a constructor which accept an argument the list size
	 * 
	 * @param: maxNumber
	 * @return:
	 * @throws: Illegal number of employee size
	 */
	public EmployeeDatabase(int maxNumber) {
		if (maxNumber < 0)
			throw new IllegalArgumentException("illegal number of employee size");
		employeeDepartment = new EmployeeLogin[maxNumber];
		numberOfEmployees = 0;
	}
	public EmployeeDatabase(String classname) {
		this.classname = classname;
	}

	public EmployeeDatabase(Object em) {
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * first check if the the capacity of the array is the same number of the data
	 * already stored if it is double the capacity Get a data from the argument and
	 * store it in the array
	 * 
	 * @param: userName,jobTitle,passWord,hourlyRate,totalTimeWorked
	 * @return 
	 * @throws: none
	 */
	public Object add(String userName, String jobTitle, String password, double hourlyRate, int totalTimeWorked) {
		if (numberOfEmployees == employeeDepartment.length) {
			ensureCapacity((numberOfEmployees + 1) * 2);
		}

		return employeeDepartment[numberOfEmployees++] = new EmployeeLogin(userName, jobTitle, password, hourlyRate,
				totalTimeWorked);
	}

	/**
	 * a method that search for a matching username given from the argument.
	 * 
	 * @param: findEmployeeName
	 * @return: null
	 * @throws: none
	 */

	public EmployeeLogin findEmployee(String findEmployeeName) {

		for (int j = 0; j < numberOfEmployees; j++) {
			if (employeeDepartment[j] != null && employeeDepartment[j].getUserName().equals(findEmployeeName))
				return employeeDepartment[j];
		}
		return null;
	}

	/**
	 * a method that search for a matching username given from the argument and
	 * remove the user from the list.
	 * 
	 * @param: employeeName
	 * @return: true
	 * @throws: none
	 */

	public boolean remove(String employeeName) {

		int i;
		for (i = 0; i < numberOfEmployees; i++) {

			if (employeeDepartment[i] != null && employeeDepartment[i].getUserName().equals(employeeName))
				employeeDepartment[i] = employeeDepartment[numberOfEmployees - 1];

			numberOfEmployees--;
			break;
		}
		if (i == numberOfEmployees - 1) {

		}
		return true;
	}

	/**
	 * a method that search for a matching username given from the argument and edit
	 * the user account from the list.
	 * 
	 * @param: userName,jobTitle,passWord,hourlyRate,totalTimeWorked
	 * @return: null
	 * @throws: none
	 */

	public EmployeeLogin editEmployees(String userName, String jobTitle, String password, double hourlyRate,
			int totalTimeWorked) {
		int j;
		for (j = 0; j < numberOfEmployees; j++) {
			if (employeeDepartment[j] != null && employeeDepartment[j].getUserName().equals(userName))
				employeeDepartment[j] = employeeDepartment[numberOfEmployees - 1];
			numberOfEmployees--;
			break;
		}
		if (j == numberOfEmployees - 1) {
		}
		employeeDepartment[numberOfEmployees++] = new EmployeeLogin(userName, jobTitle, password, hourlyRate,
				totalTimeWorked);
		return null;
	}

	/**
	 * change the current capacity of the array
	 * 
	 * @param: minimumCapacity
	 * @return: none
	 * @throws: none
	 */
	private void ensureCapacity(int minimumCapacity) {
		EmployeeLogin[] biggerArray;
		if (employeeDepartment.length < minimumCapacity) {
			biggerArray = new EmployeeLogin[minimumCapacity];
			System.arraycopy(employeeDepartment, 0, biggerArray, 0, numberOfEmployees);
			employeeDepartment = biggerArray;
		}

	}

	/**
	 * toString method which returns a formatted string with information about the
	 * object
	 * 
	 * @param: none
	 * @return: results
	 * @throws: none
	 */
	public String toString() {
		String results = " ";
		for (int i = 0; i < numberOfEmployees; i++)
			results += employeeDepartment[i].toString();

		return results;
	}

}
