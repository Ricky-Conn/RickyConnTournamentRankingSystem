package rickyconntournamentrankingsystemimplementationtests;

import rickyconntournamentrankingsystem.Tournament;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.junit.Assert;
import org.junit.Test;

public class TournamentTests
{
    private String testDirectory = "rickyconntournamentrankingsystemimplementationtests"+File.separator+"tests"+File.separator;

    @Test //to see if ordering still works when all teams had the same points.
    public void alphabeticalOrderAllSamePointsTest()
    {
        Tournament tournament = new Tournament(testDirectory+"manySamePoints.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines(testDirectory+"expectedManySamePoints.txt"));
    }
    
    
    @Test //to see if ordering still works when there's a mix of ties and wins i.e. not all with same points.
    public void orderNotAllSamePointsTest()
    {
        Tournament tournament = new Tournament(testDirectory+"alphabeticalOrderNotAllTies.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines(testDirectory+"expectedAlphabeticalOrderNotAllTies.txt"));
    }
    
    @Test //to see if points are calculated correctly and results ordered correctly when all different.
    public void allDifferentPoints()
    {
        Tournament tournament = new Tournament(testDirectory+"allDifferentPoints.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines(testDirectory+"expectedAllDifferentPoints.txt"));
    }
    
    @Test //input of one match.
    public void oneMatchTest()
    {
        Tournament tournament = new Tournament(testDirectory+"oneMatch.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines(testDirectory+"expectedOneMatch.txt"));
    }
    
    @Test //input of no matches.
    public void noMatchestest()
    {
        Tournament tournament = new Tournament(testDirectory+"noMatches.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines(testDirectory+"expectedNoMatches.txt"));
    }
    
    public String readFileWithNewlines(String filename)
    {
        StringBuilder expectedOutput = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String expectedMatch = reader.readLine();

            while (expectedMatch != null)
            {
                expectedOutput.append(expectedMatch);
                expectedOutput.append("\n");
                expectedMatch = reader.readLine();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex);
        }
        String results = expectedOutput.toString();
        if(results.contains("\n"))
        {
            results = results.substring(0, results.lastIndexOf("\n"));
        }
        return results;
    }
}