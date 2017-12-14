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
		 Scanner in = new Scanner(System.in); // 键盘录入
		 System.out.println("请输入银行卡号：");
		 String cardId = in.nextLine();
		 System.out.println("请输入银行卡密码：");
		 String cardPwd = in.nextLine();
		 user = dbutil.getUser(cardId);
		    if (dbutil.getUsers().containsKey(cardId)
		             && String.valueOf(user.getCardPwd()).equals(cardPwd)) {
		                 System.out.println("登录成功！欢迎" + user.getUserName() + "先生");
		                 break;
		               } else {
		            System.out.println("银行卡号或密码错误！");
		         continue;
		            }
		        }
		    }
	public void operate(){
		Bank bk = new Bank();
		while(true){
			 System.out.println("请输入您要进行的操作类型，按回车键结束");
			 System.out.println("存款：1" + "\t" + "取款：2"+ "\t"+"余额：3" + "\t" + "注册：4" + "\t" + "存盘: 5" + "\t" + "退出：0"+ "\t");  
			 Scanner in = new Scanner(System.in);
			 String n = in.nextLine(); 
		if("1".equals(n) || "2".equals(n)){
			 int num = 0;
			 try{
			     System.out.print("输入存取的金额：");
			     num = Integer.parseInt(in.nextLine());
			 }catch(Exception e){
			     System.out.println("金额输入错误！");
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
			     System.out.println("退出系统！");
			     return;
			 }else{
			     System.out.println("请输入 0~5之间的数字选择相关操作！");
		  }
	  }
	}	
	public void income(int num){
		account = user.getAccount() + num;
		user.setAccount(account);
		 System.out.println("存入金额" + num + "元成功！"); 
	}
	public void takeout(int num){
		if(user.getAccount() >= num){
			 account = user.getAccount() - num;
			 user.setAccount(account);
			 System.out.println("取出金额" + num + "元成功！");
			 }else{
			 System.out.println("余额不足，取款失败！");
			 }
		}
    public void show(){
		account = user.getAccount();
		 System.out.println("账户总余额为" + account + "元");
	}
    private void register(){
   	 User u = new User();
   	 Scanner scanner = new Scanner(System.in);
   	 System.out.println("输入卡号：");
   	 u.setCardld(scanner.nextLine());
   	 System.out.println("输入用户名：");
   	 u.setUserName(scanner.nextLine());
   	 System.out.println("输入密码：");
   	 u.setCardPwd(scanner.nextLine());
   	 System.out.println("输入手机号：");
   	 u.getCall(scanner.nextLine());
   	 System.out.println("输入余额：");
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
