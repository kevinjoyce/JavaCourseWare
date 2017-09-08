class Calculator{ /*Calculator类*/
	/*属性*/
	static String version = "1.0";
	
	//方法，是不是很像C语言中的函数？面向对象中，我们不再提函数，而是说方法。大家可以看到，方法是写在类（class）中的。
	void add(int x, int y){
		System.out.println("x - y = " + (x + y));
	}
	void minus(int x, int y){
		System.out.println("x - y = " + (x - y));
	}
	void multiply(int x, int y){
		System.out.println("x * y = " + (x * y));
	}
	void divide(int x, int y){
		System.out.println("x / y = " + (x / y));
	}
}

public class OOPExample{//程序入口类，又称测试类，顾名思义，是为了帮助测试我们写的Calculator类的类。很拗口吧。
	public static void main(String[] args){//不管程序写得多么复杂，入口都在main这个地方。C语言也是从main开始执行的！
		
		//类实例化为对象c。面向对象编程，我们现在面向了一个对象，对象名叫c  ^_^
		Calculator c = new Calculator();
		
		//通过对象c，调用不同的方法。
		c.add(10, 5);
		c.minus(10, 5);
		c.multiply(10,5);
		c.divide(10,5);
	}
}