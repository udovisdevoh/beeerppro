package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;

/**
 * Facture
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class KioskInvoice extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public KioskInvoice() throws Exception
    {
	super();
	setVisibleName("Facture");
	AccessorManager.addAccessor(this, new KioskCustomer());
    }

    public Fields initFields() throws Exception
    {
	Vector<Field<?>> fieldList = new Vector<Field<?>>();

	FieldInt pKkioskInvoiceID = new FieldInt("Numéro", getPrimaryKeyName());
	fieldList.add(pKkioskInvoiceID);

	FieldInt client = new FieldInt("Client", "kioskCustomerID");
	fieldList.add(client);

	return new Fields(fieldList);
    }
}
