import java.util.*;
public class GameManager
{
    GridReader gr = new GridReader();
    HashMap<CoordinatePair, Gems> grid = gr.ReadGrid();
    WriteLeaderboard writer = new WriteLeaderboard();
    ArrayList<Players> players = new ArrayList<>();
    CommandReader commandReader = new CommandReader();
    private int numberOfPlayers = 0;
    public void Play()
    {
        int yesno = 0;
        int currentCommandLine = 0;
        System.out.println("Bejeweled Game Clone by Nuri Yalcin");
        do
        {
            numberOfPlayers++;
            grid = gr.ReadGrid(); //Resetting the grid.

            int a=0,b;
            String ans = "";
            String fAns = "",sAns = "";
            int commandSize = commandReader.commands().size();
            int toursPlayed = 0; //Resetting new player's move count
            int score = 0; //Resetting new player's score
            while (a < 10)
            {
                System.out.println();
                PrintGrid(grid);
                System.out.print("Select a coordinate or enter E to end the game : ");

                String input1 = commandReader.commands().get(currentCommandLine);
                if(input1.equals("E"))
                {
                    System.out.println("E");
                    break;
                }
                else
                    a = Integer.valueOf(input1);

                String input2 = commandReader.commands().get(currentCommandLine+1);
                if(input2.equals("E"))
                {
                    System.out.println("E");
                    break;
                }
                else
                    b = Integer.valueOf(input2);

                System.out.print(a + " " + b+"\n");

                currentCommandLine += 2;

                toursPlayed++;
                score += grid.get(new CoordinatePair(a, b)).CheckMatches(grid);
            }
            currentCommandLine++;
            System.out.println("Thanks for playing.\n");

            String playerName = commandReader.commands().get(currentCommandLine);
            GetPlayer(playerName,score);
            currentCommandLine++;

            //Bubble Sort for players ArrayList
            if(players.size() > 1)
                BubbleSort(players);

            int playerIndex = 0;
            for(int i=0;i<players.size();i++)
                if(players.get(i).getPlayerName().equals(playerName))
                    playerIndex = i;

            WriteToTextFile(players); //Leaderboard writing on text file

            System.out.println("Your game session summary is : ");
            System.out.println("Name : "+playerName);
            System.out.println("Score : "+score+" in "+toursPlayed+" moves");

            if(numberOfPlayers > 1) {
                System.out.println("You are the " + (playerIndex + 1) + ". player in the list.");

                System.out.println("You need "+(players.get(playerIndex-1).getTotalScore()-score)+" points to be "+ (playerIndex) + " in the list.");
            }

            System.out.print("\nDo you want to play again (0/1) : ");
            yesno = Integer.valueOf(commandReader.commands().get(currentCommandLine));
            System.out.println(yesno);
            currentCommandLine++;
        }while(yesno != 0);
        System.out.print("\nThanks for playing.");
    }
    private void GetPlayer(String name,int score)
    {
        System.out.print(numberOfPlayers + ". Player's name: ");
        System.out.println(name);
        players.add(new Players(name,score));
    }
    private void PrintGrid(HashMap<CoordinatePair,Gems> grid)
    {
        CheckFalls(grid);

        int n = (int)Math.sqrt(grid.size());
        System.out.println(" |0  1  2  3  4  5  6  7  8  9");
        System.out.println("-+----------------------------");
        for(int i=0;i<n;i++)
        {
            System.out.print(i+"|");
            for(int j=0;j<n;j++)
            {
                System.out.print(grid.get(new CoordinatePair(j,i)).getSymbol()+"  ");
            }
            System.out.println();
        }
    }
    private void CheckFalls(HashMap<CoordinatePair, Gems> grid)
    {
        int n = (int) Math.sqrt(grid.size());

        for (int col = 0; col < n; col++)
        {
            for (int row = n - 1; row >= 0; row--)
            {
                Gems currentGem = grid.get(new CoordinatePair(col, row));
                if (currentGem.isBlank())
                    continue;

                int newRow = row;
                while (newRow < n - 1 && grid.get(new CoordinatePair(col, newRow + 1)).isBlank())
                    newRow++;

                if (newRow != row)
                    GemSwapper(grid, col, row, newRow);
            }
        }
    }
    private void GemSwapper(HashMap<CoordinatePair, Gems> grid, int col, int currentRow, int newRow)
    {
        Gems currentGem = grid.get(new CoordinatePair(col, currentRow));
        grid.put(new CoordinatePair(col, newRow), currentGem);
        grid.put(new CoordinatePair(col, currentRow), new BlankGem(col, currentRow));
        currentGem.setRowNumber(newRow);
    }
    private void WriteToTextFile(ArrayList<Players> playerList)
    {
        String text = "";
        for(int i=0;i<playerList.size();i++)
        {
            Players pla = playerList.get(i);
            if(i == playerList.size()-1)
                text += String.format("%d. %s %d",i+1,pla.getPlayerName(),pla.getTotalScore());
            else
                text += String.format("%d. %s %d\n",i+1,pla.getPlayerName(),pla.getTotalScore());
        }
        writer.LeaderboardWriter(text);
    }
    private void BubbleSort(ArrayList<Players> players)
    {
        int n = players.size();
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (players.get(j).getTotalScore() < players.get(j + 1).getTotalScore())
                {
                    // swap playersList[j] and playersList[j+1]
                    Players temp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, temp);
                }
            }
        }
    }
}