package OtherPanels;

public class Calculations {
	
	public String resultBMI(String bmiString) {
		double bmi = Double.parseDouble(bmiString);
		
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
		ratio = waist/hip;
		return ratio;
	}
	
	
	public String waistToHipRatioResult(String whratio, String gender) {
		
		double ratio = Double.parseDouble(whratio);
		if(gender.equals("M") && ratio < .9){
			return "Good";
		}
		if(gender.equals("F") && ratio < .85) {
			return "Good";
		}
		else {
			return "Obese";
		}
	}
	
	// calculation from https://www.gaiam.com/blogs/discover/how-to-calculate-your-ideal-body-fat-percentage
	// Erika Clark
	public String bodyFatPercentage(String gender, String bmiString, int age) {
		double BMI = Double.parseDouble(bmiString);
		double bfp;
		String result;
		if(gender.equals("F")) {
			bfp = (1.20 * BMI) + (0.23 * age) - 5.4;
			result = String.format("%.2f", bfp);;
			return result;
		}
		else {
			bfp = (1.20 * BMI) + (0.23 * age) - 16.2;
			result = String.format("%.2f", bfp);;
			return result;
		}
	}
	
	public String calculateBodyFat(String bfpString, String weightString) {
		double bfp = Double.parseDouble(bfpString);
		double weight = Double.parseDouble(weightString);
		double bfm = weight * (bfp/100);
		
		String result = String.format("%.2f", bfm);;
		return result;
	}
	
	public String calculateLeanWeight(String bodyFat, String weightString) {
		double weight = Double.parseDouble(weightString);
		double bfm = Double.parseDouble(bodyFat);
		double leanWeight = weight - bfm;
		String result  = String.format("%.2f", leanWeight);;
		
		return result;
		
	}
	
	// equation from https://www.topendsports.com/testing/density-jackson-pollock.htm
	// Skinfold
	// Erika Clark
	public String calculateBodyDesnsity(int age, String gender, String ch, String ax, String tri, String sub, String ab, String sup, String thi) {
		
		double chest = Double.parseDouble(ch);
		double midaxillary = Double.parseDouble(ax);
		double tricep = Double.parseDouble(tri);
		double subscapular = Double.parseDouble(sub);
		double abdomen = Double.parseDouble(ab);
		double suprailac = Double.parseDouble(sup);
		double thigh = Double.parseDouble(thi);
		double sum = chest + midaxillary + tricep + subscapular + abdomen + suprailac + thigh;
		double bd;
		if (gender.equals("M")) {
			bd = 1.112 - ( 0.00043499 * sum) + (0.00000055 * (sum * sum)) - (0.00028826 * age);
		}
		else {
			bd = 1.097 - (0.00046971 * sum) + (0.00000056 * (sum * sum)) - (0.00012828 * age);
		}
		String result = String.format("%.2f", bd);
		return result;
	}
	

}
