import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This is a subclass of Student
 * 
 * @author Zechen Zhou
 *
 */
public class FulltimeStudent extends Student {
	private double tuitionFees;

	/**
	 * This method is to read tuition fees of fulltime student from the user.
	 * 
	 * @param input refers System.in to read from the keyword.
	 */
	public void readInfo(Scanner input) {
		super.readInfo(input);
		try {
//			input.nextLine();
			System.out.print("Enter tution fees: ");
			this.tuitionFees = input.nextDouble();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		} finally {
			input.nextLine();
		}
	}

	/**
	 * This method is to print fulltime student's tuition fees
	 * 
	 * @param input input refers System.in to read from the keyword.
	 */
	public void printInfo() {
		super.printInfo();
		System.out.printf("%9s", (String.format("%.2f", this.tuitionFees)) + "|");
		System.out.println();
	}

	/**
	 * This method is to read tuition fees of fulltime student from the file.
	 * 
	 * @param input input refers System.in to read from the keyword.
	 */
	public void readFile(Scanner input) {
		super.readFile(input);
		this.tuitionFees = input.nextDouble();
	}
}
