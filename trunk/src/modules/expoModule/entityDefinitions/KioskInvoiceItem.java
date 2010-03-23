package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;

/**
 * Représente un item de facture
 * @author Guillaume Lacasse
 */
public class KioskInvoiceItem extends AbstractOrmEntity
{

    /**
     * @throws Exception si ça fail
     */
    public KioskInvoiceItem() throws Exception
    {
	super();
	setVisibleName("Élément de facture");
	AccessorManager.addAccessor(this, new KioskInvoice());
	AccessorManager.addAccessor(this, new Option());
    }

    @Override
    public Fields initFields() throws Exception
    {
	Vector<Field<?>> fieldList = new Vector<Field<?>>();

	FieldInt pKkioskInvoiceID = new FieldInt("Numéro", getPrimaryKeyName());
	fieldList.add(pKkioskInvoiceID);

	FieldInt invoice = new FieldInt("Invoice", "kioskInvoiceID");
	fieldList.add(invoice);

	FieldInt option = new FieldInt("Option", "optionID");
	fieldList.add(option);

	FieldInt amount = new FieldInt("Quantité", "amount");
	fieldList.add(amount);

	return new Fields(fieldList);
    }

}