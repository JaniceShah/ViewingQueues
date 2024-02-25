package secondaryQueue;


import viewers_info.ViewingRequest;

class Node {
	ViewingRequest viewer;
	Node nextNode;
    
    
    /**

     Creating a new node which has current viewer info and points next viewer.
     @param viewer: viewer info whose data is being added to the node.
     @param next the next viewer in list
     
     */
    public Node(ViewingRequest viewer) {
        this.viewer = viewer;
        this.nextNode = null;
    }
    
    public ViewingRequest getViewingRequest() {
        return viewer;
    }
}
