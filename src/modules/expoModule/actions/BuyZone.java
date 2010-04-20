package modules.expoModule.actions;

import java.util.Hashtable;

import modules.expoModule.entityDefinitions.Zone;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;

/**
 * Action d'acheter une zone par un clic
 * @author Guillaume Lacasse
 */
public class BuyZone extends AbstractAction
{
    /**
     * @throws Exception is ça fail
     */
    public BuyZone() throws Exception
    {
	super(new Zone());
	setDetailedDescription("Achetter une");
    }

    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }

}
