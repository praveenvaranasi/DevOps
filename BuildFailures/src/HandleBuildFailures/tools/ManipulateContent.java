package HandleBuildFailures.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
/**
 * Created by root on 11/14/16.
 */
public class ManipulateContent
{
    public void setContent(String Path) throws FileNotFoundException, IOException
    {
        int content;
        String originalFile="build.xml", tempFile="temp.xml", outputFile="output.xml", checkFile="check.xml";
        File originalFileName = new File(Path+"original/"+originalFile);
        File outputFileName = new File(Path+outputFile);
        File tempFileName = new File(Path+"original/"+tempFile);
        File checkFileName = new File(Path+"original/"+checkFile);
        System.out.println(Path);
        FileInputStream fileInputStream = new FileInputStream(originalFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
        while((content=fileInputStream.read())!=-1)
        {
            fileOutputStream.write((byte)content);
        }
        fileInputStream.close();
        fileOutputStream.close();
        System.out.println("Wrote the content to "+outputFile);
        originalFileName.renameTo(tempFileName);
        System.out.println("Renamed "+originalFile+" to "+tempFileName);
        outputFileName.renameTo(checkFileName);

    }
}
