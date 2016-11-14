/**
 * Created by root on 11/14/16.
 */

package HandleBuildFailures.tools.Content;

public class Content
{
    public String renameTarget="<target name=\"deploy\"";
    public String overwriteRenameTarget="<target name=\"deploy1\"";
    public String dupTarget="<target name=\"deploy\"> <echo>build eStudio and buildCPSSources carefully</echo>  </target>";
    public String referenceTarget="<target name=\"executeTests\"/>";

    public String wineStudio32="eStudio-win-x86";
    public String wineStudio64="eStudio-win-x86_64";
    public String linuxeStudio32="eStudio-linux-gtk-x86";
    public String linuxeStudio64="eStudio-linux-gtk-x86_64";
    public String jdk32Path="..\\jre1.8.0_92_32\\bin";
    public String jdk64Path="..\\jre1.8.0_92_64\\bin";
}
