public class ExceptionExample{
	public static void main(String[] args){
	try{	
		double result = divide(4, 0);
		System.out.println(result);
	}catch(Exception e){
		System.out.println(e.getMessage());
	}	
		
	}
	static double divide(int x, int y) throws Exception{
		return x / y;
	}
}