import java.io.*;
public class WriteLeaderboard
{
    public void LeaderboardWriter(String text)
    {
        String leaderboardPath = "src\\leaderboard.txt";
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(leaderboardPath));
            bw.write(text);
            bw.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
