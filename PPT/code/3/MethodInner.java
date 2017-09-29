class Outer
{
	private int num = 4;
	public void test(){
		class Inner
		{
			void show(){
				System.out.println("num = "+num);
			}
		}
		Inner in = new Inner();
		in.show();
	}
}

public class MethodInner
{
	public static void main(String[] args){
		Outer out = new Outer();
		out.test();
	}
}