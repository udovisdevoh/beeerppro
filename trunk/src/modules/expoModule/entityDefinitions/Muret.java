package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;

/**
 * Représente un muret
 * @author Guillaume Lacasse
 */
public class Muret extends AbstractOrmEntity
{
    /**
     * @throws Exception si ça fail
     */
    public Muret() throws Exception
    {
	super();
	setVisibleName("Muret");
	AccessorManager.addAccessor(this, new KioskCustomer());
	AccessorManager.addAccessor(this, new Zone());
	AccessorManager.addAccessor(this, new WallType());
    }

    @Override
    public Fields initFields() throws Exception
    {

	Vector<Field<?>> fieldList = new Vector<Field<?>>();

	FieldInt pKwallTypeID = new FieldInt("Numéro", getPrimaryKeyName());
	fieldList.add(pKwallTypeID);

	FieldInt client = new FieldInt("Client", new KioskCustomer()
		.getForeignKeyName());
	fieldList.add(client);

	FieldInt positionX = new FieldInt("Position sur zone", new WallType()
		.getForeignKeyName());
	fieldList.add(positionX);

	FieldInt zone = new FieldInt("Zone", new Zone().getForeignKeyName());
	fieldList.add(zone);

	return new Fields(fieldList);
    }
}
