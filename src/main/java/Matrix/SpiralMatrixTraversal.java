package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Print matrix in Spiral order
 * 
 * @author gopi_karmakar
 */
public class SpiralMatrixTraversal {
	
	public static void main(String[] args) {
		
		int[][] matrix = {{1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9}};
		
		System.out.println(traverseSpiral(matrix));
	}

	/**
	 * Let's assume 
	 * Direction 0 -> Top left to right row.
	 * Direction 1 -> Right top to down column.
	 * Direction 2 -> Bottom right to left row.
	 * Direction 3 -> Left down to top column. 
	 */
	public static List<Integer> traverseSpiral(int[][] matrix) {
		
		List<Integer> values = new ArrayList<>();
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		
		int direction = 0;
		/**
		 * Four markings.
		 */
		int topRow = 0, bottomRow = row-1; 
		int leftCol = 0, rightCol = col-1;
		
		while(topRow <= bottomRow && leftCol <= rightCol) {
			if(direction == 0) {				
				for(int i = leftCol; i <= rightCol; i++) {
					values.add(matrix[topRow][i]);					
				}
				topRow += 1;				
			}
			else if(direction == 1) {
				for(int i = topRow; i <= bottomRow; i++) {
					values.add(matrix[i][rightCol]);					
				}
				rightCol -= 1;				
			}
			else if(direction == 2) {
				for(int i = rightCol; i >= leftCol; i--) {
					values.add(matrix[bottomRow][i]);					
				}
				bottomRow -= 1;							
			}
			else if(direction == 3) {
				for(int i = bottomRow; i >= topRow; i--) {
					values.add(matrix[i][leftCol]);					
				}
				leftCol += 1;				
			}
			direction = (direction+1)%4;
		}
		
		return values;
	}	
}
