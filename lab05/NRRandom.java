import java.util.*;

public class NRRandom extends Random
{
    private int current;

    public NRRandom(long l)
    {
        super(l);
        current = -1;
    }
    public int nextInt(int n){
        int num = current;
        while(num == current)
        {
            num = super.nextInt(n);
        }
        current = num;
        return current;
    }
}