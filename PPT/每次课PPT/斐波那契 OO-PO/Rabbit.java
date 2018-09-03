/**
 * 
 */
package topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author xpz
 *
 */
//����һ��������
public class Rabbit {				
		    private int age ;//��һ������age,������¼����(���¼���)
		    
		    private static List<Rabbit> list = new ArrayList<Rabbit>(Arrays.asList(new Rabbit(1)));//����һ��"������",�������б�������һ������
		    
		    public Rabbit(int age){//���췽��
		        this.age = age;
		    } 
		    
		    public static Rabbit birth(){//��������С���ӵ���Ϊ
		        return new Rabbit(1);
		    }
		    

		    public static int getSize(List<Rabbit> list){//����������е���������
		        return list.size();
		    }
		    
		    
		    public static int countRabbits(int month){//��������·���������Ӧ�ж�������
		        
		        if( month == 1 || month == 2) {
		            
		            return 1;
		            
		        }else{
		                list.get(0).age = 3;
		            }
		            
		        
		        Rabbit curr_Rabbit = null;
		        
		        for(int i = 3 ; i <= month ; i++){//�����·ݿ�ʼ
		            
		            for(int j = 0; j < list.size(); j++){
		                
		                curr_Rabbit = list.get(j);
		                
		                if(curr_Rabbit.age >= 3){//���������ڵ���������,����������
		                    
		                    list.add(birth());
		                }
		                
		                curr_Rabbit.age++;//��Ȼ�����1
		            }
		        }
		        return getSize(list);
		    }

		    
		    public static void main(String[] args) {
		        System.out.println(Rabbit.countRabbits(2));
		    }
		
	}


