import java.util.Scanner;

/**
 * The purpose of this class that include main method, creates an object of
 * College and display a menu that promots users to execute each of the method
 * and promots for user input.
 * 
 * @author Zechen Zhou
 *
 */
public class CollegeSystemTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name of College: ");
		String name = input.nextLine();

		College c1 = new College(name);

		int choice = 0;
		do {
			try {
				System.out.println("\n1. Register Students");
				System.out.println("2. Display Students");
				System.out.println("3. exit");
				System.out.print("Enter your choice: ");
				choice = input.nextInt();
			} catch (Exception e) {
				System.out.println("Sorry, you entered invalid data type.Try again.out");
			} finally {
				input.nextLine();
			}
			if (choice == 1) {
				int optionA = 0;
				do {
					try {
						System.out.println("\n1. Read from file");
						System.out.println("2. Read from the keyboard");
						System.out.print("Enter your onption:");
						optionA = input.nextInt();
					} catch (Exception e) {
						System.out.println("Sorry, you entered invalid data type.Try again");
					} finally {
						input.nextLine();
					}

					if (optionA == 1) {
						c1.readFromFile(input);
					} else if (optionA == 2) {
						c1.readStudentsDetails(input);
					} else
						System.out.println("Please enter a valid menu option.");
					choice = 0;
				} while (optionA != 1 && optionA != 2);
			} else if (choice == 2) {

				if (c1.students.isEmpty()) {
					System.out.println("No students to display....");
				} else {
					c1.printTitle();
					c1.printStudentDetails();
				}
				choice = 0;
			} else if (choice == 3) {
				System.out.println("Goodbye.... Have a nice day");
			} else {
				System.out.println("Please enter a valid menu option.");
			}
		} while (choice != 3);
	}
}
