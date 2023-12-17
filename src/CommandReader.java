import java.io.*;
import java.util.ArrayList;
public class CommandReader
{
    public ArrayList<String> commands() {
        String filepath = "src\\commands.txt";
        StringBuilder abc = new StringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String a;

            while ((a = br.readLine()) != null)
            {
                abc.append(a).append("\n");
            }
            br.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        ArrayList<String> chars = new ArrayList<>();

        for (String part : abc.toString().split("\\s+"))
        {
            String name = "";
            if (part.matches("[0-9]+")) {
                chars.add(part);
            } else
            {
                for (char c : part.toCharArray())
                {
                    name += Character.toString(c);
                }
                chars.add(name);
            }
        }

        return chars;
    }
}