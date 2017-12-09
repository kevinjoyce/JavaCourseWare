
public class UserPool {
	private String[] users = new String[100];
	private int inPos, outPos;
	private int count;
	public synchronized void put(String user) {
		while(count == users.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		users[inPos] = user;
		inPos++;
		if(inPos == users.length) {
			inPos = 0;
		}
		count++;
		System.out.println(user + "�û���¼��"+"��ǰϵͳͬʱ����"+count+"��");		
		this.notify();
	}
	public synchronized void get() {
		while(count == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String userLogout = users[outPos];
		users[outPos] = "";
		outPos++;
		if(outPos == users.length) {
			outPos = 0;
		}
		count--;
		System.out.println(userLogout + "�û�ע����"+"��ǰϵͳͬʱ����"+count+"��");		
		this.notify();
	}
}
