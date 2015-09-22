package Main;

//next line imports the FinaceLib from apache
import org.apache.poi.ss.formula.functions.FinanceLib;
//next line imports the scanner to interact with users
import java.util.Scanner; 

public class Tuition {

	public static void main(String[] args) {
		//new scanner object
		Scanner input = new Scanner(System.in);
		//asks for tuition cost, percent increase, repayment APR and term and saves them as variables
		System.out.print("What is the initial tuition cost?:");
		double tuition = input.nextDouble();
		System.out.print("What is the percent increase for tuition(decimal form)?:");
		double percentincrease = input.nextDouble();
		System.out.print("What is the repayment APR (decimal form)?:");
		double APR = input.nextDouble();
		System.out.print("What is the repayment term in years?:");
		int term = input.nextInt();
		
		//calls the calculate loan and repayment methods to do the calculations
		double fouryrloan = CalculateLoan(tuition, percentincrease, APR);
		double monthlypayment = Repayment(APR,term,fouryrloan);
		
		//Prints out the monthly payments
		System.out.printf("The monthly repayment is $%.2f", monthlypayment);
		
	}
	//method to calculate loan
	public static double CalculateLoan(double tuition, double percentincrease,double APR) {
		double loan = 0;
		//for each of the four years calculates tuition plus percent increase and APR and adds it to the year before
		for (int year = 0; year < 4; year++){
			double tuition2 = tuition + (tuition * percentincrease * year);
			loan = loan + tuition2 + (tuition2 * APR);
		}
		return loan;
	}
	
	//method to calculate the monthly repayment
	public static double Repayment (double APR, int term, double fouryrloan) {
		//divide by 12 to get monthly rate
		double r = APR / 12;
		//multiply by 12 to get the number of months
		double month = term * 12;
		//the present value is the total of the current loan after 4 years
		double PV = fouryrloan;
		//want the loan to be paid off (equal to 0)
		double FV = 0;
		boolean type = false;
		//uses FinanceLib to calculate pmt/monthly repayment
		double monthlypayment = -FinanceLib.pmt(r, month, PV, FV, type);	
		return monthlypayment;
	}
}
