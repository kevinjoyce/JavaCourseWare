class Animal{
	public Animal(){
		System.out.println("我只是一只动物");
	}
	//有带参数的构造方法，系统默认提供的无参数构造方法就失效了，除非你自行提供。
	public Animal(String name){
		System.out.println("我是一只"+name);
	}
}
class Dog extends Animal{
	public Dog(){
		//此处不写代码，相当于写上了super();而super()这个无参的父类构造方法，现在已经有了。
		
	}
	
}
public class Example05{
	public static void main(String[] args){
		Dog dog = new Dog();
	}
}