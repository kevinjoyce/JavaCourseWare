import java.util.Random;
class LogoutUser implements Runnable{
	private UserPool userPool;
	LogoutUser(UserPool userPool){
		this.userPool = userPool;
	}
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(new Random().nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userPool.get();
		}
	}
}
