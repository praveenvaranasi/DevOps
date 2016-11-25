package handlebuildfailures.tools.plugins;

import handlebuildfailures.tools.content.Content;
import handlebuildfailures.tools.plugins.CopyPlugins;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;

/*
 * Created by root on 11/23/16.
 */

public class SearchPlugins extends Content
{
    CopyPlugins copyPlugins = new CopyPlugins();
    public void searchInBundle() throws FileNotFoundException, IOException
    {
        String bundleContent;
        StringBuffer stringBufferOccurencesInBundle=new StringBuffer();
        FileReader fileReaderBundle= new FileReader(bundles64+bundle);
        BufferedReader bufferedReaderBundle=new BufferedReader(fileReaderBundle);
        while((bundleContent=bufferedReaderBundle.readLine())!=null)
        {
            if(bundleContent.contains(bundleReference))
            {
                System.out.println(bundleContent);
                stringBufferOccurencesInBundle.append(bundleContent);
                stringBufferOccurencesInBundle.append("\n");
                String plugins[]=bundleContent.split("/");
                String finall[]=plugins[1].split(",");
                System.out.println(finall[0]);
                String plugin=finall[0];
                //copyPlugins.copyJars(plugin);
                File pluginFile=new File(directoryPath+plugin);
                if(!pluginFile.exists())
                {
                    System.out.println("I'm not file");
                }
            }
        }
        fileReaderBundle.close();
        appendToBundle(stringBufferOccurencesInBundle);
    }
    public void appendToBundle(StringBuffer stringBufferOccurences) throws FileNotFoundException, IOException
    {
        File originalBundleFile=new File(bundles32+bundle);
        File modifiedBundleFile=new File(bundles32+modifiedBundle);
        File tempBundleFile=new File(bundles32+tempBundle);

        String append=stringBufferOccurences.toString(), targetContent;
        StringBuffer stringBufferAppend=new StringBuffer();
        FileReader fileReaderAppend=new FileReader(originalBundleFile);
        BufferedReader bufferedReaderAppend=new BufferedReader(fileReaderAppend);
        while((targetContent=bufferedReaderAppend.readLine())!=null)
        {
            stringBufferAppend.append(targetContent);
            stringBufferAppend.append("\n");
        }
        FileWriter fileWriterAppend=new FileWriter(modifiedBundleFile);
        fileWriterAppend.write(stringBufferAppend.toString());
        fileWriterAppend.write(append);
        fileWriterAppend.close();
        fileReaderAppend.close();
        modifiedBundleFile.renameTo(tempBundleFile);
        originalBundleFile.renameTo(modifiedBundleFile);
        tempBundleFile.renameTo(originalBundleFile);
        modifiedBundleFile.delete();
    }

}
