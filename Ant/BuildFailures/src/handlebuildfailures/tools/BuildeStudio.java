/**
 * Created by praveen on 11/14/16.
 */

package handlebuildfailures.tools;

import handlebuildfailures.tools.setcontent.ManipulateBuildFileContent;
import handlebuildfailures.tools.setcontent.ManipulateProductFileContent;
import handlebuildfailures.tools.plugins.SearchPlugins;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuildeStudio
{
    public static void main(String args[]) throws IOException
    {
        String extension;
        System.out.println("Enter the file extension to be modified");
        extension = new BufferedReader(new InputStreamReader(System.in)).readLine();
        switch(extension.toLowerCase())
        {

            case "xml":
                String option;
                System.out.println("Are you changing the file to stop or start the tools build. Type one among Start or stop and press enter");
                option=new BufferedReader(new InputStreamReader(System.in)).readLine();
                ManipulateBuildFileContent manipulateBuildFileContent = new ManipulateBuildFileContent();
                if(option.equalsIgnoreCase("start"))
                {
                    manipulateBuildFileContent.startToolsBuild();
                }
                else if(option.equalsIgnoreCase("stop"))
                {
                    manipulateBuildFileContent.stopToolsBuild();
                }
                else
                {
                    System.out.println("Please select the valid option");
                }
                break;

            case "product":
                String OS;
                int Bit;
                ManipulateProductFileContent manipulateProductFileContent = new ManipulateProductFileContent();
                System.out.println("Enter the operating System");
                OS=new BufferedReader(new InputStreamReader(System.in)).readLine();
                System.out.println("Enter the OS architechture Bit");
                Bit=Integer.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine()).intValue();
                if(OS.equalsIgnoreCase("windows"))
                {
                    manipulateProductFileContent.windows(Bit);
                }
                else if(OS.equalsIgnoreCase("linux"))
                {
                    manipulateProductFileContent.linux(Bit);
                }
                else
                {
                    System.out.println("Please the valid OS among windows and linux");
                }
                break;

            case "info":
                SearchPlugins searchPlugins = new SearchPlugins();
                searchPlugins.searchInBundle();
                break;

            default:System.out.println("Please select the valid extension");
        }
    }
}
