import org.junit.Assert;
import org.junit.Test;

public class GameTests
{
    @Test
    public void playersTakeTurns()
    {
        Game game = new Game(1,1);
        game.activePlayer = 0;
        game.claimEdge(0, 0, "N");
        Assert.assertEquals(1, game.activePlayer);
        game.claimEdge(0, 0, "E");
        Assert.assertEquals(0, game.activePlayer);
    }

    @Test
    public void gameIsOverWhenAllBoxesAreClaimed()
    {
        Game game = new Game(1,1);
        game.claimEdge(0,0, "N");
        game.claimEdge(0,0, "E");
        game.claimEdge(0,0, "S");
        game.claimEdge(0,0, "W");
        Assert.assertTrue(game.isOver());
    }

    @Test
    public void freshGameIsNotOver()
    {
        Game game = new Game(1,1);
        Assert.assertFalse(game.isOver());

    }

    @Test
    public void playerWithMostOwnedBoxesWins()
    {
        Game game = new Game(2,2);
        game.activePlayer = 0;
        for (int x = 0; x < 2; x++)
        {
            for (int y = 0; y < 2; y++)
            {
                game.claimEdge(x,y,"N");    //0
                game.claimEdge(x,y,"S");    //1
                game.claimEdge(x,y,"E");    //0
                game.claimEdge(x,y,"W");    //1
            }
        }
        Assert.assertEquals(1, game.winner());
        Assert.assertTrue(game.isOver());
    }

    @Test
    public void byClaimingTheLastEdgePlayerGetsAnotherTurn()
    {
        Game game = new Game(2,2);
        game.activePlayer = 0;
        game.claimEdge(0,0,"N");    //0
        game.claimEdge(0, 0, "S");  //1
        game.claimEdge(0,0,"E");    //0
        game.claimEdge(0,0,"W");    //1

        Assert.assertEquals(1, game.activePlayer);
    }
}
