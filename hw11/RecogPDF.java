public class RecogPDF extends RecogASCII{
    private static int[] header =
    { 0x25, 0x50, 0x44, 0x46}; //checks first four bytes

    private int i = 0;

    public String getName() { return "PDF";}

    public void feed(int nextByte){
        if (getState() == 2) // 2 : unkown
        {
        if (i < header.length){
            if(nextByte != header[i]){
                setState(0); // 0 : not match
            }
        }
        }
        i++;
        if (i >= header.length && getState() != 0)
        setState(1); // 1 : match
    }
    boolean decision() { return getState() == 1; }
}