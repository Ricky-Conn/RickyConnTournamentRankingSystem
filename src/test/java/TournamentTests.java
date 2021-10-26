import com.spandigital.rickyconntournamentrankingsystem.*;
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
}
