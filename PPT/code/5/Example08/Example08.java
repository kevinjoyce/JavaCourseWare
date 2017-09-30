public class Example08
{
	public static void main(String[] args){
		new Thread(new SleepThread()).start();
		for(int i = 1; i <=10; i++){
			if(i == 5){
				try{
					Thread.sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
			System.out.println("主线程正在输出" + i);

			try{
					Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
}

class SleepThread implements Runnable
{
	public void run(){
		for(int i = 1; i <=10; i++){
			if(i == 3){
				try{
					Thread.sleep(2000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
			System.out.println("线程一正在输出：" + i);

			try{
					Thread.sleep(500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		
	}
}