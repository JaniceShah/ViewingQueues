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
					int request = viewQueue.schedule(); 
					if(request<0)
						break;
				}
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
    }
}