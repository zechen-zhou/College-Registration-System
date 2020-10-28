import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class College {
	public int studentCount = 0;
	private String name;
	public ArrayList<Student> students;
	int readFromFileStatus;// check running readFromFile method whether is successful.

	/**
	 * College counstructor initialize the ArrayList.
	 * 
	 * @param name get the name of school from user.
	 * 
	 */
	public College(String name) {
		this.name = name;
		students = new ArrayList<Student>();
	}

	/**
	 * This method is to print title.
	 */
	public void printTitle() {
		System.out.println("\n" + this.name + " - List of Students");
		System.out.println("************************************");
		System.out.printf("%22s", "Program|Student#|");
		System.out.printf("%16s", "Name|");
		System.out.printf("%16s", "Email|");
		System.out.printf("%15s", "Phone|");
		System.out.printf("%6s", "GPA|");
		System.out.printf("%9s", "Fees|");
		System.out.printf("%10s", "Credits|");
		System.out.println();
	}

	public void readStudentsDetails(Scanner input) {
		int type = 0;
		do {
			do {
				try {
					System.out.println("Enter details of student ");
					System.out.println("===========================");
					System.out.println("1 - Fulltime student");
					System.out.println("2 - Parttime student");
					System.out.println("Enter Student type:");
					type = input.nextInt();
				} catch (Exception e) {
//						input.nextLine();
					System.out.println("Sorry, you entered invalid data type.Try again.");
				} finally {
					input.nextLine();
				}
			} while (type != 1 && type != 2);
			if (type == 1) {
				FulltimeStudent fulltime = new FulltimeStudent();
				fulltime.readInfo(input);
				students.add(fulltime);
			} else if (type == 2) {
				ParttimeStudent parttime = new ParttimeStudent();
				parttime.readInfo(input);
				students.add(parttime);
			} else {
				System.out.println("Wrong student type");
			}
		} while (type != 1 && type != 2);
	}

	public void readFromFile(Scanner input) {
		try {
			input = new Scanner(Paths.get("src//students.txt"));
		} catch (IOException ioe) {
			System.out.println("Cannot find the file.Please check the file path.");
			readFromFileStatus = 0;
		}
		while (input.hasNext()) {
			char choice = input.next().charAt(0);
			if (choice == 'f') {
				FulltimeStudent fulltime = new FulltimeStudent();
				fulltime.readFile(input);
				students.add(fulltime);
			}

			else if (choice == 'p') {
				ParttimeStudent parttime = new ParttimeStudent();
				parttime.readFile(input);
				students.add(parttime);
			}
		}
	}

	public void printStudentDetails() {
		for (int i = 0; i < students.size(); i++) {
			students.get(i).printInfo();
		}
	}
}
