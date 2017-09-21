public class Example20{
	public static void main(String[] args){
		try{
			int result = divide(4, 0);
			System.out.println(result);
		}catch (Exception e){
			System.out.println("捕捉的异常信息为："+e.getMessage());
			return;
		}finally{
			System.out.println("进入finally代码块");
		}
		//此处代码不会执行
		System.out.println("程序继续向下执行……");
	}
	public static int divide(int x, int y) throws Exception{
		int result = x/y;
		return result;
	}
}