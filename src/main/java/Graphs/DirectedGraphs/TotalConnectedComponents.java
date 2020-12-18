package Graphs.DirectedGraphs;

public class TotalConnectedComponents {

	public static void main(String[] args) {
		
		DirectedGraph<Integer> diGraph = BuildDirectedGraph.defaultVertexGraph();
	
		int count = 0;
		for(Vertex<Integer> v : diGraph.getVertexGraph()) {
			
			if(!v.visited) {				
				dfs(v);
				count++;
			}				
		}
		System.out.println("Total Components = " + count);		
	}	
	
	private static void dfs(Vertex<Integer> v) {
		
		//if(v == null) return;
		
		v.visited = true;
		for(Vertex<Integer> e : v.edges) {
			
			if(!e.visited) {
				dfs(e);
			}
		}
	}	
}
