package controller;

import dao.StudentDao;
import model.IEntity;
import model.Student;

public class StudentController {
	StudentDao studentDao;
	private Student student;
	public void login(String studentNo, String studentPassword) {

		studentDao = StudentDao.getInstance();
		student = (Student) studentDao.getEntity(studentNo);
		if (student == null) {
			System.out.println("�û�������");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("��¼�ɹ�");
		} else {
			System.out.println("���벻��ȷ");
			return;
		}

	}
}
