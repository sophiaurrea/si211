import java.util.*;


public class ThingC extends ThingB
{
    public ThingC(int row, int col, char lab){
        super(row, col, lab);
    }

    public void step()
    {
        super.step();
        rightTurn();
        super.step();
        leftTurn();
        super.step();
    }

}