package initialQueue;

import viewers_info.ViewingRequest;

class Node {
	ViewingRequest viewer;
	Node next;
    Node previous;
    
    /**

     Creating a new node which has current viewer info and points to previous and next viewer.
     @param viewer: viewer info whose data is being added to the node.
     @param next the next viewer in list
     @param previous the previous viewer in the list
     */
    public Node(ViewingRequest viewer, Node next, Node previous) {
        this.viewer = viewer;
        this.next = next;
        this.previous = previous;
    }
    
    public String toString() {
    	return " Viewing details"+ viewer;
    }
}
