/**
 * Created by root on 11/14/16.
 */

package HandleBuildFailures.tools;

import HandleBuildFailures.tools.Content.Content;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;

public class ManipulateContent extends Content
{
    public static void check(String Path) throws IOException
    {
        String OriginalFile="build.xml";
        Content initializeContent = new Content();
        FileReader fileReader=  new FileReader(Path+OriginalFile);
        BufferedReader bufferedReader =  new BufferedReader(fileReader);
        String contentInALine;
        StringBuffer stringBuffer = new StringBuffer();
        while((contentInALine=bufferedReader.readLine())!=null)
        {
            if(contentInALine.contains(initializeContent.renameTarget))
            {
                contentInALine=contentInALine.replace(initializeContent.renameTarget,initializeContent.overwriteRenameTarget);
                stringBuffer.append(contentInALine);
                stringBuffer.append("\n");
            }
            else if(contentInALine.contains(initializeContent.referenceTarget))
            {
                contentInALine=contentInALine.replace(initializeContent.referenceTarget,initializeContent.referenceTarget+initializeContent.dupTarget);
                stringBuffer.append(contentInALine);
                stringBuffer.append("\n");
            }
            else
            {
                stringBuffer.append(contentInALine);
                stringBuffer.append("\n");
            }
        }
        //stringBuffer.append(initializeContent.dupTarget);
        FileWriter fileWriter = new FileWriter("/root/Desktop/original/output.xml");
        fileWriter.write(stringBuffer.toString());
        fileWriter.close();
        fileReader.close();
    }
    /*public void setContent(String Path) throws FileNotFoundException, IOException
    {
        int content;
        String originalFile="build.xml", tempFile="temp.xml", outputFile="output.xml", checkFile="check.xml", tempContent;
        File originalFileName = new File(Path+"original/"+originalFile);
        File outputFileName = new File(Path+outputFile);
        File tempFileName = new File(Path+"original/"+tempFile);
        File checkFileName = new File(Path+"original/"+checkFile);
        System.out.println(Path);
        FileInputStream fileInputStream = new FileInputStream(originalFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        while((content=fileInputStream.read())!=-1)
        {
            tempContent=String.valueOf(content);
            if(tempContent.equals("target"))
            {
                tempContent.replace("target","targets");
            }
            else
            {
                fileOutputStream.write((byte)content);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("Wrote the content to "+outputFile);
        originalFileName.renameTo(tempFileName);
        System.out.println("Renamed "+originalFile+" to "+tempFileName);
        outputFileName.renameTo(checkFileName);

    }*/
}
