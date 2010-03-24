package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;

/**
 * Zone
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Zone extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public Zone() throws Exception
    {
	super();
	setVisibleName("Zone");
	AccessorManager.addAccessor(this, new Floor());
	AccessorManager.addAccessor(this, new KioskCustomer());
    }

    public Fields initFields() throws Exception
    {
	Vector<Field<?>> fieldList = new Vector<Field<?>>();

	FieldInt pKzoneID = new FieldInt("Numéro", getPrimaryKeyName());
	fieldList.add(pKzoneID);

	FieldInt positionX = new FieldInt("Position X", "PositionX");
	positionX.setNaturalKey(true);
	fieldList.add(positionX);

	FieldInt positionY = new FieldInt("Position Y", "PositionY");
	positionY.setNaturalKey(true);
	fieldList.add(positionY);

	FieldInt plugCount = new FieldInt("Nombre de prises électriques",
		"PlugCount");
	fieldList.add(plugCount);

	FieldInt client = new FieldInt("Client", "kioskCustomerID");
	client.setNaturalKey(true);
	fieldList.add(client);

	FieldInt floorID = new FieldInt("Plancher", "floorID");
	fieldList.add(floorID);
	return new Fields(fieldList);
    }

    /**
     * @return retourne le nom de kiosque associé à cette zone
     * @throws Exception si ça fail
     */
    public String getKioskName() throws Exception
    {
	KioskCustomer kioskCustomer = (KioskCustomer) AccessorManager
		.getSingleAccessor(this, "kioskCustomerID");

	return kioskCustomer.getNaturalKeyDescription();
    }
}
