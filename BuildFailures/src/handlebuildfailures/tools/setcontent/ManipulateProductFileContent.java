package handlebuildfailures.tools.setcontent;

/**
 * Created by praveen on 11/18/16.
 */

import handlebuildfailures.tools.content.Content;

import java.io.*;

public class ManipulateProductFileContent
{
    Content values=new Content();

    public void windows() throws FileNotFoundException, IOException
    {
        String matter;
        FileReader fileReaderProduct=new FileReader(values.directoryPath+"/eStudio.product");
        BufferedReader bufferedReaderProduct=new BufferedReader(fileReaderProduct);
        StringBuffer stringBufferProduct=new StringBuffer();
        while((matter=bufferedReaderProduct.readLine())!=null)
        {
            stringBufferProduct.append(matter);
            stringBufferProduct.append("\n");
        }
        FileWriter fileWriterProduct=new FileWriter(values.directoryPath+"/output.product");
        fileWriterProduct.write(stringBufferProduct.toString());
        fileWriterProduct.close();
        fileReaderProduct.close();
    }

    public void linux()
    {

    }
}
