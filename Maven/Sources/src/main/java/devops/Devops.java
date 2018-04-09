package devops;
import devops.filemanipulation.AddText;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * Created by Praveen on 9/27/2016.
 */
public class Devops
{
    public static void main(String args[]) throws IOException
    {
        String inputText;

        // Prompts for fileContent
        System.out.println("Enter the Text to be entered into the file");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        inputText = bufferedReader.readLine();

        //Initialising the class AddText and calling the method in it
        AddText addText = new AddText();
        addText.addContentToFile(inputText);
    }
}
