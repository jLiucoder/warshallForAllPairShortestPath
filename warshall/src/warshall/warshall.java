package warshall;



public class warshall {
	final static double INF = Double.POSITIVE_INFINITY; 
	final static int V = 11;
	 
		 
	    void floydWarshall(double inputGraph[][])
	    {
	        double dist[][] = new double[V][V];
	        
	        int i, j, k;
	 
	        for (i = 0; i < V; i++) {
	            for (j = 0; j < V; j++) {
	            	dist[i][j] = inputGraph[i][j];
	            }       
	        }    
	            
	        for (k = 0; k < V; k++)
	        {
	        	System.out.println();
	        	System.out.println("k=" + k + "\n");
		
	            for (i = 0; i < V; i++)
	            {
	   	 
	                for (j = 0; j < V; j++)
	                {
	                	 
	                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
	                        dist[i][j] = dist[i][k] + dist[k][j];
	                    }
	                    System.out.format("%.1f ",dist[i][j]);

	                     
	                } 
	                if (dist[i][i] < 0) {
	                         System.err.println(" there is one negative cycle here in the input graph");
	                         //if there is a negative cycle, 
	                         return;
	                    }
	      
	                System.out.println();
	            }
	            
	           
	        }
	       
	         // printSolution(dist);
	        
	        System.out.println();
	    }
	 
	    void printSolution(double[][] dist)
	    {
	        System.out.println("matrix showing here");
	        for (int i=0; i<V; ++i)
	        {
	            for (int j=0; j<V; ++j)
	            {
	                if (dist[i][j]==INF)
	                    System.out.print("INF ");
	                else
	                    System.out.print(dist[i][j]+"   ");
	            }
	            System.out.println();
	        }
	    }
	 
	    
    // Driver program to test above function
    public static void main (String[] args)
    {
        
        double input[][] = { 
        				  {  0, 3.4, 4.7,INF,5.2,INF,INF,INF,INF,INF,INF},
                          {3.4,   0, INF,INF,INF,INF,INF,INF,7.5,INF,INF},
                          {4.7, INF,   0,INF,1.4,INF,INF,INF,2.4,INF,INF},
                          {INF, INF, INF,  0,INF,INF,INF,INF,5.3,3.3,INF},
                          {3.4, INF, 1.4,INF,  0,INF,4.6,7.1,INF,INF,INF},
                          {INF, INF, INF,INF,INF,  0,1.2,INF,INF,INF,2.3},
                          {INF, INF, INF,INF,4.6,1.2,  0,INF,INF,INF,INF},
                          {INF, INF, INF,INF,7.1,INF,INF,  0,INF,INF,  5},
                          {INF, 7.5, 2.4,5.3,INF,INF,INF,INF,  0,1.3,INF},
                          {INF, INF, INF,3.3,INF,INF,INF,INF,1.3,  0,INF},
                          {INF, INF, INF,INF,INF,2.3,INF,  5,INF,INF,  0},
                           };
        warshall warshall = new warshall();
 
        warshall.floydWarshall(input);
    }
}

