class Animal{
	//有带参数的构造方法，系统默认提供的无参数构造方法就失效了。
	public Animal(String name){
		System.out.println("我是一只"+name);
	}
}
class Dog extends Animal{
	public Dog(){
		//此处不写调用父类构造方法的代码，相当于写上了super();而super()这个无参的父类构造方法
		//是不存在的。因此此处不写代码，系统会报错。
		super("沙皮狗");//super调用父类的构造方法。写上他就不会报错啦！	
	}
	
}
public class Example04{
	public static void main(String[] args){
		Dog dog = new Dog();
	}
}