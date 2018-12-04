import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {

	/*
	 * 
	 */
	public PercolationBFS(int n) {
		super(n);
	}
	
	
	/*
	 * 
	 */
	@Override
	public void dfs(int row, int col) {
		System.out.println("row is "+row+" and column is "+col);
		// out of bounds?
		if (! inBounds(row,col)) {
			System.out.println("out of bounds");
			return;
		}
		
		// Full or NOT open, don't process
		if (isFull(row, col) || !isOpen(row, col)) {
			System.out.println("cell not open");
			return;
		}
		
		myGrid[row][col] = FULL;  // fill cell
		System.out.println("filled cell at "+row+", "+col);
        
        Queue<Integer> qp = new LinkedList<>();       
        int[] rowDelta = {0,0,-1,1};
        int[] colDelta = {-1,1,0,0};
     	
        //put cell on queue
        int cellNum = row * myGrid.length + col;
        System.out.println(row+", "+col+" becomes "+cellNum);
        qp.add(cellNum);
        System.out.println("added "+cellNum+" to queue");
        while (qp.size() != 0){
            int cell = qp.remove();
            System.out.println("cell is "+cell);
            int cellRow = cell/myGrid.length;
            int cellCol = cell%myGrid.length;
            System.out.println("cell's coords are "+cellRow+", "+cellCol);
            
            for(int k=0; k < rowDelta.length; k++){
                int neighborRow = cellRow + rowDelta[k];
                System.out.println("added "+rowDelta[k]+" to row");
                int neighborCol = cellCol + colDelta[k];
                System.out.println("added "+colDelta[k]+" to column");
                System.out.println("looking at neighbor "+neighborRow+", "+neighborCol);
                if (inBounds(neighborRow,neighborCol) && !isFull(neighborRow,neighborCol) && isOpen(neighborRow,neighborCol)){
                	System.out.println("filling neighbor "+neighborRow+", "+neighborCol);
                	myGrid[neighborRow][neighborCol] = FULL;
                	int newCell = neighborRow * myGrid.length + neighborCol;
                	System.out.println("newCell is "+newCell+"because coords are"+neighborRow+", "+neighborCol);
                    qp.add(newCell);  
                    System.out.println("added to queue");
                }
            }
        }	
	}
	
}
