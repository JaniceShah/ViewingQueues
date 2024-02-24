package initialQueue;

import viewers_info.ViewingRequest;

public class ViewingPriority {

   public static Node estimateViewerPosition(ViewingRequest viewer, DoublyLinkedList list) {
       Node current = list.getLastNode();
       while (current != null) {
    	   int priority = current.viewer.getMoveInDate().compareTo(viewer.getMoveInDate());
           if(priority>0)
        	   break;
    	   current = current.previous;
       }
       return current;

   }
}
