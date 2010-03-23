package modules.expoModule.actions;

import java.util.Hashtable;

import modules.expoModule.entityDefinitions.Floor;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;

public class ViewFloor extends AbstractAction
{
    public ViewFloor() throws Exception
    {
	super(new Floor());
    }

    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception
    {
	return entity;
    }

}
