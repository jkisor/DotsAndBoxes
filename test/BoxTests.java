import junit.framework.Assert;
import org.junit.Test;

public class BoxTests
{
    @Test
    public void freshBoxIsNotOwned()
    {
        Box box = new Box();
        Assert.assertEquals("", box.owner());
    }

    @Test
    public void boxIsOwnedByPlayerWhoClaimsLastEdge()
    {
        Box box = new Box();
        box.claimEdge("N", "Player1");
        box.claimEdge("S", "Player1");
        box.claimEdge("E", "Player1");
        box.claimEdge("W", "Player2");

        Assert.assertEquals("Player2", box.owner());
    }
}
