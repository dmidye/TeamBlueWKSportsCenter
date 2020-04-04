package OtherPanels;

public class calculations {
	
	public String resultBMI(String bmiString) {
		Double bmi = Double.parseDouble(bmiString);
		
		if(bmi < 18.5) {
			return "Underweight";
		}
		else if(bmi >= 18.5 && bmi <= 24.9) {
			return "Good";			
		}
		else if(bmi >= 25 && bmi <= 29.9) {
			return "Overweight";
		}
		else {
			return "Obese";
		}			
	} //end BMI
	
	public double waistToHipRatio(double hip, double waist) {
		double ratio;
		ratio = hip/waist;
		return ratio;
	}
	
	/*
	public String waistToHipRatioResult(double ratio) {
		//TODO
	} */
	
	

}
