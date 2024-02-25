package secondaryQueue;

import viewers_info.ViewingRequest;

public class Queue {

	Node headNode;
	
    public Queue() {
        headNode = null;
    }
	
    //Inserts a new object at the start of the Queue.
    public void insertAtStart(ViewingRequest viewer) {
        Node newNode = new Node(viewer);
        newNode.nextNode = headNode;
        headNode = newNode;
    }
    
    //Inserts a new object at the end of the Queue.
    public void insertAtEnd(ViewingRequest viewer) {
        if (headNode == null) {
            insertAtStart(viewer);
        } else {
            Node currNode = headNode;
            while (currNode.nextNode != null) {
                currNode = currNode.nextNode;
            }
            Node newNode = new Node(viewer);
            currNode.nextNode = newNode;
            newNode.nextNode = null;
        }
    }
    
    // Returns the object at the end of the Queue without removing it.
    public ViewingRequest getLastViewer() {
        if (headNode == null) {
            return null; // Return null if queue is empty
        }
        Node currNode = headNode;
        while (currNode.nextNode != null) {
            currNode = currNode.nextNode;
        }
        return currNode.viewer;
    }

    // Adds a new object at the end of the Queue.
    public boolean addViewer(ViewingRequest viewer) {
        insertAtEnd(viewer);
		return false;
    }
    
    //Returns the object at the head of the Queue without removing it.
    public ViewingRequest peek() {
        if (headNode == null) {
            return null;
        }
        return headNode.viewer;
    }
    
    //Deletes the object at the head of the Queue.
    public void deleteAtStart() {
        Node currNode = headNode;
        if (headNode != null) {
            headNode = currNode.nextNode;
        } else {
            System.out.println("There are no elements in the Queue.");
        }
    }
    
    //Displays the contents of the Queue on the console.
    public void display() {
        Node currNode = headNode;
        if (currNode == null) {
            System.out.println("List is Empty");
        } else {
            while (currNode.nextNode != null) {
                System.out.print(currNode.viewer.getViewingDate() + " -> ");
                currNode = currNode.nextNode;
            }
            System.out.print(currNode.viewer.getViewingDate());
        }
        System.out.println("\n");
    }
    
    //Returns a String representation of the Queue object.
    public String toString() {
        String result = this.getClass().getCanonicalName() + "{";
        Node currNode = headNode;
        while (currNode != null) {
            result += currNode.viewer.getViewingDate() + ",";
            currNode = currNode.nextNode;
        }
        result += "}";
        return result;
    }
    
    //Returns the number of objects in the Queue.
    public int size() {
        int count = 0;
        Node currNode = headNode;
        while (currNode != null) {
            count++;
            currNode = currNode.nextNode;
        }
        return count;
    }

   
}
