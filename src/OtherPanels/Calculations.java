package OtherPanels;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DbManager;

public class Calculations {
	
	public String resultBMI(String bmiString) throws SQLException {
		double bmi = Double.parseDouble(bmiString);
		DbManager db = new DbManager();
		double[] limits = db.getBMIRanges();
		double underweightUpperLimit = limits[0];
		double goodUpperLimit = limits[1];
		double overweightUpperLimit = limits[2];

		if(bmi < underweightUpperLimit) {//18.5
			return "Underweight";
		}
		else if(bmi <= goodUpperLimit) {//24.9
			return "Good";			
		}
		else if(bmi <= overweightUpperLimit) {//29.9
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
	
	
	public String waistToHipRatioResult(String whratio, String gender) throws SQLException {
		double ratio = Double.parseDouble(whratio);
		DbManager db = new DbManager();
		double[] limits = db.getWaistToHipRanges();
		double maleUpperLimit = limits[0];
		double femaleUpperLimit = limits[1];

		if(gender.equals("M") && ratio < maleUpperLimit){
			return "Good";
		}
		if(gender.equals("F") && ratio < femaleUpperLimit) {
			return "Good";
		}
		return "Obese";
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
	public String calculateBodyDensity(int age, String gender, String ch, String ax, String tri, String sub, String ab, String sup, String thi) {
		
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
	
	//calculate target heart rate
	
	public String calculateMaxHeartRate(int age) {
		String result;
		int max = 220 - age;
		result = String.valueOf(max);
		return result;
	}
	
	public String minHRPercentageCalc(String max, String minPercent) {
		String result;
		double maxHeartRate = Double.parseDouble(max);
		double minHeartRatePercent = Double.parseDouble(minPercent);
		double minRange = (minHeartRatePercent / 100) * maxHeartRate;
		result = String.format("%.2f",  minRange);
		
		return result;
	}
	
	public String maxHRPercentageCalc(String max, String maxPercent) {
		String result;
		double maxHeartRate = Double.parseDouble(max);
		double maxHeartRatePercent = Double.parseDouble(maxPercent);
		double maxRange = (maxHeartRatePercent / 100) * maxHeartRate;
		result = String.format("%.2f",  maxRange);
		
		return result;
	}
	
	// Ranges taken from 
	//https://www.heart.org/en/health-topics/high-blood-pressure/understanding-blood-pressure-readings
	
	public String bloodPressureCalc(String s, String d) throws SQLException {
		String result = "";
		int systolic = Integer.parseInt(s);
		int diastolic = Integer.parseInt(d);
		DbManager db = new DbManager();
		double[] diasLimits = db.getDiastolicBPRanges();
		double[] sysLimits = db.getSystolicBPRanges();
		//Index: 0 for normal, 1 for elevated, 2 for stage one, 3 for stage two
		
		if(systolic < sysLimits[0] && diastolic < diasLimits[0]) {
			result = "normal";
		}else if(systolic <= sysLimits[1] && diastolic < diasLimits[1]) {
			result = "elevated";
		}else if((systolic >= sysLimits[1]+1 && systolic <= sysLimits[2]) || (diastolic >= diasLimits[1] && diastolic <= diasLimits[2])) {
			result = "HYPERTENSION Stage 1";
		}else if((systolic >= sysLimits[2]+1 && systolic < sysLimits[3]) || (diastolic >= diasLimits[2]+1 && diastolic < diasLimits[3])) {
			result = "HYPERTENSION Stage 2";
		}else if(systolic >= sysLimits[3] || diastolic >= diasLimits[3]) {
			result = "HYPERTENSIVE CRISIS";
		}
		return result;
	}
	
	public String hdlRatioCalc(String tc, String hc) {
		String result;
		
		double totalCholesterol = Double.parseDouble(tc);
		double hdlCholesterol = Double.parseDouble(hc);
		double hdlRatio = totalCholesterol / hdlCholesterol;
		result = String.format("%.2f", hdlRatio);
		
		return result;
	}
	
	public String ldlCholesterolCalc(String tc, String hc, String t) {
		String result;
		
		double totalCholesterol = Double.parseDouble(tc);
		double hdlCholesterol = Double.parseDouble(hc);
		double triglycerides = Double.parseDouble(t);
		double ldlCholesterol = totalCholesterol - hdlCholesterol - (triglycerides/5);
		result = String.format("%.2f", ldlCholesterol);
		
		return result;
	}
}
