
public class Point {

	double x ,y;
	
	public Point(double xi , double yi){ 
		x = xi ;	y = yi;
	}
	public double  dist(Point other){
		double xd = (this.x - other.x);
		double yd = (this.y - other.y);
		
		return Math.sqrt( yd*yd +xd*xd);
	}
	

}
