/**
 * Created by praveen on 11/14/16.
 */

package handlebuildfailures.tools.setcontent;

import handlebuildfailures.tools.content.Content;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

public class ManipulateBuildFileContent extends Content
{
    File originalFileName=new File(directoryPath+originalFile);
    File modifiedFileName=new File(directoryPath+modifiedFile);
    File tempFileName=new File(directoryPath+tempFile);
    String contentInALine;


    public void stopToolsBuild() throws IOException
    {
        FileReader fileReaderStop=  new FileReader(originalFileName);
        BufferedReader bufferedReaderStop =  new BufferedReader(fileReaderStop);
        StringBuffer stringBufferStop = new StringBuffer();
        while((contentInALine=bufferedReaderStop.readLine())!=null)
        {
            if(contentInALine.contains(renameTarget))
            {
                contentInALine=contentInALine.replace(renameTarget,overwriteRenameTarget);
                stringBufferStop.append(contentInALine);
                stringBufferStop.append("\n");
            }
            else if(contentInALine.contains(referenceTarget))
            {
                contentInALine=contentInALine.replace(referenceTarget,referenceTarget+dupTarget);
                stringBufferStop.append(contentInALine);
                stringBufferStop.append("\n");
            }
            else
            {
                stringBufferStop.append(contentInALine);
                stringBufferStop.append("\n");
            }
        }
        FileWriter fileWriterStop = new FileWriter(modifiedFileName);
        fileWriterStop.write(stringBufferStop.toString());
        fileWriterStop.close();
        fileReaderStop.close();
        modifiedFileName.renameTo(tempFileName);
        originalFileName.renameTo(modifiedFileName);
        tempFileName.renameTo(originalFileName);
        modifiedFileName.delete();
    }
    public void startToolsBuild() throws IOException
    {
        FileReader fileReaderStart=new FileReader(originalFileName);
        BufferedReader bufferedReaderStart=new BufferedReader(fileReaderStart);
        StringBuffer stringBufferStart=new StringBuffer();
        while((contentInALine=bufferedReaderStart.readLine())!=null)
        {
            if(contentInALine.contains(dupTarget))
            {
                contentInALine=contentInALine.replace(contentInALine,toolsBuildTargets);
                stringBufferStart.append(contentInALine);
                stringBufferStart.append("\n");
            }
            else
            {
                stringBufferStart.append(contentInALine);
                stringBufferStart.append("\n");
            }
        }
        FileWriter fileWriterStart=new FileWriter(modifiedFileName);
        fileWriterStart.write(stringBufferStart.toString());
        fileWriterStart.close();
        fileReaderStart.close();
        modifiedFileName.renameTo(tempFileName);
        originalFileName.renameTo(modifiedFileName);
        tempFileName.renameTo(originalFileName);
        modifiedFileName.delete();
    }
    /*public void modifyProductFile(String directoryPath) throws FileNotFoundException, IOException
    {
        String originalProductFile="eStudio.product", modifiedProductFile="output.product", tempProductFile="temp.product", contentInALine;
        File originalProductFileName=new File(directoryPath+originalProductFile);
        File modifiedProductFileName=new File(directoryPath+modifiedProductFile);
        File tempProductFileName=new File(directoryPath+tempProductFile);
        FileReader fileReaderProduct=new FileReader(originalProductFileName);
        BufferedReader bufferedReaderProduct=new BufferedReader(fileReaderProduct);
        StringBuffer stringBufferProduct=new StringBuffer();
        while((contentInALine=bufferedReaderProduct.readLine())!=null)
        {
            stringBufferProduct.append(contentInALine);
            stringBufferProduct.append("\n");
        }
        FileWriter fileWriterProduct=new FileWriter(modifiedProductFileName);
        fileWriterProduct.write(stringBufferProduct.toString());
        fileWriterProduct.close();
        fileReaderProduct.close();
    }*/
}
