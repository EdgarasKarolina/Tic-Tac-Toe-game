package Model;

public class Game {

    public Player player1;
    public Player player2;
    private String status;

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
