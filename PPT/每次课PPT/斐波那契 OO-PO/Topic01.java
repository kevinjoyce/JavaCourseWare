/**
 * 代码来自csdn
 */
package topic;

import java.util.Scanner;

/**
 * @author xpz
 *
 */
public class Topic01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//01题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
		//小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
		//斐波那契数列,递归，面向过程编程
		try {
		int mouth = 0;  
	    System.out.println("你需要查询第几个月兔子数");  
	    Scanner sc =new Scanner(System.in);	
	    mouth=sc.nextInt();
	    System.out.println("第"+mouth+"个月兔子对数:"+getRabbit(mouth));  	 	
		} catch (Exception e) {			
			System.err.println("月数输入有误！");
			}
	}
	 //递归，n=(n-1)+(n-2),归n=1,n=2
	static int getRabbit(int mouth){
		if(1==mouth||2==mouth)
			return 1;
		else
			return getRabbit(mouth-1)+getRabbit(mouth-2);
	}
}
