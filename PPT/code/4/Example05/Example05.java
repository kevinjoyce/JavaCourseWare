class Animal{
	public Animal(){
		System.out.println("��ֻ��һֻ����");
	}
	//�д������Ĺ��췽����ϵͳĬ���ṩ���޲������췽����ʧЧ�ˣ������������ṩ��
	public Animal(String name){
		System.out.println("����һֻ"+name);
	}
}
class Dog extends Animal{
	public Dog(){
		//�˴���д���룬�൱��д����super();��super()����޲εĸ��๹�췽���������Ѿ����ˡ�
		
	}
	
}
public class Example05{
	public static void main(String[] args){
		Dog dog = new Dog();
	}
}