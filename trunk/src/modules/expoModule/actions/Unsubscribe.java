package modules.expoModule.actions;

import java.util.Hashtable;

import modules.userRightModule.entityDefinitions.User;
import newtonERP.common.Authentication;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.PluralAccessor;

/**
 * Action représantant le désabonnement d'un membre
 * @author Guillaume Lacasse
 */
public class Unsubscribe extends AbstractAction
{
    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception
    {
	User currentUser = Authentication.getCurrentUser();

	Authentication.setCurrentUserName(null);

	PluralAccessor customerList = currentUser
		.getPluralAccessor("KioskCustomer");

	for (AbstractOrmEntity kioskCustomer : customerList)
	{
	    PluralAccessor zoneList = kioskCustomer.getPluralAccessor("Zone");
	    for (AbstractOrmEntity zone : zoneList)
	    {
		zone.delete();
	    }

	    kioskCustomer.delete();
	}

	currentUser.delete();

	return null;
    }
}
