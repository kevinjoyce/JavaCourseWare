package ui;

import java.util.Scanner;

import controller.StudentController;

public class LoginUI {
	private Scanner scanner;
	private String studentName;
	private String studentPassword;
	private StudentController studentController;

	public void load() {
		System.out.println("������ѧ�ţ�");
		scanner = new Scanner(System.in);
		studentName = scanner.nextLine();
		System.out.println("���������룺");
		studentPassword = scanner.nextLine();
		studentController = new StudentController();
		studentController.login(studentName, studentPassword);
	}
}
