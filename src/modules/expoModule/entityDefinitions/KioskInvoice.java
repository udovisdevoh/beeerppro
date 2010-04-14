package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.FieldCalcule;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldBool;
import newtonERP.orm.field.type.FieldCurrency;
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
	pKkioskInvoiceID.setNaturalKey(true);
	fieldList.add(pKkioskInvoiceID);

	FieldInt client = new FieldInt("Client", "kioskCustomerID");
	client.setNaturalKey(true);
	fieldList.add(client);

	FieldBool isPaid = new FieldBool("Payée?", "isPaid");
	fieldList.add(isPaid);

	FieldCurrency total = new FieldCurrency("Total", "total");
	total.setCalcul(new FieldCalculeTotal());
	fieldList.add(total);

	return new Fields(fieldList);
    }

    private class FieldCalculeTotal extends FieldCalcule<Double>
    {
	@Override
	protected Double calcul(Fields entityFields) throws Exception
	{
	    double total = 0;

	    KioskInvoiceItem kioskInvoiceItem = new KioskInvoiceItem();
	    kioskInvoiceItem.setData("kioskInvoiceID", entityFields.getField(
		    "PKkioskInvoiceID").getDataString());
	    Vector<AbstractOrmEntity> kioskInvoiceItemList = kioskInvoiceItem
		    .get();

	    for (AbstractOrmEntity invoiceItem : kioskInvoiceItemList)
		total += ((KioskInvoiceItem) invoiceItem).getTotal();

	    return total;
	}
    }
}
