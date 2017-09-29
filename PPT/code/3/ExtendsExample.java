class Animal{
	String type;
	
	public Animal(String type){
		this.type = type;
	}
	
	public void shout(){
		System.out.println("this is an animal shouting!" + this.type);
	}
}
class Dog extends Animal{
	public Dog(String type){
		super(type);
	}
}
public class ExtendsExample{
	public static void main(String[] args){
		Dog dog = new Dog("wolf");
		dog.shout();
	}
}