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
			System.out.println("用户不存在");
			return;
		} else if (student.getStudentPassword().equals(studentPassword)) {
			System.out.println("登录成功");
		} else {
			System.out.println("密码不正确");
			return;
		}

	}
}
