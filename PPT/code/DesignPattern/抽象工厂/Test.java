public class Test
{
	public static void main(String[] args){
		Provider provider = new SmsSenderFactory();
		Sender ss = provider.produce();
		ss.send();
	}
}