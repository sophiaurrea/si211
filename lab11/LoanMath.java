import java.util.*;

public class LoanMath{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Loan amount: ");
        double loan = in.nextDouble();
        System.out.print("interest: ");
        double rate = in.nextDouble();
        System.out.print("monthly payment: ");
        int monthly = in.nextInt();
        Loan A = new Loan(loan, rate, monthly);
        A.calculate();
        System.out.println("Months to payoff: " + A.getMonths());
        System.out.println("Cost: " + A.getTotal());
    }

}