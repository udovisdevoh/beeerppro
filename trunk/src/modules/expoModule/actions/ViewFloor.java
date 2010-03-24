package modules.expoModule.actions;

import java.util.Hashtable;

import modules.expoModule.entityDefinitions.Floor;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;

/**
 * Sert à voir le plancher
 * @author Guillaume Lacasse
 */
public class ViewFloor extends AbstractAction
{
    /**
     * @throws Exception si ça fail
     */
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
