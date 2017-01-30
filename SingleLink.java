
public class SingleLink implements ClusterDistance {
	/**
	 * minimum distance between any 2 points of the clusters.
	 */
	public double evalDistance(Cluster a, Cluster b) {
		double min_dst = Double.MAX_VALUE;
		
		for(Point p1 : a.getPoints())
			for(Point p2 : b.getPoints())
				if( p1.dist(p2) < min_dst)
					min_dst = p1.dist(p2);

		return min_dst;
	}

}
