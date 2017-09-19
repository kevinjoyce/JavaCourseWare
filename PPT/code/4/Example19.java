//匿名内部类
interface Animal{
	void shout();
}
public class Example19{
	public static void main(String[] args){
		animalShout(new Animal(){
			public void shout(){
				System.out.println("喵喵……");
			}
		});
		
		animalShout(new Animal(){
			public void shout(){
				System.out.println("汪汪……");
			}
		});
	}
	public static void animalShout(Animal an){
		an.shout();
	}
}