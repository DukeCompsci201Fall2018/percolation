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
		// out of bounds?
		if (! inBounds(row,col)) return;
		
		// full or NOT open, don't process
		if (isFull(row, col) || !isOpen(row, col))
			return;
		
		myGrid[row][col] = FULL;  // fill cell
        
        Queue<Integer> qp = new LinkedList<>();       
        int[] rowDelta = {-1,1,0,0};
        int[] colDelta = {0,0,-1,1};
     	
        //put cell on queue
        int cellNum = row * myGrid.length + col;
        qp.add(cellNum);
        while (qp.size() != 0){
            int cell = qp.remove();
            int cellRow = cell/myGrid.length;
            int cellCol = cell%myGrid.length;
            for(int k=0; k < rowDelta.length; k++){
                cellRow = cellRow + rowDelta[k];
                cellCol = cellCol + colDelta[k];
                if (inBounds(cellRow,cellCol) && ! isFull(cellRow,cellCol)){
                	myGrid[cellRow][cellCol] = FULL;
                	int newCell = cellRow * myGrid.length + cellCol;
                    qp.add(newCell);                     
                }
            }
        }
		
	}
}
