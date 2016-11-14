/**
 * Created by root on 11/14/16.
 */

package HandleBuildFailures.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildeStudio
{
    public static void main(String args[]) throws IOException
    {
        String extension, directoryPath;
        System.out.println("Enter the file extension to be modified");
        extension = new BufferedReader(new InputStreamReader(System.in)).readLine();
        switch(extension.toLowerCase())
        {
            case "xml":
                System.out.println("Enter the DirectoryPath");
                directoryPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
                ManipulateContent manipulateContent = new ManipulateContent();
                manipulateContent.check(directoryPath);
                break;
            case "product":
                System.out.println("Develop the code to handle this eStudio.product file");
                break;
            default:System.out.println("Please select the valid extension");
        }
    }
}
