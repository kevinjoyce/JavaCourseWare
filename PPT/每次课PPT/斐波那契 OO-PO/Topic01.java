/**
 * ��������csdn
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
		//01��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
		//С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ���������Ϊ���٣�
		//쳲���������,�ݹ飬������̱��
		try {
		int mouth = 0;  
	    System.out.println("����Ҫ��ѯ�ڼ�����������");  
	    Scanner sc =new Scanner(System.in);	
	    mouth=sc.nextInt();
	    System.out.println("��"+mouth+"�������Ӷ���:"+getRabbit(mouth));  	 	
		} catch (Exception e) {			
			System.err.println("������������");
			}
	}
	 //�ݹ飬n=(n-1)+(n-2),��n=1,n=2
	static int getRabbit(int mouth){
		if(1==mouth||2==mouth)
			return 1;
		else
			return getRabbit(mouth-1)+getRabbit(mouth-2);
	}
}
