package modules.expoModule.entityDefinitions;

import java.util.Vector;

import newtonERP.module.AbstractOrmEntity;
import newtonERP.orm.field.Field;
import newtonERP.orm.field.Fields;
import newtonERP.orm.field.type.FieldInt;
import newtonERP.orm.field.type.FieldString;

/**
 * Domaine
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class CompanyDomain extends AbstractOrmEntity
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public CompanyDomain() throws Exception
    {
	super();
	setVisibleName("Domaine");
    }

    public Fields initFields() throws Exception
    {
	Vector<Field<?>> fieldList = new Vector<Field<?>>();

	FieldInt pKcompanyDomainID = new FieldInt("Numéro", getPrimaryKeyName());
	fieldList.add(pKcompanyDomainID);

	FieldString name = new FieldString("Description", "Name");
	fieldList.add(name);
	return new Fields(fieldList);
    }
}
