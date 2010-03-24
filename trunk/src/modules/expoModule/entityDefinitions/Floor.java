package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;

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

	FieldInt width = new FieldInt("Largeur", "Width");
	fieldList.add(width);

	FieldInt height = new FieldInt("Hauteur", "Height");
	fieldList.add(height);

	return new Fields(fieldList);
    }
}
