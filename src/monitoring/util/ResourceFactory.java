package monitoring.util;

import database.model.Resource;
import database.model.Server;
import database.model.VirtualMachine;
import monitoring.types.ReferenceModelType;

public class ResourceFactory {

	public static Resource create(ReferenceModelType resourceType) {
		Resource resource = null;
		switch (resourceType)
		{
			case SERVER:
				resource = new Server();
				break;
			case VM:
				resource = new VirtualMachine();
				break;
			default:
				break;
		}
		return resource;
	}

}
