package HandleBuildFailures.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 11/14/16.
 */
public class BuildeStudio
{
    public static void main(String args[]) throws IOException
    {
        String directoryPath;
        System.out.println("Enter the DirectoryPath");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        directoryPath=bufferedReader.readLine();

        ManipulateContent manipulateContent = new ManipulateContent();
        //manipulateContent.setContent(directoryPath);
        ManipulateContent.check(directoryPath);
    }
}
