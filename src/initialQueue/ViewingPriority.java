package initialQueue;

import java.util.logging.Logger;

import scheduleView.WaitingScheduled;
import viewers_info.ViewingRequest;

public class ViewingPriority {
    static Logger logger = Logger.getLogger(ViewingPriority.class.getName());

   public static Node estimateViewerPosition(ViewingRequest viewer, DoublyLinkedList list) {
       Node current = list.getLastNode();
       while (current != null) {
    	   int priority = current.viewer.getViewingDate().compareTo(viewer.getViewingDate());
           if(priority<0)
        	   break;
    	   current = current.previous;
       }
       Node checkPos = list.getFirstNode();
       while (checkPos != null) {
            logger.info(" "+checkPos.viewer);
    	    checkPos = checkPos.next;
       }

       return current;

   }
}
