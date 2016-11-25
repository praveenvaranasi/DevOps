package handlebuildfailures.tools.plugins;

import handlebuildfailures.tools.content.Content;

import java.io.*;

/**
 * Created by root on 11/24/16.
 */
public class CopyPlugins extends Content
{
    public void copyJars(String plugin) throws FileNotFoundException, IOException
    {
        FileInputStream fileInputStream=new FileInputStream(directoryPath+plugin);
        FileOutputStream fileOutputStream=new FileOutputStream(bundles32+plugin);
        int i;
        while((i=fileInputStream.read())!=-1)
        {
            fileOutputStream.write(i);
        }
    }
}
