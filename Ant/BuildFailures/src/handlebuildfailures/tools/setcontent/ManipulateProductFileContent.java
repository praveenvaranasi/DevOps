package handlebuildfailures.tools.setcontent;

/**
 * Created by praveen on 11/18/16.
 */

import handlebuildfailures.tools.content.Content;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class ManipulateProductFileContent extends Content
{
    public ManipulateProductFileContent() throws FileNotFoundException
    {
    }

    File originalProductFileName=new File(directoryPath+orginalProductFile);
    File modifiedProductFileName=new File(directoryPath+modifiedProductFile);
    File tempProductFileName=new File(directoryPath+tempProductFile);

    String productFileContent;
    FileReader fileReaderProduct=new FileReader(originalProductFileName);
    BufferedReader bufferedReaderProduct=new BufferedReader(fileReaderProduct);
    StringBuffer stringBufferProduct=new StringBuffer();

    public void windows(int Bit) throws IOException
    {
        if(Bit==32)
        {
            while((productFileContent=bufferedReaderProduct.readLine())!=null)
            {
                if(productFileContent.contains(JreString))
                {
                    productFileContent=productFileContent.replace(productFileContent,jdk32Path);
                    stringBufferProduct.append(productFileContent);
                    stringBufferProduct.append("\n");
                }
                else if(productFileContent.contains(launcherString))
                {
                    productFileContent=productFileContent.replace(productFileContent,wineStudio32);
                    stringBufferProduct.append(productFileContent);
                    stringBufferProduct.append("\n");
                }
                else
                {
                    stringBufferProduct.append(productFileContent);
                    stringBufferProduct.append("\n");
                }
            }
        }
        else if(Bit==64)
        {
            while((productFileContent=bufferedReaderProduct.readLine())!=null)
            {
                if (productFileContent.contains(JreString))
                {
                    productFileContent=productFileContent.replace(productFileContent,jdk64Path);
                    stringBufferProduct.append(productFileContent);
                    stringBufferProduct.append("\n");
                }
                else if (productFileContent.contains(launcherString))
                {
                    productFileContent=productFileContent.replace(productFileContent,wineStudio64);
                    stringBufferProduct.append(productFileContent);
                    stringBufferProduct.append("\n");
                }
                else
                {
                    stringBufferProduct.append(productFileContent);
                    stringBufferProduct.append("\n");
                }
            }
        }
        else
        {
            System.out.println("Please provide valid OS bit architechture");
        }
        FileWriter fileWriterProduct=new FileWriter(modifiedProductFileName);
        fileWriterProduct.write(stringBufferProduct.toString());
        fileWriterProduct.close();
        fileReaderProduct.close();
        modifiedProductFileName.renameTo(tempProductFileName);
        originalProductFileName.renameTo(modifiedProductFileName);
        tempProductFileName.renameTo(originalProductFileName);
        modifiedProductFileName.delete();
    }

    public void linux(int Bit) throws IOException
    {
        while((productFileContent=bufferedReaderProduct.readLine())!=null)
        {
            if (Bit==32 && productFileContent.contains(launcherString))
            {
                productFileContent=productFileContent.replace(productFileContent,linuxeStudio32);
                stringBufferProduct.append(productFileContent);
                stringBufferProduct.append("\n");
            }
            else if (Bit==64 && productFileContent.contains(launcherString))
            {
                productFileContent=productFileContent.replace(productFileContent,linuxeStudio64);
                stringBufferProduct.append(productFileContent);
                stringBufferProduct.append("\n");
            }
            else
            {
                stringBufferProduct.append(productFileContent);
                stringBufferProduct.append("\n");
            }
        }
        FileWriter fileWriterProduct=new FileWriter(modifiedProductFileName);
        fileWriterProduct.write(stringBufferProduct.toString());
        fileWriterProduct.close();
        fileReaderProduct.close();
        modifiedProductFileName.renameTo(tempProductFileName);
        originalProductFileName.renameTo(modifiedProductFileName);
        tempProductFileName.renameTo(originalProductFileName);
        modifiedProductFileName.delete();
    }
}
