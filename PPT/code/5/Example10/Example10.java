public class Example10
{
	public static void main(String[] args){
		Thread t = new Thread(new EmergencyThread(), "线程一");
		t.start();

		for(int i = 1; i < 6; i++){
			System.out.println(Thread.currentThread().getName()+"输入" + i);
			if(i == 2){
				try{
					t.join();//t对应的线程在此插队，当前线程阻塞。
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			try{
				Thread.sleep(500);//线程休眠500毫秒，即半秒
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
class EmergencyThread implements Runnable
{
	public void run(){
		for(int i = 1; i < 6; i++){
			System.out.println(Thread.currentThread().getName()+"输入"+i);
			try{
				Thread.sleep(500);//线程休眠500毫秒，即半秒
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}