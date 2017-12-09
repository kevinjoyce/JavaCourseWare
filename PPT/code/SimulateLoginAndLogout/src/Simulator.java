
public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserPool userPool = new UserPool();
		LoginUser loginUser = new LoginUser(userPool);
		LogoutUser logoutUser = new LogoutUser(userPool);
		new Thread(loginUser).start();
		new Thread(logoutUser).start();
	}

}
