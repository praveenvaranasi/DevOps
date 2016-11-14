package HandleBuildFailures.tools.Content;

/**
 * Created by root on 11/14/16.
 */
public class Content
{
    public String renameTarget="<target name=\"deploy\">";
    public String overwriteRenameTarget="<target name=\"deploy1\">";
    public String dupTarget="<target name=\"deploy\"> <echo>build eStudio and buildCPSSources carefully</echo>  </target>";
    public String referenceTarget="<target name=\"executeTests\"/>";
}
