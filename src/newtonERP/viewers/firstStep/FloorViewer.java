package newtonERP.viewers.firstStep;

import newtonERP.viewers.secondStep.colorViewer.ColorViewer;
import newtonERP.viewers.viewables.FloorViewable;

/**
 * Représente un viewer de plancher
 * @author Guillaume Lacasse
 */
public class FloorViewer
{

    /**
     * @param entity entité de plancher
     * @return code HTML
     * @throws Exception si ça fail
     */
    public static String getHtmlCode(FloorViewable entity) throws Exception
    {
	String html = "";

	html += "<table>";

	int columnCount = entity.getColumnCount();
	for (int y = 0; y < entity.getRowCount(); y++)
	{
	    html += "<tr>";
	    for (int x = 0; x < columnCount; x++)
	    {
		String currentText = "";
		String currentColor = "#FFF";

		if (entity.isCorridorAt(x, y))
		{
		    currentColor = "#000";
		}
		else
		{
		    String zoneName = entity.tryGetZoneNameAt(x, y);

		    if (zoneName != null)
		    {
			currentText = zoneName;
			currentColor = ColorViewer.getColor(currentText);
		    }
		}

		html += "<td style=\"background-color:" + currentColor
			+ ";width:32px;height:32px\">";
		html += currentText;
		html += "</td>";
	    }
	    html += "</tr>";
	}
	html += "</table>";

	return html;
    }
}
