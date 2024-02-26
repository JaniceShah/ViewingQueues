package secondaryQueue;

import viewers_info.ViewingRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import helpers.Constants;
import initialQueue.ViewingPriority;

public class SecondaryQueue extends Queue{

	
	int currentQueueLength;
	Queue waitingListQueue;
	private List<Queue> timeSlotQueues;
	static Logger logger = Logger.getLogger(ViewingPriority.class.getName());

	    
	  //Constructs a FixedSizeQueue with the specified size.
	    public SecondaryQueue() {
	        super();
	        this.currentQueueLength = 0;
	        this.waitingListQueue = new Queue();
			this.timeSlotQueues = new ArrayList<>();
			for (int i = 0; i < Constants.FIXED_TIME_SLOTS; i++) {
				timeSlotQueues.add(new Queue());
			}
	    }

		public boolean addViewer(ViewingRequest viewer) {
            // Find the first non-empty queue among time slot queues
            Queue firstNonEmptyQueue = null;
            for (Queue queue : timeSlotQueues) {
                if (queue.size() < Constants.MAX_QUEUE_SIZE) {
                    firstNonEmptyQueue = queue;
                    break;
                }
            }

            if (firstNonEmptyQueue != null && firstNonEmptyQueue.size() < Constants.MAX_QUEUE_SIZE) {
                // Add the viewer to the first non-empty queue if it's not full
                firstNonEmptyQueue.addViewer(viewer);
            } else {
                // Add the viewer to the primary queue if all time slot queues are full or empty
                waitingListQueue.addViewer(viewer);
            }
        return true;
		}	    
		
		public void printViewings() {
			System.out.println("Printing Assigned Viewers");
			for(int i=0;i<timeSlotQueues.size();i++) {
				System.out.println(" Time Slot No: "+(i+1));
				printingQueues(timeSlotQueues.get(i));
			}
		}
		public void printWaitList() {
			System.out.println("Printing Waiting List");
			printingQueues(waitingListQueue);
		}
		
		public void printingQueues(Queue viewer) {
			Node viewers = viewer.headNode;
			while (viewers != null) {
				logger.info(" " + viewers.viewer);
				viewers = viewers.nextNode;
			}
		}
}
