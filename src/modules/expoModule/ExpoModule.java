package modules.expoModule;

import modules.userRightModule.entityDefinitions.Groups;
import newtonERP.module.Module;

/**
 * Module d`exposition
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class ExpoModule extends Module
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public ExpoModule() throws Exception
    {
	super();
	setVisibleName("Module d`exposition");
    }

    public void initDB() throws Exception
    {
	super.initDB();

	Groups groups;

	groups = new Groups();
	groups.setData("groupName", "expoGroup");
	groups.newE();
    }
}
