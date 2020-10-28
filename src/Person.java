import java.util.Scanner;

/**
 * This is a abstract person class.
 * 
 * @author Zechen Zhou
 *
 */
public abstract class Person {

	protected String firstName;
	protected String lastName;
	protected String emailId;
	protected long phoneNumber;

	/**
	 * This method is to read details from the user.
	 * 
	 * @param input refers System.in to read from the keyword.
	 */
	public abstract void readInfo(Scanner input);

	/**
	 * This method is to print student basic information.
	 */
	public abstract void printInfo();
}
