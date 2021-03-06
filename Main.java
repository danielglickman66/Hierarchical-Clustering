import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
public static void main(String[] args) throws NumberFormatException, IOException {
		String filename = "input.txt";
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		ArrayList<Point> points = new ArrayList<Point>();
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		String algo = br.readLine();
		int n_clusters = Integer.parseInt(br.readLine());
		
		try {
			
		    String line = br.readLine();
		    while (line != null) {
		       double x = Double.parseDouble(line.substring(0, line.indexOf(',')));
		       double y = Double.parseDouble(line.substring(line.indexOf(',')+1));
		       Point p = new Point(x ,y );
		       clusters.add(new Cluster(p));
		       points.add(p);
		        line = br.readLine();
		    }
		} finally {
		    br.close();
		}
		
		HierarchicalClustering hc = new HierarchicalClustering();
		ClusterDistance cd ;
		if(algo.equals("single link"))
			cd = new SingleLink();
		else cd = new AverageLink();
		
		clusters = hc.cluster(clusters, n_clusters, cd);
		PrintWriter out = new PrintWriter("output.txt");
		for(Point p : points)
			for(int i = 0 ; i < clusters.size() ; i++)
				if(clusters.get(i).contains(p))
					out.println(i+1);
			

		out.close();
	}

}
