import java.io.IOException;
import java.text.ParseException;
import initialQueue.InitialQueue;
import scheduleView.WaitingScheduled;
import viewers_info.ViewingRequest;
import viewers_info.ViewingRequestReader;

public class Main {
	
	static InitialQueue viewersQueue = new InitialQueue();
    
	public static void main(String[] args) {
		try{
			ViewingRequestReader dataReader = new ViewingRequestReader("./data2.csv");
			WaitingScheduled viewQueue = new WaitingScheduled(viewersQueue, dataReader);

			while (true) {
				if(viewQueue.schedule()<0)
					break;
			}
		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
    }
}