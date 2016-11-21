/**
 * Created by praveen on 11/14/16.
 */

package handlebuildfailures.tools.content;

public class Content
{
    //file-names to modify build.xml in tools/builder in Sources
    public String originalFile="build.xml";
    public String modifiedFile="output.xml";
    public String tempFile="temp.xml";

    //file-names to modify eStudio.product in tools/rcp in sources
    public String orginalProductFile="eStudio.product";
    public String modifiedProductFile="output.product";
    public String tempProductFile="temp.product";


    public String renameTarget="<target name=\"deploy\"";
    public String overwriteRenameTarget="<target name=\"deploy1\"";
    public String dupTarget="<target name=\"deploy\"> <echo>build eStudio and buildCPSSources carefully</echo>  </target>";
    public String referenceTarget="<target name=\"executeTests\"/>";
    public String directoryPath="/root/Desktop/original/";
    //public String originalTargets="description=\"eStudio Product\" depends=\"update_properties,prebuild_jar_update,pdebuild,extract_eStudiorcps,buildCPSSources,eStudio64bitpatch\"/>";
    public String toolsBuildTargets="<target name=\"deploy\" depends=\"update_properties,prebuild_jar_update,pdebuild\"/>";

    public String wineStudio32="<launcher name=\"eStudio-win-x86\">";
    public String wineStudio64="<launcher name=\"eStudio-win-x86_64\">";
    public String linuxeStudio32="<launcher name=\"eStudio-linux-gtk-x86\">";
    public String linuxeStudio64="<launcher name=\"eStudio-linux-gtk-x86_64\">";
    public String jdk32Path="..\\jre1.8.0_92_32\\bin";
    public String jdk64Path="..\\jre1.8.0_92_64\\bin";
    public String launcherString="<launcher name=\"";
    public String JreString="..\\jre";
}
