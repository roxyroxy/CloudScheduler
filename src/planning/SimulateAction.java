package planning;

import java.util.Iterator;
import java.util.List;

import planning.actions.Action;
import database.model.DataCenter;

public class SimulateAction {

	private DataCenter copyOfDataCenter;

	public SimulateAction(DataCenter dataCenter) {
		copyOfDataCenter = dataCenter;
	}

	/**
	 * Simulates the execution of the list of actions
	 * 
	 * @param act
	 *            = list of actions to be simulated
	 * @return copy of data center, altered by the simulation of these actions
	 */
	public DataCenter doActions(List<Action> act) {
		Iterator<Action> it = act.iterator();
		while (it.hasNext()) {
			Action action = it.next();
			doAction(action);
		}
		return copyOfDataCenter;
	}

	public DataCenter doAction(Action act) {

		if (act != null)
			copyOfDataCenter = act.Do(copyOfDataCenter);
		return copyOfDataCenter;
	}

	/**
	 * Simulates the undo execution of the list of actions
	 * 
	 * @param act
	 *            = list of actions to be "undo" simulated
	 * @return copy of data center, altered by the simulation of these actions
	 */
	public DataCenter undoActions(List<Action> act) {
		Iterator<Action> it = act.iterator();
		while (it.hasNext()) {
			Action action = it.next();
			undoAction(action);
		}
		return copyOfDataCenter;
	}
	
	public DataCenter undoAction(Action act) {

		if (act != null)
			copyOfDataCenter = act.Undo(copyOfDataCenter);
		return copyOfDataCenter;
	}
}
