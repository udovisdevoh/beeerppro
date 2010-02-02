package modules.expoModule.entityDefinitions;

import newtonERP.orm.field.*;
import newtonERP.orm.field.type.*;import newtonERP.orm.associations.AccessorManager;
import newtonERP.module.AbstractOrmEntity;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Option
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Option extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public Option() throws Exception
    {
        super();
        setVisibleName("Option");
        AccessorManager.addAccessor(this, new KioskInvoice());
    }

    public Fields initFields() throws Exception
    {
        Vector<Field<?>> fieldList = new Vector<Field<?>>();

        FieldInt pKoptionID = new FieldInt("Numéro", getPrimaryKeyName());
        fieldList.add(pKoptionID);

        FieldInt kioskInvoiceID = new FieldInt("Facture", "kioskInvoiceID");
        fieldList.add(kioskInvoiceID);
        return new Fields(fieldList);
    }
}
