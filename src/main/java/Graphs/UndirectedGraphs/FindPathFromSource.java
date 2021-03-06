package Graphs.UndirectedGraphs;

import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.LinkedHashSet;

/**
 * Given a source vertex find the connected path from source.
 * 
 * @author gopi_karmakar
 */
public class FindPathFromSource<V extends Comparable<V>> {

	private Set<V> visitedPath = null;
	
	public FindPathFromSource() {
		
		visitedPath = new LinkedHashSet<>();
	}
	
	public static void main(String[] args) {
	
		FindPathFromSource<Integer> path = new FindPathFromSource<>();					
		
		Integer source = 5;
		
		//path.dfsPathSearch(BuildUndirectedGraph.buildDefaultGraph(), source);
		
		path.bfsPathSearch(BuildUndirectedGraph.createDefault(), source);
		
		System.out.println(path.visitedPath);
	}
	
	public Set<V> getVisitedPath() {
		return visitedPath;
	}
	
	/**
	 * DFS traversal of a graph
	 * DFS marks all the vertices connected to a given source in time 
	 * proportional to the sum of their degrees
	 *
	 * O(v + e) Time complexity
	 */
	public void dfsPathSearch(UndirectedGraph<V> uGraph, V source) {

		visitedPath.add(source);
		
		for(V e : uGraph.getAdjacencySet(source)) {
			
			if(!visitedPath.contains(e)) {
				dfsPathSearch(uGraph, e);
			}
		}	
	}
	
	/**
	 * BFS traversal of a graph
	 * 
	 * Time complexity is O(v + e) where v = number of vertices and
	 * e = maximum degree of any vertex called edges.
	 */
	public Set<V> bfsPathSearch(UndirectedGraph<V> uGraph, V source) {
		
		Queue<V> queue = new LinkedList<>();
		
		queue.add(source);		
		visitedPath.add(source);
		
		while(!queue.isEmpty()) {
			
			V v = queue.remove();
			
			for(V e : uGraph.getAdjacencySet(v)) {
				
				if(!visitedPath.contains(e)) {
					queue.add(e);
					visitedPath.add(e);
				}
			}
		}
		return visitedPath;
	}	
}