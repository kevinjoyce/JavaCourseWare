class Animal{
	//�д������Ĺ��췽����ϵͳĬ���ṩ���޲������췽����ʧЧ�ˡ�
	public Animal(String name){
		System.out.println("����һֻ"+name);
	}
}
class Dog extends Animal{
	public Dog(){
		//�˴���д���ø��๹�췽���Ĵ��룬�൱��д����super();��super()����޲εĸ��๹�췽��
		//�ǲ����ڵġ���˴˴���д���룬ϵͳ�ᱨ��
		super("ɳƤ��");//super���ø���Ĺ��췽����д�����Ͳ��ᱨ������	
	}
	
}
public class Example04{
	public static void main(String[] args){
		Dog dog = new Dog();
	}
}