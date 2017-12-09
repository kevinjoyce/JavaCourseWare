import java.util.Random;
class LoginUser implements Runnable{
	private UserPool userPool;
	private String userName;
	LoginUser(UserPool userPool){
		this.userPool = userPool;
	}
	public void run() {
		while(true) {
			Random r = new Random();
			try {
				Thread.sleep(r.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userName = String.valueOf(r.nextInt(100));
			userPool.put(userName);
		}
			
	}
}
