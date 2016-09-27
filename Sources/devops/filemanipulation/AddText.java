package devops.filemanipulation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by Praveen on 9/27/2016.
 */
public class AddText
{
    public void addContentToFile(String content) throws IOException
    {
        //Created a file User.home on Desktop
        String fileName="devops.txt";
        String filePath = System.getProperty("user.home")+(File.separator)+"Desktop"+(File.separator)+fileName;
        File file = new File(filePath);
        System.out.println("Created the file "+"devops.txt"+" at "+filePath);
        //Writes the content into the file
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(content);
        fileWriter.close();
        System.out.println("written the content"+"[ "+content+" ]"+"into the file"+fileName);
    }
}
