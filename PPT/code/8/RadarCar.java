class RadarCar{
	Car _car;
	public RadarCar(Car car){
		_car = car;
	}
	public void show(){
		System.out.println("A new car with radar");
		_car.show();
	}
}