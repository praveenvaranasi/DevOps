/**
 * Created by root on 11/14/16.
 */

package HandleBuildFailures.tools;

import HandleBuildFailures.tools.Content.Content;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;

public class ManipulateContent extends Content
{
    public static void check(String directoryPath) throws IOException
    {
        String originalFile="build.xml", modifiedFile="output.xml", tempFile="temp.xml";
        File originalFileName=new File(directoryPath+originalFile);
        File modifiedFileName=new File(directoryPath+modifiedFile);
        File tempFileName=new File(directoryPath+tempFile);
        Content variableValues = new Content();
        FileReader fileReader=  new FileReader(originalFileName);
        BufferedReader bufferedReader =  new BufferedReader(fileReader);
        String contentInALine;
        StringBuffer stringBuffer = new StringBuffer();
        while((contentInALine=bufferedReader.readLine())!=null)
        {
            if(contentInALine.contains(variableValues.renameTarget))
            {
                contentInALine=contentInALine.replace(variableValues.renameTarget,variableValues.overwriteRenameTarget);
                stringBuffer.append(contentInALine);
                stringBuffer.append("\n");
            }
            else if(contentInALine.contains(variableValues.referenceTarget))
            {
                contentInALine=contentInALine.replace(variableValues.referenceTarget,variableValues.referenceTarget+variableValues.dupTarget);
                stringBuffer.append(contentInALine);
                stringBuffer.append("\n");
            }
            else
            {
                stringBuffer.append(contentInALine);
                stringBuffer.append("\n");
            }
        }
        FileWriter fileWriter = new FileWriter(modifiedFileName);
        fileWriter.write(stringBuffer.toString());
        fileWriter.close();
        fileReader.close();
        modifiedFileName.renameTo(tempFileName);
        originalFileName.renameTo(modifiedFileName);
        tempFileName.renameTo(originalFileName);
    }
}
