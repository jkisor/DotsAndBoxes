public class Box
{
    Edge[] edges;
    String owner;

    public Box()
    {
        edges = new Edge[4];
        edges[0] = new Edge("N");
        edges[1] = new Edge("E");
        edges[2] = new Edge("S");
        edges[3] = new Edge("W");

        owner = "";
    }
    public String owner()
    {
        return owner;
    }

    public void claimEdge(String edgeId, String playerID)
    {
        if (isAllEdgesClaimed())
            return;

        Edge edge = getEdgeById(edgeId);
        edge.claim(playerID);

        if (isAllEdgesClaimed())
            owner = playerID;
    }

    private Edge getEdgeById(String edgeId)
    {
        for (int i = 0; i < edges.length; i++)
            if(edges[i].id.equals(edgeId))
                return edges[i];

        return null;
    }

    private boolean isAllEdgesClaimed()
    {
        for (int i = 0; i < edges.length; i++)
        {
            Edge e = edges[i];
            if(e.owner().equals(""))
                return false;
        }
        return true;
    }
}
