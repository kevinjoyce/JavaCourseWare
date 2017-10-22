public class Client{
	public static void main(String[] args){
		Builder builder = new ConcretBuilder();
		Director director = new Director(builder);
		director.construct();
	}
}