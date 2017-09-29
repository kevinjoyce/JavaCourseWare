public class GC{
	public static void main(String[] args){
		Person p = new Person();
		p = null;
		for(int i = 0; i<1000000; i++);
		//System.gc();
	}
}