
public class PercolationUF implements IPercolate {
	int size;
	boolean[][] myGrid = new boolean[size][size];
	int myOpenCount = 0;

	public PercolationUF(int size, IUnionFind finder) {
		
	}
	
	@Override
	public void open(int row, int col) {
		if (row < 0 || row >= myGrid.length) throw new IndexOutOfBoundsException();
		if (col < 0 || col >= myGrid[0].length) throw new IndexOutOfBoundsException();
		
	}

	@Override
	public boolean isOpen(int row, int col) {
		if (row < 0 || row >= myGrid.length) throw new IndexOutOfBoundsException();
		if (col < 0 || col >= myGrid[0].length) throw new IndexOutOfBoundsException();
		return myGrid[row][col] == true;
	}

	@Override
	public boolean isFull(int row, int col) {
		if (row < 0 || row >= myGrid.length) throw new IndexOutOfBoundsException();
		if (col < 0 || col >= myGrid[0].length) throw new IndexOutOfBoundsException();
		return false;
	}

	@Override
	public boolean percolates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numberOfOpenSites() {
		// TODO Auto-generated method stub
		return 0;
	}

}
