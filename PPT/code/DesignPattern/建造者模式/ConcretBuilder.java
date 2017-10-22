public class ConcretBuilder implements Builder{
	private Product product = new Product();
	public void buildPart1(){
		product.setPart1("this is part1 value");
		System.out.println("part1 built");
	}
	public void buildPart2(){
		product.setPart2("this is part2 value");
		System.out.println("part2 built");
	}
	public Product retrieveResults(){
		return this.product;
	}
}