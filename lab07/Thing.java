import java.util.*;

public class Thing
{
    // dir: 0=North, 1=East, 2=South, 3=West. 
    // timeSinceLast: this is only important for "TypeB" Things.
    private int row, col, dir;
    private char lab;

    public Thing(int row, int col, char lab)
    {
        this.row = row;
        this.col = col;
        this.lab = lab;
    }

    public void rightTurn()
    { 
        this.dir = (this.dir + 1) % 4; 
    }

    public void leftTurn() 
    { 
        this.dir = (this.dir + 3) % 4; 
    }

    public void maybeTurn(int i)
    {
        if (i == 1) { this.rightTurn(); }
        if (i == 2) { this.leftTurn(); }      
    }

    public void step()
    {
        final int[] dc = {0,1,0,-1}, dr = {-1,0,1,0};
        this.row += dr[this.dir];
        this.col += dc[this.dir];
    }

    public void printThing(){
        System.out.println(row + " " + col + " " + lab);
    }
}