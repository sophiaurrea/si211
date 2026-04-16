import java.util.*;

public class Loan{
    private double loan, rate, balance, due, cost;
    private double monthly, total = 0; 
    private int months = 0;
    
    public Loan(double loan, double rate, double monthly){
        this.loan = loan;
        this.rate = rate;
        this.monthly = monthly;
        this.balance = loan;
    }

    private double intCalc(){
        return this.balance*this.rate/1200;
    }

    public void calculate(){
        while(this.balance > 0){
            this.balance += this.intCalc();
            this.balance -= this.monthly;
            this.total += this.monthly;
            this.months++;
        }

        this.cost = this.total + this.balance - this.loan;
    }

    public int getMonths(){
        return this.months;
    }

    public double getTotal(){
        return Math.round(this.cost * 100.0) / 100.0;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Loan amount: ");
        double loan = in.nextDouble();
        System.out.print("interest: ");
        double rate = in.nextDouble();
        System.out.print("monthly payment: ");
        double monthly = in.nextDouble();
        Loan A = new Loan(loan, rate, monthly);
        A.calculate();
        System.out.println("Months to payoff: " + A.getMonths());
        System.out.println("Cost: " + A.getTotal());
    }
}