package cn.itcast.application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;
/**
 * ģ������ϵͳ�е��˻���Ϣ���൱�����ݿ�Ĺ���
 * @author Administrator
 */
public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String, User> users = new HashMap<String, User>();
	private FileInputStream fs;
	private FileOutputStream fos;
	private FileReader reader;
	private FileWriter writer;
	
	private DBUtil() {
		//getUsersFromInputStream("user.dat");
		getUsersFromReader("user.dat");
	}
	//�ַ�����ʽ��ȡ�ļ�
	private void getUsersFromReader(String fileName) {
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String userString;
		try {
			while((userString=br.readLine()) != null) {
				processUserString(userString);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ����ʽ����ģʽ
	public static DBUtil getInstance() {
		if (instance == null) {
			synchronized (DBUtil.class) {
				if (instance == null) {
					instance = new DBUtil();
				}
			}
		}
		return instance;
	}
	// �������п��Ż�ȡ��Ӧ�����˻�����Ϣ
	public User getUser(String cardId) {
		User user = (User) users.get(cardId);
		return user;
	}
	// ��ȡ�����˻�����Ϣ
	public HashMap<String, User> getUsers() {
		return users;
	}
	//����һ���û�
	public void addUser(User u) {
		users.put(u.getCardId(), u);
	}
	
	//���̲��������ֽ���
	public void update() {
		Set<String> userSet = users.keySet();
		StringBuffer uStringBuffer = new StringBuffer();
		for(String cardId:userSet) {
			User u = (User)users.get(cardId);
			String uString = u.getCardId() + ","
					+ u.getCardPwd() + ","
					+ u.getUserName() + ","
					+ u.getCall() + ","
					+ u.getAccount() + "\r\n";
			uStringBuffer.append(uString);			
		}
		putUsersToFile(uStringBuffer.toString(), "user.dat");
	}
	//���̲��������ַ���
	public void update2() {
		Set<String> userSet = users.keySet();
		try {
			writer = new FileWriter("user.dat");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for (String cardId : userSet) {
			User u = (User) users.get(cardId);
			String uString = u.getCardId() + "," + u.getCardPwd() + "," + u.getUserName() + "," + u.getCall() + ","
					+ u.getAccount() + "\r\n";
			try {
				bfw.write(uString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (bfw != null)
			try {
				bfw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (writer != null)
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	//д���ļ��ĺ���
	private void putUsersToFile(String uString, String osName) {
		try {
			fos = new FileOutputStream(osName);
			try {
				fos.write(uString.getBytes("GBK"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	//�ָ�������û��ַ���
	public void processUserString(String userString) {
		String [] userFields = userString.split(",");
		User u = new User();
		u.setCardId(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Integer.parseInt(userFields[4]));
		users.put(u.getCardId(), u);
	}
	//��ȡ�ļ�����InputStream����ʽ��ȡ
	private void getUsersFromInputStream(String isName) {
		try {			
			fs = new FileInputStream(isName);
			byte[] content = new byte[1024];
			int i=0;
			int conInteger = 0;
			while(true){
				try {
					conInteger = fs.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				if(-1 == conInteger){
					break;
				}else if('\r' == (char)conInteger || '\n' == (char)conInteger){
					try {
						if('\r' == (char)conInteger) {
							this.processUserString(new String(content, "GBK").trim());
							i=0;
						}
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}else{
					content[i] = (byte)conInteger;
					i++;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(fs != null){
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
	}
}
