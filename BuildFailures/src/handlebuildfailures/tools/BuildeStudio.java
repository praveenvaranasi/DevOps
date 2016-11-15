/**
 * Created by root on 11/14/16.
 */

package handlebuildfailures.tools;

import handlebuildfailures.tools.setcontent.ManipulateBuildFileContent;

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
                System.out.println("Enter the DirectoryPath");
                directoryPath=new BufferedReader(new InputStreamReader(System.in)).readLine();
                /*ManipulateBuildFileContent manipulateBuildFileContentProduct =new ManipulateBuildFileContent();
                manipulateBuildFileContentProduct.modifyProductFile(directoryPath);*/
                break;
            default:System.out.println("Please select the valid extension");
        }
    }
}
