About this project:

This program will calculate the ranking table for a league. In this league, a draw (tie) is worth 1 point and a win is worth 3 points. A loss is worth 0 points. 
If two or more teams have the same number of points, they should have the same rank and be printed in alphabetical order (as in the tie for 3rd place in the sample data).


Assumptions:

-Teams can not have the same name.
-Input will be well formed, meaning no error handling needs to be done for bad inputs.


Setup Steps:

1. cd into root of project i.e. the RickyConnTournamentRankingSystem directory
2. compile using the following command: javac -cp . rickyconntournamentrankingsystemimplementation/TournamentRankingSystem.java
3. run using the following command: java rickyconntournamentrankingsystemimplementation/TournamentRankingSystem rickyconntournamentrankingsystemimplementation/matches.txt
4. compile the test class using following command: javac -cp junit-jupiter-engine.jar:junit-jupiter-engine.jar:junit-4.12.jar:hamcrest-core-1.3.jar:. rickyconntournamentrankingsystemimplementationtests/TournamentTests.java
5. run the tests using the following command: java -cp junit-jupiter-engine.jar:junit-jupiter-engine.jar:junit-4.12.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore rickyconntournamentrankingsystemimplementationtests.TournamentTests