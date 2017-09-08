class Person{
	int age;
	public void openMouth(){
		//...
	}
	public void speak(){
		this.openMouth();
	}
	public void finalize(){
		System.out.println("garbage collection");
	}
}
