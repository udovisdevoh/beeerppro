package modules.expoModule.entityDefinitions;

import newtonERP.orm.field.*;
import newtonERP.orm.field.type.*;import newtonERP.orm.associations.AccessorManager;
import newtonERP.module.AbstractOrmEntity;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Connexion internet
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class InternetConnectionType extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public InternetConnectionType() throws Exception
    {
        super();
        setVisibleName("Connexion internet");
    }

    public Fields initFields() throws Exception
    {
        Vector<Field<?>> fieldList = new Vector<Field<?>>();

        FieldInt pKinternetConnectionTypeID = new FieldInt("Numéro", getPrimaryKeyName());
        fieldList.add(pKinternetConnectionTypeID);

        FieldString name = new FieldString("Description", "Name");
        fieldList.add(name);
        return new Fields(fieldList);
    }
}
