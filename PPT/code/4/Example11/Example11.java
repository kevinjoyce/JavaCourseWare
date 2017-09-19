interface Animal{//接口中所有的方法都是抽象的。将来是要被其他类实现的。
	int ID=1;
	void run();
	void breathe();
}
class Dog implements Animal{
	public void breathe(){
		System.out.println("狗在呼吸");
	}
	public void run(){
		System.out.println("狗在跑");
	}
}
public class Example11{
	public static void main(String[] args){
		Dog dog = new Dog();
		dog.breathe();
		dog.run();
	}
}