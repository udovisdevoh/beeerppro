package modules.expoModule;

import modules.expoModule.entityDefinitions.CompanyDomain;
import modules.expoModule.entityDefinitions.Option;
import modules.userRightModule.entityDefinitions.Groups;
import newtonERP.module.Module;

/**
 * Module d`exposition
 * @author NewtonERP code generator - Guillaume Lacasse
 */
public class ExpoModule extends Module
{
    /**
     * constructor
     * @throws Exception remonte
     */
    public ExpoModule() throws Exception
    {
	super();
	setVisibleName("Module d`exposition");
    }

    public void initDB() throws Exception
    {
	super.initDB();

	Groups groups;

	groups = new Groups();
	groups.setData("groupName", "expoGroup");
	groups.newE();

	initCompanyDomains();
	initOptions();
    }

    private void initOptions() throws Exception
    {
	Option option;

	option = new Option();
	option.setData("name", "Inscription");
	option.setData("price", 5000);
	option.newE();

	option = new Option();
	option.setData("name", "Zone");
	option.setData("price", 1000);
	option.newE();

	option = new Option();
	option.setData("name", "Kiosque supplémentaire");
	option.setData("price", 1500);
	option.newE();

	option = new Option();
	option.setData("name", "Prise électrique");
	option.setData("price", 50);
	option.newE();

	option = new Option();
	option.setData("name", "Muret 1.5m");
	option.setData("price", 100);
	option.newE();

	option = new Option();
	option.setData("name", "Internet");
	option.setData("price", 20);
	option.newE();

	option = new Option();
	option.setData("name", "Internet 500KB");
	option.setData("price", 20);
	option.newE();

	option = new Option();
	option.setData("name", "Internet 2MB");
	option.setData("price", 50);
	option.newE();

	option = new Option();
	option.setData("name", "Internet 5MB");
	option.setData("price", 75);
	option.newE();

	option = new Option();
	option.setData("name", "Routeur LAN (4 connections)");
	option.setData("price", 60);
	option.newE();

	option = new Option();
	option.setData("name", "Table");
	option.setData("price", 100);
	option.newE();
    }

    private void initCompanyDomains() throws Exception
    {
	CompanyDomain companyDomain;
	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "autre");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "mécanique");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "physique");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "médical");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "pharmaceutique");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "électronique");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "informatique");
	companyDomain.newE();

	companyDomain = new CompanyDomain();
	companyDomain.setData("Name", "enseignement");
	companyDomain.newE();
    }
}
