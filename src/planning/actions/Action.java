package planning.actions;

import GUI.DataCenterInterface;
import logger.CloudLogger;
import monitoring.util.FacadeFactory;
import database.model.DataCenter;
import database.model.Server;
import database.model.VirtualMachine;

public abstract class Action {
	private Server sourceServer;
	private Server destinationServer;
	private VirtualMachine vm;
	private float cost;
	private FacadeFactory facadeFactory;

	public Action(Server sourceServer, Server destinationServer,
			VirtualMachine vm) {
		this.sourceServer = sourceServer;
		this.destinationServer = destinationServer;
		this.vm = vm;
		this.facadeFactory = new FacadeFactory();
		CloudLogger.getInstance().LogInfo("Simulating " + this);
		DataCenterInterface.getInstance().printlnText("Simulating " + this);
	}
	
	public Action(Server sourceServer, Server destinationServer,
			VirtualMachine vm, float cost) {
		this(sourceServer, destinationServer, vm);
		this.cost = cost;
	}

	public abstract DataCenter Do(DataCenter dc);

	public abstract DataCenter Undo(DataCenter dc);

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	/**
	 * @return the sourceServerID
	 */
	public Server getSourceServer() {
		return sourceServer;
	}

	/**
	 * @param sourceServer
	 *            the sourceServerID to set
	 */
	public void setSourceServer(Server sourceServer) {
		this.sourceServer = sourceServer;
	}

	/**
	 * @return the destinationServer
	 */
	public Server getDestinationServer() {
		return destinationServer;
	}

	/**
	 * @param destinationServer
	 *            the destinationServer to set
	 */
	public void setDestinationServer(Server destinationServer) {
		this.destinationServer = destinationServer;
	}

	/**
	 * @return the vm
	 */
	public VirtualMachine getVM() {
		return vm;
	}

	/**
	 * @param vm
	 *            the vMID to set
	 */
	public void setVM(VirtualMachine vm) {
		this.vm = vm;
	}

	/**
	 * @return the facadeFactory
	 */
	public FacadeFactory getFacadeFactory() {
		return facadeFactory;
	}

}
