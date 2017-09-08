class Outer
{
	private int num = 4;
	private static int staticNum = 6;
	public void test(){
		Inner inner = new Inner();
		inner.show();
	}
	class Inner
	{
		void show(){
			System.out.println("num = " + num);
		}
	}
	static class StaticInner
	{
		void show(){
			System.out.println("staticNum = " + staticNum);
		}
	}
}

public class TestOuterInner
{
	public static void main(String[] args){
		Outer outer = new Outer();
		outer.test();
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
		Outer.StaticInner staticInner = new Outer.StaticInner();
		staticInner.show();
	}
}