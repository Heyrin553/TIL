package MyApp_1;

public class accountingApp_if {
	public static void main(String[] args) {
		double valueOfSupply = 10000;
		double vatRate = 0.1;
		double expenseRate=0.3;
		double vat = valueOfSupply*vatRate;
		double total = valueOfSupply+vat;
		double expense = valueOfSupply*expenseRate;
		double income = valueOfSupply-expense;
		
		double dividendA;
		double dividendB;
		double dividendC;
		
		if(income>10000.0) {
			dividendA = (income)*0.5;
			dividendB = (income)*0.3;
			dividendC = (income)*0.2;
		} else {
			dividendA = (income)*1.0;
			dividendB = (income)*0;
			dividendC = (income)*0;
		}
	
		
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
