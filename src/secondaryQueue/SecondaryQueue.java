package secondaryQueue;

import viewers_info.ViewingRequest;
import java.util.ArrayList;
import java.util.List;

public class SecondaryQueue extends Queue{

	
	int size;
	int currentQueueLength;
	Queue waitingListQueue;
	Queue secondaryQueue;
	private List<Queue> timeSlotQueues;
    private static final int FIXED_TIME_SLOTS = 7;
    private static final int MAX_QUEUE_SIZE = 3;

	    
	  //Constructs a FixedSizeQueue with the specified size.
	    public SecondaryQueue(int size) {
	        super();
	        this.size = size;
	        this.currentQueueLength = 0;
	        this.waitingListQueue = new Queue();
			this.timeSlotQueues = new ArrayList<>();
			for (int i = 0; i < FIXED_TIME_SLOTS; i++) {
				timeSlotQueues.add(new Queue());
			}
	    }

		public boolean addViewer(ViewingRequest viewer) {
            // Find the first non-empty queue among time slot queues
            Queue firstNonEmptyQueue = null;
            for (Queue queue : timeSlotQueues) {
                if (queue.size() < MAX_QUEUE_SIZE) {
                    firstNonEmptyQueue = queue;
                    break;
                }
            }

            if (firstNonEmptyQueue != null && firstNonEmptyQueue.size() < MAX_QUEUE_SIZE) {
                // Add the viewer to the first non-empty queue if it's not full
                firstNonEmptyQueue.addViewer(viewer);
            } else {
                // Add the viewer to the primary queue if all time slot queues are full or empty
                waitingListQueue.addViewer(viewer);
            }
        return true;
    }	    
}
