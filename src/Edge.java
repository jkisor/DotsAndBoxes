public class Edge
{
    public String id;
    private String owner;
    public Edge(String id)
    {
        this.id = id;
        this.owner = "";
    }

    public String owner()
    {
        return owner;
    }

    public void claim(String playerID)
    {
        if(hasNoOwner())
            owner = playerID;
    }

    private boolean hasNoOwner()
    {
        return owner.equals("");
    }
}
