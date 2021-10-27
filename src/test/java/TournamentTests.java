import com.spandigital.rickyconntournamentrankingsystem.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class TournamentTests
{
    @Test
    public void alphabeticalOrderTest()
    {
        Tournament tournament = new Tournament("manySamePoints.txt");
        Assert.assertEquals(tournament.getResults(), "1. Ben, 1 pts\n2. FC Awesome, 1 pts\n3. Grouches, 1 pts\n4. Lions, 1 pts\n5. Snakes, 1 pts\n6. Tarantulas, 1 pts");
    }
    
    
    @Test
    public void alphabeticalOrderNotAllTiesTest()
    {
        System.out.println(readFileWithNewlines("expectedManySamePoints.txt"));
        Tournament tournament = new Tournament("manySamePoints.txt");
//        Assert.assertEquals(tournament.getResults(), "1. Ben, 1 pts\n2. FC Awesome, 1 pts\n3. Grouches, 1 pts\n4. Lions, 1 pts\n5. Snakes, 1 pts\n6. Tarantulas, 1 pts");
        Assert.assertEquals(tournament.getResults(), readFileWithNewlines("expectedManySamePoints.txt"));
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
