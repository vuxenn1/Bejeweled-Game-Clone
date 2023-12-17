import java.io.*;
public class Monitoring
{
    public void Monitor()
    {
        try
        {
            String monitorPath = "src\\monitoring.txt";

            // Create a FileOutputStream to write to the file
            FileOutputStream fileOutputStream = new FileOutputStream(monitorPath);

            // Create a PrintStream that writes to the file
            PrintStream printStream = new PrintStream(fileOutputStream);

            // Redirect System.out to the file
            System.setOut(printStream);

            GameManager gameManager = new GameManager();
            gameManager.Play();

            // Restoring the original System.out
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

            // Closing the file stream
            fileOutputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}