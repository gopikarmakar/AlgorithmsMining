package StacksAndQueues;

public class Element<K extends Comparable<K>> {

	K min;
	K max;
	int count;		
	public Element(int count) {
		this.count = count;
	}	
}
