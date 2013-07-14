public class Game
{
    public int activePlayer;
    private Box[][] boxes;

    public Game(int width, int height)
    {
        boxes = new Box[width][height];
        for (int i = 0; i < boxes.length; i++)
            for (int j = 0; j < boxes[i].length; j++)
                boxes[i][j] = new Box();
    }

    public void claimEdge(int x, int y, String edgeId)
    {
        Box box = boxes[x][y];
        if(!box.owner().equals(""))
            return;

        box.claimEdge(edgeId, activePlayer+"");

        if(box.owner().equals(""))
        {
            ++activePlayer;
            activePlayer %= 2;
        }
    }

    public boolean isOver()
    {
        for (int i = 0; i < boxes.length; i++)
        {
            for (int j = 0; j < boxes[i].length; j++)
            {
                Box box = boxes[i][j];
                if(box.owner().equals(""))
                    return false;
            }
        }
        return true;
    }

    public int winner()
    {
        if(!isOver())
            return -1;

        int player1Score = 0;
        int player2Score = 0;
        for (int i = 0; i < boxes.length; i++)
        {
            for (int j = 0; j < boxes[i].length; j++)
            {
                Box box = boxes[i][j];
                if(box.owner().equals("0"))
                    player1Score++;
                else
                    player2Score++;
            }
        }

        if(player1Score > player2Score)
            return 0;
        else
            return 1;
    }
}