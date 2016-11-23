package handlebuildfailures.tools.plugins;

import handlebuildfailures.tools.content.Content;

import java.io.*;

/*
 * Created by root on 11/23/16.
 */

public class SearchPlugins extends Content
{
    public void searchInBundle() throws FileNotFoundException, IOException
    {
        String bundleContent;
        StringBuffer stringBufferOccurences=new StringBuffer();
        FileReader fileReaderBundle= new FileReader(bundles64+bundle);
        BufferedReader bufferedReaderBundle=new BufferedReader(fileReaderBundle);
        while((bundleContent=bufferedReaderBundle.readLine())!=null)
        {
            if(bundleContent.contains(bundleReference))
            {
                System.out.println(bundleContent);
                stringBufferOccurences.append(bundleContent);
                stringBufferOccurences.append("\n");
            }
        }
        fileReaderBundle.close();
        appendToBundle(stringBufferOccurences);
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
