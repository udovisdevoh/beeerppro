package modules.expoModule;

import modules.expoModule.entityDefinitions.CompanyDomain;
import modules.expoModule.entityDefinitions.Corridor;
import modules.expoModule.entityDefinitions.Floor;
import modules.expoModule.entityDefinitions.InternetConnectionType;
import modules.expoModule.entityDefinitions.Option;
import modules.expoModule.entityDefinitions.WallType;
import modules.userRightModule.UserRightModule;
import modules.userRightModule.entityDefinitions.Groups;
import newtonERP.common.ListModule;
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

	initFloor();
	initPermissions();
	initCompanyDomains();
	initOptions();
	initWallTypes();
	initInternetConnectionTypes();
    }

    private void initInternetConnectionTypes() throws Exception
    {
	InternetConnectionType internetConnectionType;

	internetConnectionType = new InternetConnectionType();
	internetConnectionType.setData("Name", "aucune");
	internetConnectionType.newE();

	internetConnectionType = new InternetConnectionType();
	internetConnectionType.setData("Name", "Internet 500KB");
	internetConnectionType.newE();

	internetConnectionType = new InternetConnectionType();
	internetConnectionType.setData("Name", "Internet 2MB");
	internetConnectionType.newE();

	internetConnectionType = new InternetConnectionType();
	internetConnectionType.setData("Name", "Internet 5MB");
	internetConnectionType.newE();
    }

    private void initFloor() throws Exception
    {
	Floor floor = new Floor();
	floor.setData("Nom", "Expo 67");
	floor.setData("Width", 13);
	floor.setData("Height", 11);
	floor.newE();

	addCorridor(floor, true, 0);
	addCorridor(floor, true, 2);
	addCorridor(floor, true, 7);
	addCorridor(floor, true, 10);
	addCorridor(floor, true, 12);

	addCorridor(floor, false, 0);
	addCorridor(floor, false, 2);
	addCorridor(floor, false, 5);
	addCorridor(floor, false, 8);
	addCorridor(floor, false, 10);
    }

    private void addCorridor(Floor floor, boolean isVertical, int position)
	    throws Exception
    {
	Corridor corridor;
	corridor = new Corridor();
	corridor.assign(floor);
	corridor.setData("IsVertical", isVertical);
	corridor.setData("Position", position);
	corridor.newE();
    }

    private void initWallTypes() throws Exception
    {
	WallType wallType;

	wallType = new WallType();
	wallType.setData("Name", "nord-ouest");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "nord-est");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "est-nord");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "est-sud");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "sud-est");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "sud-ouest");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "ouest-sud");
	wallType.newE();

	wallType = new WallType();
	wallType.setData("Name", "ouest-nord");
	wallType.newE();
    }

    private void initPermissions() throws Exception
    {
	Groups groups;

	groups = new Groups();
	groups.setData("groupName", "expoGroup");
	groups.newE();

	UserRightModule userRightModule = (UserRightModule) ListModule
		.getModule("UserRightModule");

	userRightModule.addGroupsRight("unLogedGroup", "ShowSplashScreen");
	userRightModule.addGroupsRight("unLogedGroup", "Subscribe");

	userRightModule.addGroupsRight("expoGroup", "Logout");
	userRightModule.addGroupsRight("expoGroup", "ShowSplashScreen");
	userRightModule.addGroupsRight("expoGroup", "ViewFloor");

	userRightModule.addGroupsRight("expoGroup", "GetList", "Floor");
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
