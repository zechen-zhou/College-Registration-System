import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This is a subclass of person
 * 
 * @author Zechen Zhou
 *
 */
public class Student extends Person {
	protected int studentNumber;
	protected String programName;
	protected double gpa;

	private void readMarks(Scanner input) {
		int num = 0;
		try {
			System.out.print("Enter number of courses: ");
			num = input.nextInt();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		} finally {
			input.nextLine();
		}
		double[] grades = new double[num];
		for (int i = 1; i <= num; i++) {
			System.out.print("Enter mark " + i + ": ");
			grades[i - 1] = input.nextDouble();
		}
		calculateGpa(grades);
	}

	private void calculateGpa(double[] grade) {
		double total = 0.0;
		for (int i = 0; i < grade.length; i++) {
			total += grade[i];
		}
		this.gpa = total / ((grade.length) * 25);
		// 25 is Total Normative Hours for each class.
	}

	@Override
	/**
	 * This method is to read details from the user.
	 * 
	 * @param input refers System.in to read from the keyword.
	 */
	public void readInfo(Scanner input) { // The body of readInfo() is provided here
		try {
			System.out.print("Enter program name: ");
			this.programName = input.nextLine();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		}
		try {
			System.out.print("Enter student number: ");
			this.studentNumber = input.nextInt();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		} finally {
			input.nextLine();
		}

		try {
			System.out.print("Enter first name: ");
			super.firstName = input.nextLine();
		} catch (NoSuchElementException e) {
			System.err.println("******No Such Element Exception******");
		} catch (IllegalStateException e) {
			System.err.println("******Illegal State Exception******");
		}
		try {
			System.out.print("Enter last name: ");
			super.lastName = input.nextLine();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		}
		try {
			System.out.print("Enter email Id: ");
			super.emailId = input.nextLine();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		}

		try {
			System.out.print("Enter phone number: ");
			super.phoneNumber = input.nextLong();
		} catch (Exception e) {
			System.err.println("******Input mismatch exception******");
		} finally {
			input.nextLine();
		}
		readMarks(input);
	}

	@Override
	/**
	 * This method is to print student basic information.
	 */
	public void printInfo() { // The body of printInfo() is provided here
		System.out.printf("%13s", this.programName + "|");
		System.out.printf("%9s", this.studentNumber + "|");
		System.out.printf("%16s", (this.firstName + " " + this.lastName) + "|");
		System.out.printf("%16s", this.emailId + "|");
		System.out.printf("%15s", this.phoneNumber + "|");
		System.out.printf("%6s", (String.format("%.2f", this.gpa)) + "|");
	}

	/**
	 * This method is to read details from the file.
	 * 
	 * @param input refers System.in to read from the keyword.
	 */
	public void readFile(Scanner input) {
		this.studentNumber = input.nextInt();
		super.firstName = input.next();
		super.lastName = input.next();
		super.emailId = input.next();
		super.phoneNumber = input.nextInt();
		this.programName = input.next();
		this.gpa = input.nextDouble();
	}
}
