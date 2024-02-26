package initialQueue;

import java.util.logging.Logger;

import viewers_info.ViewingRequest;

public class InitialQueue {

	public DoublyLinkedList viewersList;

	static Logger logger = Logger.getLogger(ViewingPriority.class.getName());

	int minimumIncome = 35000;

	/**
	 * Creates a new priority queue with an empty list.
	 */
	public InitialQueue() {
		viewersList = new DoublyLinkedList();
	}

	public void enqueue(ViewingRequest viewer) {
		if (viewer.getIncome() < minimumIncome) {
			System.out.println("The users income is lesser than the minimum income accepted");
			return;
		}

		Node addAfterNode = ViewingPriority.estimateViewerPosition(viewer, viewersList);

		if (addAfterNode != null) {
			viewersList.insert(viewer, addAfterNode);
		} else {
			viewersList.addFirst(viewer);
		}
	}

	public ViewingRequest dequeue() {
		if (isEmpty()) {
			return null;
		}
		return viewersList.pop();
	}

	public ViewingRequest peek() {
		if (isEmpty()) {
			return null;
		}
		return viewersList.getFirstNode().viewer;
	}

	public void printingSchedule() {
		System.out.println("Printing the initial queue of users");
		Node viewers = viewersList.getFirstNode();
		while (viewers != null) {
			logger.info(" " + viewers.viewer);
			viewers = viewers.next;
		}
	}

	/**
	 * Returns the number of flights in the priority queue.
	 *
	 * @return the number of flights in the priority queue
	 */
	public int size() {
		return viewersList.size();
	}

	/**
	 * Returns true if the priority queue is empty, false otherwise.
	 *
	 * @return true if the priority queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return viewersList.isEmpty();
	}
}
