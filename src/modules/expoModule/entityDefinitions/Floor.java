package modules.expoModule.entityDefinitions;

import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;

import modules.expoModule.actions.ViewFloor;
import newtonERP.common.ActionLink;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.associations.PluralAccessor;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;
import newtonERP.viewers.viewerData.ListViewerData;

/**
 * Plancher
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Floor extends AbstractOrmEntity
{
    private PluralAccessor lazyCorridorList = null;

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

    public boolean isCorridorAt(int x, int y) throws Exception
    {
	for (AbstractOrmEntity entity : getLazyCorridorList())
	{
	    Corridor corridor = (Corridor) entity;

	    boolean isVertical = (Boolean) (corridor.getFields().getField(
		    "IsVertical").getData());
	    int position = (Integer) (corridor.getFields().getField("Position")
		    .getData());

	    if (isVertical && position == x)
		return true;
	    else if (!isVertical && position == y)
		return true;
	}
	return false;
    }

    private PluralAccessor getLazyCorridorList() throws Exception
    {
	if (lazyCorridorList == null)
	{
	    TreeMap<String, PluralAccessor> accessorList = AccessorManager
		    .getPluralAccessorList(this);
	    lazyCorridorList = accessorList.get("Corridor");
	}
	return lazyCorridorList;
    }

    public int getRowCount()
    {
	return (Integer) getData("Height");
    }

    public int getColumnCount()
    {
	return (Integer) getData("Width");
    }

    public String getZoneNameAt(int x, int y) throws Exception
    {
	Zone zone = new Zone();
	zone.setData("PositionX", x);
	zone.setData("PositionY", y);

	Vector<AbstractOrmEntity> zoneList = zone.get();
	if (zoneList.size() < 1)
	    return "-";

	zone = (Zone) zoneList.get(0);

	return zone.getKioskName();
    }

    @Override
    public ListViewerData getList(Hashtable<String, String> parameters)
	    throws Exception
    {
	parameters.put(getPrimaryKeyName(), "&");

	ListViewerData entityList = super.getList(parameters);
	entityList.addSpecificActionButtonList(new ActionLink("Voir plancher",
		new ViewFloor(), parameters));

	return entityList;
    }
}
