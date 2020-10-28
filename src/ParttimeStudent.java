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
public class ParttimeStudent extends Student {
	private double courseFeesTotal;
	private double credits;

	/**
	 * This method is to read tuition fees of parttime student from the user.
	 * 
	 * @param input refers System.in to read from the keyword.
	 */
	public void readInfo(Scanner input) {
		super.readInfo(input);
		try {
			System.out.print("Enter total courses fees: ");
			this.courseFeesTotal = input.nextDouble();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		} finally {
			input.nextLine();
		}

		try {
			System.out.print("Enter credit hours: ");
			this.credits = input.nextDouble();
			input.nextLine();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		} finally {
			input.nextLine();
		}
	}

	/**
	 * This method is to print parttime student's tuition fees
	 * 
	 * @param input input refers System.in to read from the keyword.
	 */
	public void printInfo() {
		super.printInfo();
		System.out.printf("%9s", String.format("%.2f", this.courseFeesTotal) + "|");
		System.out.printf("%10s", String.format("%.2f", this.credits) + "|\n");
	}

	/**
	 * This method is to read tuition fees of parttime student from the file.
	 * 
	 * @param input input refers System.in to read from the keyword.
	 */
	public void readFile(Scanner input) {
		super.readFile(input);
		this.courseFeesTotal = input.nextDouble();
		this.credits = input.nextDouble();
	}
}
