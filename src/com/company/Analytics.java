package com.company;
import java.sql.*;
import java.time.DayOfWeek;
import java.util.Calendar;

        class Analytics {
        	public static void main (String[] args) {
        		try{
        			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Hstomar@123");

					Statement stmt=con.createStatement();

        			ResultSet r_highestDayVolume=stmt.executeQuery("select sr_no, count from days where count=(select max(count) from days);");

        			while(r_highestDayVolume.next()) {

        				System.out.println("The day of the week when call volume is the highest: "+DayOfWeek.of(r_highestDayVolume.getInt(1)-1).toString());
        			}

					  ResultSet r_highestHourVolume=stmt.executeQuery("select sr_no, count from hours where count=(select max(count) from hours);");

					  while(r_highestHourVolume.next()) {
						  int hr=r_highestHourVolume.getInt(1);
					  System.out.println("The hour with the highest volume of calls is between "+hr+" - "+(hr+1)+" ");
					}

        			ResultSet r_duration=stmt.executeQuery("select * from records where duration=(select max(duration) from records);");

        			while(r_duration.next()) {
        				Calendar start_hour_duration=Calendar.getInstance();
        				Calendar end_hour_duration=Calendar.getInstance();
        				start_hour_duration.setTime(r_duration.getTime(3));
        				end_hour_duration.setTime(r_duration.getTime(4));

        				int start_duration_hr=start_hour_duration.get(Calendar.HOUR);
        				int end_duration_hr=end_hour_duration.get(Calendar.HOUR);

        				if(start_hour_duration!=end_hour_duration) {

        					System.out.println("The hour with the highest duration of calls is between "+start_duration_hr+" - "+(end_duration_hr+1) );
        				}

        				  Calendar start_day_duration=Calendar.getInstance();
        				  Calendar end_day_duration=Calendar.getInstance();

        				  start_day_duration.setTime(r_duration.getDate(3));
        				  end_day_duration.setTime(r_duration.getDate(4));
        				  int start_day=start_day_duration.get(Calendar.DAY_OF_WEEK);
        				  int end_day=end_day_duration.get(Calendar.DAY_OF_WEEK);


        					  System.out.println("The day of the week with the highest duration are: "+DayOfWeek.of(start_day-1).toString());



        			}
        			con.close();

        	}

        		 catch(Exception e) {
        		   System.out.println(e);
        			}

        		}
        }



