package newtonERP.viewers.viewerData;

import newtonERP.module.AbstractEntity;
import newtonERP.viewers.viewables.FloorViewable;

/**
 * Information pour visualiser un plancher
 * @author Guillaume Lacasse
 */
public class FloorViewerData extends AbstractEntity implements FloorViewable
{
    private Boolean[][] corridorMask;

    /**
     * @throws Exception si ça fail
     */
    public FloorViewerData() throws Exception
    {
	super();
	// TODO Auto-generated constructor stub
    }

    @Override
    public int getColumnCount()
    {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public int getRowCount()
    {
	// TODO Auto-generated method stub
	return 0;
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
	// TODO Auto-generated method stub
	return null;
    }
}
