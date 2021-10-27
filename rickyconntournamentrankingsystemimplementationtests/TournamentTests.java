import com.spandigital.rickyconntournamentrankingsystem.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TournamentTests
{
    @Test
    @DisplayName("Testing to see if ordering still works when all teams had the same points.")
    public void alphabeticalOrderAllSamePointsTest()
    {
        Tournament tournament = new Tournament("tests"+File.separator+"manySamePoints.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedManySamePoints.txt"));
    }
    
    
    @Test
    @DisplayName("Testing to see if ordering still works when there's a mix of ties and wins i.e. not all with same points.")
    public void orderNotAllSamePointsTest()
    {
        Tournament tournament = new Tournament("tests"+File.separator+"alphabeticalOrderNotAllTies.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedAlphabeticalOrderNotAllTies.txt"));
    }
    
    @Test
    @DisplayName("Testing to see if points are calculated correctly and results ordered correctly when all different.")
    public void allDifferentPoints()
    {
        Tournament tournament = new Tournament("tests"+File.separator+"allDifferentPoints.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedAllDifferentPoints.txt"));
    }
    
    @Test
    @DisplayName("Testing input of one match.")
    public void oneMatchTest()
    {
        Tournament tournament = new Tournament("tests"+File.separator+"oneMatch.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedOneMatch.txt"));
    }
    
    @Test
    @DisplayName("Testing input of no matches.")
    public void noMatchestest()
    {
        Tournament tournament = new Tournament("tests"+File.separator+"noMatches.txt");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("tests"+File.separator+"expectedNoMatches.txt"));
    }
    
    public String readFileWithNewlines(String filename)
    {
        StringBuilder expectedOutput = new StringBuilder();
        try
        {
            String fullFilePath = System.getProperty("user.dir") + File.separator + filename;
            BufferedReader reader = new BufferedReader(new FileReader(fullFilePath));
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
