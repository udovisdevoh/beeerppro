package modules.expoModule.actions;

import java.util.Hashtable;

import modules.userRightModule.UserRightModule;
import modules.userRightModule.entityDefinitions.Groups;
import modules.userRightModule.entityDefinitions.User;
import newtonERP.common.ActionLink;
import newtonERP.common.Authentication;
import newtonERP.module.AbstractAction;
import newtonERP.module.AbstractEntity;
import newtonERP.module.generalEntity.Form;
import newtonERP.module.generalEntity.StaticTextEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.type.FieldString;

/**
 * Subscribe
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class Subscribe extends AbstractAction
{
    @Override
    public AbstractEntity doAction(AbstractEntity entity,
	    Hashtable<String, String> parameters) throws Exception
    {
	String currentLoginName = parameters.get("name");
	String currentPassword = parameters.get("password");

	if (currentLoginName == null)
	    currentLoginName = "";

	if (currentPassword == null)
	    currentPassword = "";

	Form subscribeForm = new Form(new UserRightModule(), new Subscribe());

	subscribeForm.addField("Choisir un nom d'utilisateur", "name",
		currentLoginName);

	Field<?> passwordField = new FieldString("Choisir un mot de passe",
		"password");
	passwordField.setHidden(true);

	subscribeForm.addField(passwordField);
	subscribeForm.setTitle("Création d'un compte");
	subscribeForm.setButtonAction(new ActionLink("Créer", this));

	if (parameters.containsKey("submit"))
	{
	    User user = new User();
	    user.setData("name", currentLoginName);

	    if (user.get().size() == 0)
	    {
		Groups groups = new Groups();
		groups.setData("groupName", "expoGroup");
		groups = (Groups) groups.get().get(0);

		user.setData("groupsID", groups.getPrimaryKeyValue());
		user.setData("password", currentPassword);
		user.newE();

		Authentication.setCurrentUserName(currentLoginName);
		return new StaticTextEntity("Votre compte a été créé.");
	    }

	    subscribeForm.addAlertMessage("Ce compte existe déjà");
	}

	return subscribeForm;
    }
}
