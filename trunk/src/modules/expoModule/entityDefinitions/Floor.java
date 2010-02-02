package modules.expoModule.entityDefinitions;

import newtonERP.orm.field.*;
import newtonERP.orm.field.type.*;import newtonERP.orm.associations.AccessorManager;
import newtonERP.module.AbstractOrmEntity;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Plancher
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Floor extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public Floor() throws Exception
    {
        super();
        setVisibleName("Plancher");
    }

    public Fields initFields() throws Exception
    {
        Vector<Field<?>> fieldList = new Vector<Field<?>>();

        FieldInt pKfloorID = new FieldInt("Numéro", getPrimaryKeyName());
        fieldList.add(pKfloorID);

        FieldString nom = new FieldString("Description", "Nom");
        fieldList.add(nom);
        return new Fields(fieldList);
    }
}
