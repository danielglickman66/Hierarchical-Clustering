
public class AverageLink implements ClusterDistance {

	public double evalDistance(Cluster a, Cluster b) {
		double average = 0.0;
		int count = 0;
		for(Point p : a.getPoints())
			for(Point p2 : b.getPoints())
				average = (average*count + p.dist(p2)) / (++count); //calculates the average online
			
		
		return average;
	}

}
