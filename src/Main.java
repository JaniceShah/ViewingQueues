import java.io.IOException;
import java.text.ParseException;
import initialQueue.InitialQueue;
import scheduleView.WaitingScheduled;
import secondaryQueue.SecondaryQueue;
import viewers_info.ViewingRequest;
import viewers_info.ViewingRequestReader;

public class Main {
	
	static InitialQueue viewersQueue = new InitialQueue();
	static SecondaryQueue fixedQueue = new SecondaryQueue(3);

    
	public static void main(String[] args) {
		try{
			ViewingRequestReader dataReader = new ViewingRequestReader("./data2.csv");
			WaitingScheduled viewQueue = new WaitingScheduled(viewersQueue, dataReader);

			
				while (true) {
					ViewingRequest request = viewQueue.getRequest(); 
					if (request == null) // Check if there are no more requests
						break;

					if (fixedQueue.size() < 3) {
						// Add viewer to the fixed queue if it has less than 3 viewers
						fixedQueue.addViewer(request); 
					} else {
						ViewingRequest lastViewer = fixedQueue.getLastViewer();
						if (lastViewer != null && lastViewer.getAssignedViewingDate().equals(request.getAssignedViewingDate())) {
							// If viewer's assigned viewing date is the same as the last viewer in the fixed queue
							// Calculate the viewing time 2 hours later and add to secondary queue
							fixedQueue.addViewer(request);
						} else {
							// Otherwise, add viewer to the fixed queue
							fixedQueue.addViewer(request);
						}
					}
				}
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
    }
}