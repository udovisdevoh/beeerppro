package modules.expoModule.entityDefinitions;

import java.util.Vector;

import modules.userRightModule.entityDefinitions.User;
import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.associations.AccessorManager;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldDateTime;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;

/**
 * Client de kiosque
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class KioskCustomer extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public KioskCustomer() throws Exception
    {
	super();
	setVisibleName("Kiosque");
	AccessorManager.addAccessor(this, new CompanyDomain());
	AccessorManager.addAccessor(this, new User());
	AccessorManager.addAccessor(this, new InternetConnectionType());
    }

    public Fields initFields() throws Exception
    {
	Vector<Field<?>> fieldList = new Vector<Field<?>>();

	FieldInt pKkioskCustomerID = new FieldInt("Numéro", getPrimaryKeyName());
	fieldList.add(pKkioskCustomerID);

	FieldString company = new FieldString("Compagnie", "Company");
	company.setNaturalKey(true);
	fieldList.add(company);

	FieldInt domain = new FieldInt("Domaine", "companyDomainID");
	fieldList.add(domain);

	FieldString lastName = new FieldString("Nom du responsable", "LastName");
	fieldList.add(lastName);

	FieldString firstName = new FieldString("Prénom du responsable",
		"FirstName");
	fieldList.add(firstName);

	FieldString email = new FieldString("Courriel", "Email");
	fieldList.add(email);

	FieldInt user = new FieldInt("Utilisateur", "userID");
	user.setReadOnly(true);
	fieldList.add(user);

	FieldInt internetConnectionType = new FieldInt("Connexion internet",
		new InternetConnectionType().getForeignKeyName());
	fieldList.add(internetConnectionType);

	FieldDateTime date = new FieldDateTime("Date d`inscription", "Date");
	date.setReadOnly(true);
	fieldList.add(date);
	return new Fields(fieldList);
    }
}
