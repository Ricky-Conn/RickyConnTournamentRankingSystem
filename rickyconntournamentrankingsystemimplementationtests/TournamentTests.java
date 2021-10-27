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

    @Test
    public void alphabeticalOrderAllSamePointsTest()
    {
        Tournament tournament = new Tournament(testDirectory+"manySamePoints.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedManySamePoints.txt"));
    }
    
    
    @Test
    public void orderNotAllSamePointsTest()
    {
        Tournament tournament = new Tournament(testDirectory+"alphabeticalOrderNotAllTies.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedAlphabeticalOrderNotAllTies.txt"));
    }
    
    @Test
    public void allDifferentPoints()
    {
        Tournament tournament = new Tournament(testDirectory+"allDifferentPoints.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedAllDifferentPoints.txt"));
    }
    
    @Test
    public void oneMatchTest()
    {
        Tournament tournament = new Tournament(testDirectory+"oneMatch.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedOneMatch.txt"));
    }
    
    @Test
    public void noMatchestest()
    {
        Tournament tournament = new Tournament(testDirectory+"noMatches.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedNoMatches.txt"));
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
