
public class PercolationUF implements IPercolate {
	
	//instance variables
	boolean[][] myGrid;
	int myOpenCount = 0;
	IUnionFind myFinder;
	int VTOP;
	int VBOTTOM;
	

	/*
	 * 
	 */
	public PercolationUF(int size, IUnionFind finder) {
		myGrid = new boolean[size][size];
		VTOP = size*size;
		VBOTTOM = size*size + 1;
		finder.initialize(size*size + 2);
		myFinder = finder;
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
		return myFinder.connected(VTOP, makeInt(row,col));
	}

	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}

	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}

	private int makeInt(int row, int col) {
		return row * myGrid.length + col;
	}

	@Override
	public void open(int row, int col) {
		if (row < 0 || row >= myGrid.length) throw new IndexOutOfBoundsException();
		if (col < 0 || col >= myGrid[0].length) throw new IndexOutOfBoundsException();
		
	}
}
