import java.util.*;
import java.io.*;
public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	private FileInputStream fs;
	private FileOutputStream fos;
	private FileReader reader;
	private FileWriter writer;
	private  DBUtil(){
		getUsersFromInputStream("user.dat");
		//getUserFromReader("user.dat");
	}
	private void getUsersFromInputStream(String isName){
	    try {
			fs = new FileInputStream(isName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] content = new byte[1024];
		int i = 0;
		int conInteger = 0;
		while(true){
			try{
				 conInteger = fs.read();
		}catch(IOException e){
				e.printStackTrace();
			}
		if(-1 == conInteger){
			break;
		    }else if('\r' == (char)conInteger || '\n' == (char)conInteger){
		    	try{
		    	this.processUserString(new String(content,"GBK").trim());
		    	i=0;
		    } catch (UnsupportedEncodingException e){
		    	e.printStackTrace();
		    }
				continue;
		}else{
			content[i] = (byte)conInteger;
			i++;
		  }
	   }
		try {
			fs.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 private void processUserString(String userString) {
		// TODO Auto-generated method stub
		String [] userFields = userString.split(",");
		User u = new User();
		u.setCardld(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Integer.parseInt(userFields[4]));
		users.put(u.getCardId(), u);
		}
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
	public User getUser(String cardId){
		User user = (User) users.get(cardId);
		return user;
	}
	public HashMap<String, User> getUsers(){
		return users;
	}
	public void addUser(User u){
		users.put(u.getCardId(), u);
	}
	public void update() throws IOException{
	Set<String> userSet = users.keySet();
	StringBuffer uStringBuffer = new StringBuffer();
	for(String cardId:userSet){
		User u = (User)users.get(cardId);
		String uString = u.getCardId()+","+ u.getCardPwd() +","+u.getUserName()+","+ u.getCall(null) +","+u.getAccount()+"\r\n";
	     }
	try {
		putUsersToFiles(uStringBuffer.toString(),"user.date");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	}
	private void putUsersToFiles(String uString, String osName) throws Exception {
		// TODO Auto-generated method stub
		try{
			fos = new FileOutputStream(osName);
			try{
				fos.write(uString.getBytes("GBK"));
			} catch (UnsupportedEncodingException e){
				e.printStackTrace();
			}
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		fos.close();
	}
   /* private void getUsersFromeReader(String fileName){
         try{
           reader = new FileReader(fileName);
        }catch (FileNotFoundException e){
        	e.printStackTrace();
        }
         BufferedReader br = new BufferedReader(reader);
         String userString;
         try{
        	 while((userString=br.readLine())!=null){
        		 processUserString(userString);
        	 }
         }catch (IOException e){
        	 e.printStackTrace();
         }
         try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void update2(){
    	Set<String> userSet = users.keySet();
    	try{
    		writer = new FileWriter("users.dat");
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	BufferedWriter bfw = new BufferedWriter(writer);
    	for(String cardId: userSet){
    		User u = (User) users.get(cardId);
    		String uString = u.getCardId() + "," + u.getCardPwd() + "," +u.getUserName() + ","+ u.getCall(null) + "," + u.getAccount() 
    		+ "\t\n";
    		try{
    			bfw.write(uString);
    		}catch (IOException e){
    			e.printStackTrace();
    		}
    	}
    	if(bfw!=null){
    		try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }//
    * 
    */
}
