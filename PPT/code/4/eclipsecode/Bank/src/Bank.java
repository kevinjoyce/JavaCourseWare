import java.io.IOException;
import java.util.Scanner;
public class Bank {
       int account;
       private static User user;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank();
		bank.login();
		bank.operate();
	}
	 public void login() {
		 DBUtil dbutil = DBUtil.getInstance();
		 while (true) {
		 Scanner in = new Scanner(System.in); // ����¼��
		 System.out.println("���������п��ţ�");
		 String cardId = in.nextLine();
		 System.out.println("���������п����룺");
		 String cardPwd = in.nextLine();
		 user = dbutil.getUser(cardId);
		    if (dbutil.getUsers().containsKey(cardId)
		             && String.valueOf(user.getCardPwd()).equals(cardPwd)) {
		                 System.out.println("��¼�ɹ�����ӭ" + user.getUserName() + "����");
		                 break;
		               } else {
		            System.out.println("���п��Ż��������");
		         continue;
		            }
		        }
		    }
	public void operate(){
		Bank bk = new Bank();
		while(true){
			 System.out.println("��������Ҫ���еĲ������ͣ����س�������");
			 System.out.println("��1" + "\t" + "ȡ�2"+ "\t"+"��3" + "\t" + "ע�᣺4" + "\t" + "����: 5" + "\t" + "�˳���0"+ "\t");  
			 Scanner in = new Scanner(System.in);
			 String n = in.nextLine(); 
		if("1".equals(n) || "2".equals(n)){
			 int num = 0;
			 try{
			     System.out.print("�����ȡ�Ľ�");
			     num = Integer.parseInt(in.nextLine());
			 }catch(Exception e){
			     System.out.println("����������");
			     continue;
			 }
			 switch (n) {
			     case "1":
			     bk.income(num);
			     break;
			 case "2":
			     bk.takeout(num);
			     break;
			 }
			 }else if("3".equals(n)){ 
			     bk.show();
			 }else if("4".equals(n)){
				 bk.register();
			 }else if("5".equals(n)){
				 bk.save();
			 }else if("0".equals(n)){
			     System.out.println("�˳�ϵͳ��");
			     return;
			 }else{
			     System.out.println("������ 0~5֮�������ѡ����ز�����");
		  }
	  }
	}	
	public void income(int num){
		account = user.getAccount() + num;
		user.setAccount(account);
		 System.out.println("������" + num + "Ԫ�ɹ���"); 
	}
	public void takeout(int num){
		if(user.getAccount() >= num){
			 account = user.getAccount() - num;
			 user.setAccount(account);
			 System.out.println("ȡ�����" + num + "Ԫ�ɹ���");
			 }else{
			 System.out.println("���㣬ȡ��ʧ�ܣ�");
			 }
		}
    public void show(){
		account = user.getAccount();
		 System.out.println("�˻������Ϊ" + account + "Ԫ");
	}
    private void register(){
   	 User u = new User();
   	 Scanner scanner = new Scanner(System.in);
   	 System.out.println("���뿨�ţ�");
   	 u.setCardld(scanner.nextLine());
   	 System.out.println("�����û�����");
   	 u.setUserName(scanner.nextLine());
   	 System.out.println("�������룺");
   	 u.setCardPwd(scanner.nextLine());
   	 System.out.println("�����ֻ��ţ�");
   	 u.getCall(scanner.nextLine());
   	 System.out.println("������");
   	 u.setAccount(scanner.nextInt());
   	 DBUtil dbutils = DBUtil.getInstance();
   	 dbutils.addUser(u);
    }
    private void save(){
    	DBUtil dbutils = DBUtil.getInstance();
    	try {
			dbutils.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
