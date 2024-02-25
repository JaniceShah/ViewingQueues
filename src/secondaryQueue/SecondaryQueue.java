package secondaryQueue;

import viewers_info.ViewingRequest;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class SecondaryQueue extends Queue{

	
	 int size;
	 int currentQueueLength;
	  Queue primaryQueue;
	  Queue secondaryQueue;

	    
	  //Constructs a FixedSizeQueue with the specified size.
	    public SecondaryQueue(int size) {
	        super();
	        this.size = size;
	        this.currentQueueLength = 0;
	        this.primaryQueue = new Queue();
	        this.secondaryQueue = new Queue();
	    }
	    
	    
	    public boolean addViewer(ViewingRequest viewer) {
	        if (currentQueueLength >= size) {
	            return false;
	        }

	        Node currNode = headNode;
	        Node newNode = new Node(viewer);
	        if (headNode == null) {
	            insertAtStart(viewer);
	        } else {
	            while (currNode.nextNode != null) {
	                currNode = currNode.nextNode;
	            }
	            currNode.nextNode = newNode;
	            newNode.nextNode = null;
	            Date newViewingEstimate = viewer.getAssignedViewingDate();

	            if (primaryQueue.getLastViewer() != null && primaryQueue.getLastViewer().getAssignedViewingDate().equals(viewer.getAssignedViewingDate())) {
	                // Calculate the viewing time 2 hours later
	                Instant instant = viewer.getAssignedViewingDate().toInstant();
	                instant = instant.plus(Duration.ofHours(2));
	                Date newViewingDate = Date.from(instant);
	                viewer.setAssignedViewingDate(newViewingDate);
	                secondaryQueue.addViewer(viewer);
	            } else {
	                // Add viewer to primary queue if it's not for the same date
	                primaryQueue.addViewer(viewer);
	            }
	        }
	        
	        currentQueueLength++;
	        return true;
	    }
	   
	    
	    
}
