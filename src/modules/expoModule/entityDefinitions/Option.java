package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;

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
