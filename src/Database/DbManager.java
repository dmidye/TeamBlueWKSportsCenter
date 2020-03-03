package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * DbManager helps to keep the GUI classes less cluttered and keeps most or all database operations in one place.
 * 
 */
public class DbManager {
	//get connection to database
		private Connection conn;
		
		private final String DB_USER = "root";
		private final String DB_PASS = "";
		private final String DB_URL = "jdbc:mysql://localhost:3306/wk_sports_center_db";
		
		private String s = "', '"; //abbreviation
		
		public DbManager() throws SQLException {
			
		      conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		
		/*
		 * Insert a trainer note into the database - Erika Clark
		 *  used Daniel's model
		 * 
		 */
		
		 public boolean newTrainerNotes(int memberID, int trainerid, String trainingNotes) throws SQLException, ParseException {
	        	
	        	// Create a connection to the database.
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	            // Create a Statement object for the query.
	            Statement stmt = conn.createStatement();
	          
	            ResultSet member = lookupMember(memberID);
			    String username = member.getString("username");
			    
	            Date date = new Date();
		        String pattern = "yyyy-MM-dd";
		        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		        String mysqlDateString = formatter.format(date);
	            
	            try {
	        	    stmt.executeUpdate("INSERT INTO wk_sports_center_db.trainingnotes"
	        					+ "(username, memberID, date, trainerid, trainingNotes)"
	        					+ "VALUES('" + username + s + memberID + s + mysqlDateString + s 
	        					+ trainerid + s + trainingNotes +"')");
	        			   	    
	        	    conn.close();
	        	   
	        	    return true;
	            } catch(Exception e) {
	            	e.printStackTrace();
	            	conn.close();
	            	return false;
	        	}
	        }
		
		/*
		 * new member to the database - Renella Martin
		 * used Daniel's model
		 * Debugged and integrated into GUI by - Erika Clark
		 * 
		 */
		 public boolean createNewMember(String userName, String firstName, String lastName, String email, Date birthday, String password, 
				 int createdBy, Integer phone, Integer areaCode, String status) throws SQLException, ParseException {
	        	
	        	// Create a connection to the database.
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	            // Create a Statement object for the query.
	            Statement stmt = conn.createStatement();
	          
	            Date date = new Date();
	            String pattern = "yyyy-MM-dd";
	            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	            String currentDateString = formatter.format(date);
	            String birthdayString = formatter.format(birthday);
	            
	            try {
	        	    stmt.executeUpdate("INSERT INTO wk_sports_center_db.user "
	        					+ "(username, memberFirst, memberLast, memberEmail, memberBday, memberPswd, "
	        					+ "areaCode, phone, status, memberStart, createdBy)"
	        					+ "VALUES('" + userName + s + firstName + s + lastName + s + email + s + birthdayString + s + 
	        					password + s + areaCode + s + phone + s + status + s +currentDateString + s + createdBy +"')");
	        			   	    
	        	    conn.close();
	        	   
	        	    return true;
	            } catch(Exception e) {
	            	e.printStackTrace();
	            	conn.close();
	            	return false;
	        	}
	        }
		     /*	Daniel Midyett
			 * Update member
			 * 
			 */
			 public boolean updateMember(String userName, String firstName, String lastName, String email, Date birthday, String password, 
					 int createdBy, Integer phone, Integer areaCode, String status) throws SQLException, ParseException {
		        	
		        	// Create a connection to the database.
		            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		            // Create a Statement object for the query.
		            Statement stmt = conn.createStatement();
		            String pattern = "yyyy-MM-dd";
		            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		            String birthdayString = formatter.format(birthday);    
		            try {
		        	    stmt.executeUpdate("UPDATE wk_sports_center_db.user "
		        					+ "SET memberFirst = '" + firstName + "', memberLast = '" + lastName + 
		        					"', memberEmail = '" + email + "', memberBday = '" + birthdayString + 
		        					"', memberPswd = '" + password + "', phone = '" + phone + 
		        					"', areaCode = '" + areaCode + "', status = '" + status + "'"
		        				   + "WHERE username = '" + userName + "'");
		        			   	    
		        	    conn.close();
		        	   
		        	    return true;
		            } catch(Exception e) {
		            	e.printStackTrace();
		            	conn.close();
		            	return false;
		        	}
		        }
			 
 /* Daniel Midyett
  * Lookup member based on user name
  * 
 */
	 public ResultSet lookupMember(String userName)  throws SQLException, ParseException {
        	
        	// Create a connection to the database.
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
  
            // Create a Statement object for the query.
            Statement stmt = conn.createStatement();
         
            try {
            	PreparedStatement statement = conn.prepareStatement("SELECT * FROM wk_sports_center_db.user "
            													  + "WHERE username LIKE " + "'" + userName + "'");
                ResultSet rs = statement.executeQuery(); 
                if(rs.next() == false) {
                	return null;
                } else {
                	return rs;
                }
            } catch(Exception e) {
            	e.printStackTrace();
            }
            return null;
	 }
				 
 /* Daniel Midyett
  * Overloaded method to lookup member based on id
  * 
 */
	 public ResultSet lookupMember(int id)  throws SQLException, ParseException {
        	
        	// Create a connection to the database.
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
  
            // Create a Statement object for the query.
            Statement stmt = conn.createStatement();
         
            try {
            	PreparedStatement statement = conn.prepareStatement("SELECT * FROM wk_sports_center_db.user "
            													  + "WHERE memberID = " + id);
		                ResultSet rs = statement.executeQuery(); 
		                if(rs.next() == false) {
		                	return null;
		                } else {
		                	return rs;
		                }
		            } catch(Exception e) {
		            	e.printStackTrace();
		            }
		            return null;
			 }
 
 /* Daniel Midyett
  * Delete member based on user name
  * 
 */
			 public boolean deleteMember(String userName)  throws SQLException, ParseException {
		        	
		        	// Create a connection to the database.
		            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		  
		            // Create a Statement object for the query.
		            Statement stmt = conn.createStatement();
		           
		            //see if the record exists. If not, return false
		            try {
		            	PreparedStatement statement = conn.prepareStatement("SELECT * FROM wk_sports_center_db.user "
		            			                                          + "WHERE username LIKE " + "'" + userName + "'");
		                ResultSet rs = statement.executeQuery(); 
		                if(rs.next() == false) {
		                	return false;
		                }
		            } catch(Exception e) {
		            	e.printStackTrace();
		            }
		            try {
		        	    stmt.executeUpdate("DELETE FROM wk_sports_center_db.user "
		        	    		         + "WHERE username LIKE " + "'" + userName + "'");
		        	    conn.close();
		        	    return true;
		            } catch(Exception e) {
		            	e.printStackTrace();
		            	conn.close();
		            	return false;
		        	}
		        }
 /*	Daniel Midyett
	 * Update BMI calculation
	 * 
	 */
		 public boolean updateBMI(int id, double bmi) throws SQLException, ParseException {
	        	
	        	// Create a connection to the database.
	            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

	            // Create a Statement object for the query.
	            Statement stmt = conn.createStatement();
	            
	            try {
	        	    stmt.executeUpdate("UPDATE wk_sports_center_db.bodycomp "
	        						 + "SET BMI = '" + bmi + "' "
	        						 + "WHERE memberID = '" + id + "'" );
	        			  	    
	        	    conn.close();
	        	   
	        	    return true;
	            } catch(Exception e) {
	            	e.printStackTrace();
	            	conn.close();
	            	return false;
	        	}
	        }
 /*	Daniel Midyett
 * Update BMI calculation
 * 
 */
 public boolean updateVO2(int id, double maxVO2) throws SQLException, ParseException {
    	
    	// Create a connection to the database.
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

        // Create a Statement object for the query.
        Statement stmt = conn.createStatement();
        
        try {
    	    stmt.executeUpdate("UPDATE wk_sports_center_db.aerobiccapacity "
    						 + "SET maxVO2 = '" + maxVO2 + "' "
    						 + "WHERE memberID = '" + id + "'" );
    			  	    
    	    conn.close();
    	   
    	    return true;
        } catch(Exception e) {
        	e.printStackTrace();
        	conn.close();
        	return false;
    	}
    }
		 
		/*
		 * Adds a a form to the aerobiccapacity table.
		 * Generates the current date.
		 */
		public boolean createNewMemberACForm(int memberID, int trainerID, int heartRateMax, int restedHeartRate, int finalTestHeartRate, 
				int minTargetHeartRate, int maxTargetHeartRate, String protocol, int timeInMin, double maxVO2) throws SQLException, ParseException {
			
			// Create a connection to the database.
		    conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		    // Create a Statement object for the query.
		    Statement stmt = conn.createStatement();

		    ResultSet member = lookupMember(memberID);
		    String username = member.getString("username");
		    
		    Date date = new Date();
	        String pattern = "yyyy-MM-dd";
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        String mysqlDateString = formatter.format(date);
	        
	        try {
			    stmt.executeUpdate("INSERT INTO aerobiccapacity "
	    					+ "(username, memberID, date, trainerID, heartRateMax, restedHeartRate, finalTestHeartRate, minTargetHeartRate, maxTargetHeartRate, protocol, timeInMin, maxVO2)"
	    					+ "VALUES('" + username + s + memberID + s + mysqlDateString + s + trainerID + s + heartRateMax + s + restedHeartRate 
	    					+ s + finalTestHeartRate + s + minTargetHeartRate + s + maxTargetHeartRate
	    					+ s + protocol.toLowerCase().trim() + s + timeInMin + s + maxVO2 + "')");
			    conn.close();
			    return true;
	        } catch(Exception e) {
	        	e.printStackTrace();
	        	conn.close();
	        	return false;
	        }
		}
		
		public boolean createNewMemberSFForm(int memberID, int trainerID, int pushUps, int sitUps, int sitReach) throws SQLException, ParseException {
			
			// Create a connection to the database.
		    conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		    // Create a Statement object for the query.
		    Statement stmt = conn.createStatement();

		    ResultSet member = lookupMember(memberID);
		    String username = member.getString("username");
		    
		    Date date = new Date();
	        String pattern = "yyyy-MM-dd";
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        String mysqlDateString = formatter.format(date);
	        
	        try {
			    stmt.executeUpdate("INSERT INTO strengthflexibility "
	    					+ "(username, memberID, date, trainerID, pushups, situps, sitreach)"
	    					+ "VALUES('" + username + s + memberID + s + mysqlDateString + s + trainerID + s + pushUps + s + sitUps 
	    					+ s + sitReach + "')");
			    conn.close();
			    return true;
	        } catch(Exception e) {
	        	e.printStackTrace();
	        	conn.close();
	        	return false;
	        }
		}
		
		
		public boolean createNewMemberBCForm(int memberID, int trainerID, double BMI, int domForearm, int domArm, int domThigh, int domAbdomen, 
				int waistCircumference, int hipCircumference, String bodyCompProtocol, int chest, int midAxillary, int triceps, int subscapular, int abdomen,
				int supralliac, int thigh, int percentBodyFat, int leanWeight, int fatWeight, int desiredWeight) throws SQLException, ParseException {
			
			// Create a connection to the database.
		    conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		    
		    // Create a Statement object for the query.
		    Statement stmt = conn.createStatement();
		    
		    ResultSet member = lookupMember(memberID);
		    String username = member.getString("username");
		 
		    Date date = new Date();
	        String pattern = "yyyy-MM-dd";
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        String mysqlDateString = formatter.format(date);
	        
	        try {
			    stmt.executeUpdate("INSERT INTO bodycomp"
	    					+ "(username, memberID, date, trainerID, BMI, domForearm, domArm, domThigh, domAbdomen, waistCircumference,"
	    					+ " hipCircumference, bodyCompProtocol, chest, midaxillary, triceps, subscapular, abdomen, suprailliac, thigh,"
	    					+ " percentBodyFat, leanWeight, fatWeight, desiredWeight)"
	    					+ "VALUES('" + username + s + memberID + s + mysqlDateString + s + trainerID + s + BMI + s + domForearm + s + domArm + s + domThigh
	    					+ s + domAbdomen + s + waistCircumference + s + hipCircumference + s + bodyCompProtocol + s + chest + s + midAxillary 
	    					+ s + triceps + s + subscapular + s + abdomen + s + supralliac + s + thigh + s + percentBodyFat + s + leanWeight + s + fatWeight + s + desiredWeight + "')");
			    conn.close();
			    return true;
	        } catch(Exception e) {
	        	e.printStackTrace();
	        	conn.close();
	        	return false;
	        }
		}
		
		public boolean createNewMemberCRForm(int memberID, int trainerID, int systolicBP, int diastolicBP, int idealBodyWeight, String physicalActivity, 
				int totalCholesterol, int hdlRatio, int hdlCholesterol, int ldlCholesterol, int triglycerides, int glucose) throws SQLException, ParseException {
			
			// Create a connection to the database.
		    conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		    // Create a Statement object for the query.
		    Statement stmt = conn.createStatement();

		    ResultSet member = lookupMember(memberID);
		    String username = member.getString("username");
		    
		    Date date = new Date();
	        String pattern = "yyyy-MM-dd";
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        String mysqlDateString = formatter.format(date);
	        
	        try {
			    stmt.executeUpdate("INSERT INTO coronaryrisk "
	    					+ "(username, memberID, date, trainerID, systolicBloodPressure, diastolicBloodPressure, yearsSmoked, idealBodyWeight, physicalActivity, totalCholesterol, hdlCholesterol, ldlCholesterol, hdlRatio, triglycerides, glucose)"
	    					+ "VALUES('" + username + s + memberID + s + mysqlDateString + s + trainerID + s + systolicBP + s + diastolicBP + s + 0 + s +  idealBodyWeight + s + physicalActivity + s + totalCholesterol
	    					+ s + hdlCholesterol + s + ldlCholesterol + s + hdlRatio + s + triglycerides + s + glucose +  "')");
			    conn.close();
			    return true;
	        } catch(Exception e) {
	        	e.printStackTrace();
	        	conn.close();
	        	return false;
	        }
		}
}
