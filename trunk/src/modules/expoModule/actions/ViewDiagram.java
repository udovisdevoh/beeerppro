package modules.expoModule.actions;

import java.util.Hashtable;

import modules.expoModule.entityDefinitions.KioskCustomer;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;

/**
 * 
 * @author Guillaume Lacasse
 */
public class ViewDiagram extends AbstractAction
{
    /**
     * @throws Exception si ça fail
     */
    public ViewDiagram() throws Exception
    {
	super(new KioskCustomer());
	setDetailedDescription("Voir les graphiques à barre additives d'un");
    }

    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception
    {
	// TODO Auto-generated method stub
	return null;
    }
}
