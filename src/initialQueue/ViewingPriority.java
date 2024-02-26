package initialQueue;

import java.util.logging.Logger;

import viewers_info.ViewingRequest;

public class ViewingPriority {
	
	public static Node estimateViewerPosition(ViewingRequest viewer, DoublyLinkedList list) {
       Node current = list.getLastNode();
       while (current != null) {
    	   int priority = current.viewer.getViewingDate().compareTo(viewer.getViewingDate());
           if(priority<0)
        	   break;
    	   current = current.previous;
       }

       return current;

	}
}
