package initialQueue;

import viewers_info.ViewingRequest;

public class InitialQueue {
	    public DoublyLinkedList viewersList;

	    /**
	     * Creates a new priority queue with an empty list.
	     */
	    public InitialQueue() {
	        viewersList = new DoublyLinkedList();
	    }

	    public void enqueue(ViewingRequest viewer) {
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
