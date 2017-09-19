class Animal{
	String name="animal";
	void shout(){
		System.out.println("this is an animal.");
	}
}
class Dog extends Animal{
	//super关键词的使用
	String name = "dog";
	void shout(){
		super.shout();
	}
	void printName(){
		System.out.println("super name = " + super.name);
		System.out.println("this name = " + this.name);
	}
}
public class Example03{
	public static void main(String[] args){
		Dog dog = new Dog();
		dog.shout();
		dog.printName();
	}
}