package com.ibm.interfaces;

public class Application
{
	public void permissiontoLand(Flyer flyer){
		flyer.land();
	}
	public void permissionToDock(Sailer sailer) {
		sailer.dock();
	}
	
	public static void main( String[] args )
	{
		Application application = new Application();
		Flyer flyer = new Airplane();
		Seaplane sailer = new Seaplane();
		application.permissiontoLand(flyer);
		application.permissiontoLand(sailer);
		application.permissionToDock(sailer);
	}
}