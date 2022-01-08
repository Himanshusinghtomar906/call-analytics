# call-analytics
File Descriptions:
Source to the files:
Call Analytics/src/

Project Name: Call Analytics
DataUpdate.java- Updating tables to keep track of volumes
Analytics.java- Solving provided queries as Assignment
Database creation- queries executed to create the database

-----------
Specifications:
Database used: MySQL
Programming Language: Java
IDE used: Intellij
Name of the database: calldatabase
Table in which the provided data is stored: records
Database connectivity: mysql-connector-java-8.0.27.jar file

-----------
Though the problem can be solved in various ways, I have choosen the following to implement:
Procedure of Implementation:
I have done the following procedure:
1. Reading the records from the database
2. Created tables to keep a count of volume
days table- to keep track of days
hours table- to keep track of hours

3. Updating the days and hours tables according to the records available.

-----------
Assumptions:
1. Call can continue for multiple days and hours.
2. Database can be modified (without modifying the already provided tables)

For instance,
start_time: 13/01/2021 23:59:08 to 14/01/2021 00:00:54
Then two days and hours are taken into consideration i.e. 13/01/2021 , 14/01/2021 and 23,24 (or 12 AM).

-----------
Limitations:
1. This program doesn't calculate the hour with highest duration of calls by differentiating the duration.

Example:
Start_time=06:56:01
End_time=07:02:04
The output displays that highest duration is between both 6-7 AM and 7-8 AM. It doesn't take where the longest duration fit between the hours.
