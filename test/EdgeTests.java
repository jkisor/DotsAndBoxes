import org.junit.Assert;
import org.junit.Test;

public class EdgeTests
{
    @Test
    public void edgeIsNotOwnedByDefault()
    {
        Edge edge = new Edge("N");
        Assert.assertEquals("", edge.owner());
    }

    @Test
    public void unclaimedEdgeCanBeClaimed()
    {
        Edge edge = new Edge("N");
        edge.claim("Player1");
        Assert.assertEquals("Player1", edge.owner());
    }

    @Test
    public void edgeCanOnlybeClaimedOnce()
    {
        Edge edge = new Edge("N");
        edge.claim("Player1");
        edge.claim("Player2");
        Assert.assertEquals("Player1", edge.owner());
    }

}
