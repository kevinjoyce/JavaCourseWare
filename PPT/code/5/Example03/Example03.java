public class Example03
{
	public static void main(String[] args){
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
		while(true){
			System.out.println("main 方法在运行");
		}
	}
}

class MyThread implements Runnable
{
	public void run(){
		while(true){
			System.out.println("MyThread run方法运行");
		}
	}
}