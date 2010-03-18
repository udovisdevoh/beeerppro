package modules.expoModule.actions;

import java.util.Hashtable;

import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.module.generalEntity.StaticTextEntity;

/**
 * Subscribe
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Subscribe extends AbstractAction
{
    @Override
    public AbstractEntity doAction(AbstractEntity sourceEntity,
	    Hashtable<String, String> parameters) throws Exception
    {
	return new StaticTextEntity("Please implement action");
    }
}
