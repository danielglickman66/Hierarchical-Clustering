import java.util.ArrayList;


public class Cluster {

	private ArrayList<Point> points = new ArrayList<Point>();
	
	public Cluster(Point p ){
		points.add(p);
	}
	
	public Cluster(Cluster a , Cluster b){
		this.points = merge(a , b);
	}
	
	public ArrayList<Point> getPoints() { return points;}
	
	private ArrayList<Point> merge(Cluster a ,Cluster b){
		ArrayList<Point> merged = new ArrayList<Point>(a.getPoints());
		merged.addAll(b.getPoints());
		
		return merged;
	}
	
	public boolean contains(Point p ){
		return points.contains(p);
	}

}
