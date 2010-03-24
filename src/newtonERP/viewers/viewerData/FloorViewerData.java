package newtonERP.viewers.viewerData;

import modules.expoModule.entityDefinitions.Floor;
import newtonERP.module.AbstractEntity;
import newtonERP.viewers.viewables.FloorViewable;

/**
 * Information pour visualiser un plancher
 * @author Guillaume Lacasse
 */
public class FloorViewerData extends AbstractEntity implements FloorViewable
{
    private int columnCount = 0;

    private int rowCount = 0;

    private Boolean[][] corridorMask;

    private String[][] zoneNameMap;

    /**
     * @throws Exception si ça fail
     */
    public FloorViewerData() throws Exception
    {
	super();
    }

    /**
     * @param sourceFloor source floor
     * @throws Exception si ça fail
     */
    public FloorViewerData(Floor sourceFloor) throws Exception
    {
	super();

	sourceFloor = (Floor) sourceFloor.get().get(0);

	columnCount = sourceFloor.getColumnCount();
	rowCount = sourceFloor.getRowCount();
	corridorMask = new Boolean[columnCount][rowCount];
	zoneNameMap = new String[columnCount][rowCount];

	for (int x = 0; x < columnCount; x++)
	{
	    for (int y = 0; y < rowCount; y++)
	    {
		zoneNameMap[x][y] = sourceFloor.getZoneNameAt(x, y);
		corridorMask[x][y] = sourceFloor.isCorridorAt(x, y);
	    }
	}
    }

    @Override
    public int getColumnCount()
    {
	return columnCount;
    }

    @Override
    public int getRowCount()
    {
	return rowCount;
    }

    @Override
    public boolean isCorridorAt(int x, int y)
    {
	if (corridorMask == null)
	    return false;

	return corridorMask[x][y];
    }

    @Override
    public String tryGetZoneNameAt(int x, int y) throws Exception
    {
	if (zoneNameMap == null)
	    return "-";
	return zoneNameMap[x][y];
    }
}
