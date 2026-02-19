import java.util.*;


public class ThingB extends Thing
{
    private int timeSinceLast;

    public ThingB(int row, int col, char lab){
        super(row, col, lab);
    }

    public void maybeTurn(int i)
    {
        this.timeSinceLast++; 
        if (this.timeSinceLast == 10)
        {
            this.timeSinceLast = 0;
	        if (i == 1) { rightTurn(); }
	        if (i == 2) { leftTurn(); }
        }
    }
}