class Student{
	static String schoolName = "Anyang Normal University";
	public static void printSchoolName(){
		System.out.println(schoolName);
	}		
}

public class Example{
	public static void main(String[] args){
		Student.printSchoolName();
	}
}