package lab10;

/**
 * A grid object represents the cell grid of a life simulation.
 * The grid is a 2D array of cells.  The grid object keeps track
 * of the state of each cell (alive, dead), and allows the user
 * to make one step in the life simulation.
 * 
 * Note that this class does not do any drawing or other I/O.
 * It just represents a grid.
 * 
 * @author Peter Jensen and (your name here)
 * @version (date here)
 */
public class Grid
{
    // Instance variables here.
    private boolean[][] grid;
    private int width;
    private int height;
    /**
     * Constructor - creates an empty grid of the
     * specified dimensions.
     * 
     * @param width The width of the new grid
     * @param height The height of the new grid
     */
    public Grid (int width, int height)
    {
        grid = new boolean[width][height];
        this.width = width;
        this.height = height;
    }

    /**
     * Returns true if the specified cell in the grid
     * is alive, false otherwise.  If the coordinates
     * are illegal (outside the grid), false is returned.
     * 
     * @param row  a row number
     * @param column a column number
     * @return true iff that cell is alive
     */
    public boolean isAlive (int row, int column)
    {
        if (column > height - 1 || row > width - 1 || column < 0 || row < 0)
            return false;
        else if (grid[row][column] == true)
    	    return true;
        else
            return false;
    }
    
    /** 
     * Returns the width of the grid.
     * 
     * @return the width of this grid
     */
    public int getWidth ()
    {
    	return grid[0].length;
    }

    /** 
     * Returns the height of the grid.
     * 
     * @return the height of this grid
     */
    public int getHeight ()
    {
    	return grid.length;
    }
    
    /**
     * Sets the state of the specified cell in the
     * grid.
     * 
     * @param row a row number
     * @param column a column number
     * @param isAlive true if the grid cell should be alive
     */
    public void setCellState(int row, int column, boolean isAlive)
    {
        grid[row][column] = isAlive;
    }
    
 
    /**
     * Clears the grid, all cells marked as dead.
     */
    public void clear ()
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
                grid[i][j] = false;
        }
    }
    
    /**
     * Performs one 'life' step using the standard rules
     * of life:
     * 
     * Any live cell with fewer than two neighbors dies, as if by loneliness.
     * Any live cell with more than three neighbors dies, as if by overcrowding.
     * Any live cell with two or three neighbors lives, unchanged, to the next generation.
     * Any dead cell with exactly three neighbors comes to life.
     * 
     * Care must be taken to make sure the next generation is kept separate from the 
     * current generation.
     */
    public void stepOneGeneration ()
    {
    	// Create a spare grid
    	boolean [][] spare = new boolean[grid.length][grid[0].length];

    	// Loop through each grid location
    	  	// Count the neighbors of the current location (using the helper function 8 times)
    	    // Set the alive/dead state in the spare grid according to the rules
        int count = 0;
    	for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (isAlive(i, j + 1) == true)
                    count++;
                if (isAlive(i, j - 1) == true)
                    count++;
                if (isAlive(i + 1, j) == true)
                    count++;
                if (isAlive(i - 1, j) == true)
                    count++;
                if (isAlive(i + 1, j + 1) == true)
                    count++;
                if (isAlive(i + 1, j - 1) == true)
                    count++;
                if (isAlive(i - 1, j + 1) == true)
                    count++;
                if (isAlive(i - 1, j - 1) == true)
                    count++;

                if (grid[i][j] == true)
                {
                    if (count == 0 || count == 1 || count >= 4)
                        spare[i][j] = false;
                    else
                        spare[i][j] = true;
                }
                else
                {
                    if (count == 3)
                        spare[i][j] = true;
                    else
                        spare[i][j] = false;
                }

                count = 0;
            }
        }

    	// Store the spare grid in the grid field (replacing the old grid with the new one)
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
              setCellState(i, j, spare[i][j]);
        }
    }
}
