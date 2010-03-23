package modules.expoModule.entityDefinitions;

import java.util.Hashtable;
import java.util.Vector;

import modules.expoModule.actions.ViewFloor;
import newtonERP.common.ActionLink;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;
import newtonERP.viewers.viewables.FloorViewable;
import newtonERP.viewers.viewerData.ListViewerData;

/**
 * Plancher
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Floor extends AbstractOrmEntity implements FloorViewable
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

    @Override
    public int getColumnCount()
    {
	return (Integer) getData("Width");
    }

    @Override
    public ListViewerData getList(Hashtable<String, String> parameters)
	    throws Exception
    {
	ListViewerData listViewerData = super.getList(parameters);

	ViewFloor viewFloor = new ViewFloor();

	ActionLink actionLink = new ActionLink("Voir plancher", viewFloor,
		parameters);

	listViewerData.addSpecificActionButtonList(actionLink);

	return listViewerData;
    }

    @Override
    public int getRowCount()
    {
	return (Integer) getData("Height");
    }

    @Override
    public boolean isCorridorAt(int x, int y)
    {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public String tryGetZoneNameAt(int x, int y) throws Exception
    {
	Zone zone = new Zone();
	zone.setData("PositionX", x);
	zone.setData("PositionY", y);

	Vector<AbstractOrmEntity> zoneList = zone.get();
	if (zoneList.size() < 1)
	    return null;

	zone = (Zone) zoneList.get(0);

	return zone.getKioskName();
    }
}
