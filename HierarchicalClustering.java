import java.util.ArrayList;


public class HierarchicalClustering {
	/***
	 * each time finds the 2 closest distance clusters , and merges them to 1 cluster, until we have numClusters clusters.
	 * @param initial - first set of cluster , in our case 1 point clusters.
	 * @param numClusters, when to stop.
	 * @param fun - calculates distance between clusters(average or single link)
	 * @return
	 */
	public ArrayList<Cluster> cluster(ArrayList<Cluster> initial , int numClusters , ClusterDistance fun){
		
		ArrayList<Cluster> clusters = new ArrayList<Cluster>(initial);
		
		while(clusters.size() > numClusters){
			double min_dist = Double.MAX_VALUE;
			int first=0 , second=0;
			//iterate all pairs
			for(int i = 0 ; i < clusters.size() ; i++)
				for(int j = i+1 ; j < clusters.size() ; j++){
					double dist = fun.evalDistance(clusters.get(i), clusters.get(j));
					if(dist < min_dist){
						min_dist = dist;
						first = i;
						second = j;
					}
					
				}
			//pop 2 and inserted merged cluster.
			Cluster merged = new Cluster(clusters.get(first) , clusters.get(second));
			 clusters.remove(second);clusters.remove(first);
			clusters.add(first ,  merged );
			
		}
		

		return clusters;
	}
}
