package MyApp_1;

public class accountingApp {
	public static void main(String[] args) {
		double valueOfSupply = 15000.0;
		double vatRate = 0.1;
		double expenseRate=0.3;
		double vat = valueOfSupply*vatRate;
		double total = valueOfSupply+vat;
		double expense = valueOfSupply*expenseRate;
		double income = valueOfSupply-expense;
		double dividendA = (income)*0.5;
		double dividendB = (income)*0.3;
		double dividendC = (income)*0.2;
		
		System.out.println("Value of Supply : "+valueOfSupply);
		System.out.println("VAT : "+vat);
		System.out.println("Total : "+total);
		System.out.println("Expense : "+expense);
		System.out.println("Income : "+income);
		System.out.println("DividendA : "+dividendA);
		System.out.println("DividendB : "+dividendB);
		System.out.println("DividendC : "+dividendC);
		
	}

}
