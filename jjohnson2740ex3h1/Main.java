package ex3h1;

import java.text.DecimalFormat;

public class Main
{
	public static void main(String[] args) {
		// create arrays:
		double[] dblRainfall = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.0, 11.1, 12.2};
		String[] strRainfall = {"1.1", "2.2", "3.3", "4.4", "5.5", "6.6", "7.7", "8.8", "9.9", "10.0", "11.1", "12.2"};
      
		// create new decimal format object
		DecimalFormat fmt = new DecimalFormat("#0.0");
	  
		//create new rainfall object and pass double array to constructor1
		Rainfall rainfall1 = new Rainfall(dblRainfall);
		System.out.println("Rainfall Total: " + fmt.format(rainfall1.getTotal()));
		System.out.println("Rainfall Average: " + fmt.format(rainfall1.getAverage()));
		System.out.println("Rainfall Highest: " + fmt.format(rainfall1.getHighest()));
		System.out.println("Rainfall Lowest: " + fmt.format(rainfall1.getLowest()));
		System.out.println();
		
		//create new rainfall object and pass string array to constructor2
		rainfall1 = new Rainfall(strRainfall);
		System.out.println("Rainfall Total: " + fmt.format(rainfall1.getTotal()));
		System.out.println("Rainfall Average: " + fmt.format(rainfall1.getAverage()));
		System.out.println("Rainfall Highest: " + fmt.format(rainfall1.getHighest()));
		System.out.println("Rainfall Lowest: " + fmt.format(rainfall1.getLowest()));
		System.out.println();
	}
}

