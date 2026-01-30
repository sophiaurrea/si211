public class HW5 {

    public static void main(String[] args) {

        Countdown bottles = new Countdown(99, 0);
        String current = bottles.next();
        String next = bottles.next();

        while (!bottles.done()) {

            if(current == "two")
            {
                // last line of the song
                System.out.print("Two bottles of beer on the wall, ");
                System.out.println("two bottles of beer.");
                System.out.print("Take one down and pass it around, ");
                System.out.println("one bottle of beer on the wall.");
                System.out.println();                
                System.out.print("One bottle of beer on the wall, ");
                System.out.println("one bottle of beer.");
                System.out.print("Take one down and pass it around, ");
                System.out.println("no more bottles of beer on the wall.");
                System.out.println();
            }else{
                // Capitalize first line
                System.out.print(capitalizeFirst(current) + " bottles of beer on the wall, ");
                System.out.println(current + " bottles of beer.");
                System.out.print("Take one down and pass it around, ");
                System.out.println(next + " bottles of beer on the wall.");
                System.out.println();
            }

            current = next;   // e.g. "ninety nine"
            next = bottles.next();
        }
    }

    // Capitalizes the first letter of a string
    public static String capitalizeFirst(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
