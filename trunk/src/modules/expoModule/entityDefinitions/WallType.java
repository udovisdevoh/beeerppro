package modules.expoModule.entityDefinitions;

import newtonERP.orm.field.*;
import newtonERP.orm.field.type.*;import newtonERP.orm.associations.AccessorManager;
import newtonERP.module.AbstractOrmEntity;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Type de muret
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class WallType extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public WallType() throws Exception
    {
        super();
        setVisibleName("Type de muret");
    }

    public Fields initFields() throws Exception
    {
        Vector<Field<?>> fieldList = new Vector<Field<?>>();

        FieldInt pKwallTypeID = new FieldInt("Numéro", getPrimaryKeyName());
        fieldList.add(pKwallTypeID);

        FieldString name = new FieldString("Description", "Name");
        fieldList.add(name);
        return new Fields(fieldList);
    }
}
