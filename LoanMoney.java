
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class LoanMoney {
    public static double round(double value,String f){
        DecimalFormat df = new DecimalFormat(f);
        value = Double.parseDouble(df.format(value));
        return value;
    }
    public static void main(String[] args) {
        double interestRate;
        double loan;
        int month;
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Loan Money =$ ");
        loan = input.nextDouble();

        System.out.print("Enter Rate =% ");
        interestRate = input.nextDouble();
        System.out.print("Enter Months = ");
        month = input.nextInt();
        LocalDate now = LocalDate.now();
        var df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Date Received = " + df.format(now));
        interestRate /= 100;

        double installment,principal,interest,debt = loan;

        installment = (loan * interestRate)/(1-Math.pow((1+interestRate),-month));

        System.out.println();
        double totalInterest = 0;
        double totalInstallment = installment * month;
        System.out.printf("%-15s%-23s%-20s%-20s%-15s%n","Month","Installment","Principal","Interest","Debt Balance");
        for(int i = 1; i <= month; i++){
            interest = debt * interestRate;
            principal = installment - interest;
            debt -= principal;
            if(i==month){
                installment = totalInstallment - (round(installment,"0.00")*(month-1));
            

            }
            totalInterest += interest;
            System.out.printf("%-15s%-23s%-20s%-20s%-15s%n",now.plusMonths(i).format(df),String.format("$%.2f",installment),String.format("$%.2f",principal),String.format("$%.2f",interest),String.format("$%.2f",debt));
            
            
        }

        System.out.println("=================================================================");
        System.out.println("Total Interest    = " + String.format("$%.2f",totalInterest));
        System.out.println("Total Installment = " + String.format("$%.2f",totalInstallment));
    }
}