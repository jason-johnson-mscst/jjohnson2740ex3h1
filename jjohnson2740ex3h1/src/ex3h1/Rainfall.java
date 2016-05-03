package ex3h1;

public class Rainfall
{
	//global variable for rain data
	private double[] rain; 

	/* constructor1 accepts double array as an argument, copies array to the rain array. */
	public Rainfall(double[] r) {
		// Initialize new Array that has the same length as incoming r
		rain = new double[r.length];
		// Create copy of the values in new array
		for (int i = 0; i < r.length; i++){
			rain[i] = r[i];
		}	
	}
  
	/* constructor2 accepts string array as an argument, copies array to the rain array. */
	public Rainfall(String[] r) {
		// Initialize new Array that has the same length as incoming r
		rain = new double[r.length];
		// Create copy of the values in new array
		for (int i = 0; i < r.length; i++){
			rain[i] = Double.parseDouble(r[i]);
		}
	}

	//Calculate total
	public double getTotal() {
		// Create accumulator
		double total = 0.0;
		// Use enhanced FOR loop to total amounts. Each iteration takes value and adds it to the total.
		for (double value : rain){
			total += value;
		}
		// Return the total.
		return total;
	}

	//Calculate average using total from getTotal() function.
	public double getAvg(){
		return getTotal() / rain.length;
	}

	//Find High
	public double getHigh() {
      // Store first value from rain array into high variable.
      double high = rain[0];
      // Iterate through the array and compare amounts, if the compared amt from array is larger, replace into highest variable.
      for (int i = 1; i < rain.length; i++) {
         if (rain[i] > high)
            high = rain[i];
      }
      // Return the highest value.
      return high;
	}

	//Find Low
	public double getLow() {
		// create lowest variable and store first value from array.
		double low = rain[0];
		// Iterate through the array and compare amounts, if the compared amt from array is smaller, replace into low variable.
		for (int i = 1; i < rain.length; i++) {
			if (rain[i] < low) {
				low = rain[i];
			}
		}
		// Return Low
		return low;
	}
}
