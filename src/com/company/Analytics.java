package com.company;
import java.sql.*;
import java.time.DayOfWeek;
import java.util.Calendar;

        class Analytics {
        	public static void main (String[] args) {
        		try{   
				//connecting to the database
        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Hstomar@123");
                                         
				//root and password are respective username and password to the database used
					Statement stmt=con.createStatement();
                                  
				//executing query to get details of highest day volume
        			ResultSet r_highestDayVolume=stmt.executeQuery("select sr_no, count from days where count=(select max(count) from days);");
                                 
				//Loop if there are multiple highest values     
        			while(r_highestDayVolume.next()) {
                                        
					//Printing the day of the week
        				System.out.println("The day of the week when call volume is the highest: "+DayOfWeek.of(r_highestDayVolume.getInt(1)-1).toString());
        			}
                                         //Executing query to get details of highest hour volume 
					  ResultSet r_highestHourVolume=stmt.executeQuery("select sr_no, count from hours where count=(select max(count) from hours);");

					  while(r_highestHourVolume.next()) {
						  int hr=r_highestHourVolume.getInt(1);
					  System.out.println("The hour with the highest volume of calls is between "+hr+" - "+(hr+1)+" ");
					}
                                  
				//query to get details of maximum duration of days and hours
        			ResultSet r_duration=stmt.executeQuery("select * from records where duration=(select max(duration) from records);");

        			while(r_duration.next()) {
        				Calendar start_hour_duration=Calendar.getInstance();
        				Calendar end_hour_duration=Calendar.getInstance();
        				start_hour_duration.setTime(r_duration.getTime(3));
        				end_hour_duration.setTime(r_duration.getTime(4));

        				int start_duration_hr=start_hour_duration.get(Calendar.HOUR);
        				int end_duration_hr=end_hour_duration.get(Calendar.HOUR);
                                          
					//to get maximum duration in hours
        				if(start_hour_duration!=end_hour_duration) {

        					System.out.println("The hour with the highest duration of calls is between "+start_duration_hr+" - "+(end_duration_hr+1) );
        				}

        				  Calendar start_day_duration=Calendar.getInstance();
        				  Calendar end_day_duration=Calendar.getInstance();

        				  start_day_duration.setTime(r_duration.getDate(3));
        				  end_day_duration.setTime(r_duration.getDate(4));
        				  int start_day=start_day_duration.get(Calendar.DAY_OF_WEEK);
        				  int end_day=end_day_duration.get(Calendar.DAY_OF_WEEK);
                                            
					    //to get maximum duration of days
                                              if(start_day!=end_day){  
        					  System.out.println("The day of the week with the highest duration are: "+DayOfWeek.of(start_day-1).toString());

					      }

        			}
				//terminating connection to the database
        			con.close();

        	}
                          //catching if there is any exception 
        		 catch(Exception e) {
        		   System.out.println(e);
        			}

        		}
        }



