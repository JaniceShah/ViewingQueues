import java.io.IOException;
import java.text.ParseException;
import initialQueue.InitialQueue;
import scheduleView.WaitingScheduled;
import secondaryQueue.SecondaryQueue;
import viewers_info.ViewingRequest;
// import viewers_info.ViewingRequest;
import viewers_info.ViewingRequestReader;

public class Main {
	
	static InitialQueue viewersQueue = new InitialQueue();
	static SecondaryQueue fixedQueue = new SecondaryQueue();

    
	public static void main(String[] args) {
		try{
			ViewingRequestReader dataReader = new ViewingRequestReader("./data2.csv");
			WaitingScheduled viewQueue = new WaitingScheduled(viewersQueue, dataReader);
			
			// Created the primary queue in which users are added as per the priority
			while (true) {
				int request = viewQueue.schedule(); 
				if(request<0)
					break;
			}

			// Printing the priority Queue
			viewersQueue.printingSchedule();

			//Assigning each user a slot. If all slots are full we will add them to waiting list
			while (true) {
				ViewingRequest viewerAssigned = viewersQueue.dequeue();
				if(viewerAssigned == null)
					break;
				fixedQueue.addViewer(viewerAssigned);
			}
			fixedQueue.printViewings();			
			fixedQueue.printWaitList();
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
    }
}