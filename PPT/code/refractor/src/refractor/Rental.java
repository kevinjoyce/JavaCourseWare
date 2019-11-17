package refractor;

public class Rental {
	private Movie _movie;
	private int _daysRented;
	
	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	
	public int getDaysRented() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}
	
	public double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	
	public int getFrequentRenterPoints() {
		//����Ƶ�μ�1		
		//�·��е�Ӱ���2�������ټ�1
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}
