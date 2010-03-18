package newtonERP.viewers.firstStep;

import newtonERP.common.ActionLink;
import newtonERP.module.generalEntity.ImageFile;
import newtonERP.module.generalEntity.SplashScreen;
import newtonERP.viewers.secondStep.ImageFileViewer;
import newtonERP.viewers.secondStep.LinkViewer;

/**
 * Sert à afficher des splash screens
 * @author Guillaume Lacasse
 */
public class SplashScreenViewer
{

    /**
     * @param entity splash screen à voir
     * @return html du splash screen
     * @throws Exception si ça fail
     */
    public static String getHtmlCode(SplashScreen entity) throws Exception
    {
	String htmlCode = "";
	for (ImageFile imageFile : entity.getImageFileList())
	    htmlCode += ImageFileViewer.getHtmlCode(imageFile);

	htmlCode += "<ul>";
	for (ActionLink link : entity.getActionLinkList())
	{
	    htmlCode += "<li>" + LinkViewer.getHtmlCode(link) + "</li>";
	}
	htmlCode += "</ul>";

	return htmlCode;
    }
}