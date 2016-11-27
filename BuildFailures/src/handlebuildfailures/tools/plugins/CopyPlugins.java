package handlebuildfailures.tools.plugins;

import handlebuildfailures.tools.content.Content;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
    public void copyPluginDirectory(File sourceDirectory, File destinationDirectory) throws IOException
    {
        if(sourceDirectory.isDirectory())
        {
            if (!destinationDirectory.exists())
            {
                destinationDirectory.mkdir();
                System.out.println("Created direcotry :"+destinationDirectory);
            }
            String files[]=sourceDirectory.list();
            for (String file : files)
            {
                System.out.println(file);
                File srcfile = new File(sourceDirectory, file);
                File destfile = new File(destinationDirectory, file);
                copyPluginDirectory(srcfile,destfile);
            }
        }
        else
        {
            Files.copy(sourceDirectory.toPath(), destinationDirectory.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied :: " + destinationDirectory);
        }


    }
}
