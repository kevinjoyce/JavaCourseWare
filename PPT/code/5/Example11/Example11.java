public class Example11
{
	public static void main(String[] args){
		TicketWindow tw = new TicketWindow();
		new Thread(tw, "窗口1").start();
		new Thread(tw, "窗口2").start();
		new Thread(tw, "窗口3").start();
		new Thread(tw, "窗口4").start();
	}
}
class TicketWindow implements Runnable
{
	private int tickets = 100;
	Object lock = new Object();
	public void run(){
		while(true){
			synchronized(lock){
				if(tickets > 0){
					try{
						Thread.sleep(10);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					Thread th = Thread.currentThread();
					String th_name = th.getName();
					System.out.println(th_name + "正在发售" + tickets-- +"张票");
				}
			}
		}
	}
}