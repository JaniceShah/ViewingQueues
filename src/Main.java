import java.io.IOException;
import java.text.ParseException;

import viewers_info.ViewingRequest;
import viewers_info.ViewingRequestReader;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
            ViewingRequestReader dataReader = new ViewingRequestReader("./data2.csv");
	          for (int i = 0; i < 5; i++) {
	            ViewingRequest viewingRequest = dataReader.readViewingRequest();
	            if (viewingRequest != null) {
	                System.out.println("Viewing Request " + (i + 1) + ":");
	                System.out.println(viewingRequest);
	            } else {
	                System.out.println("No more viewing requests available.");
	                break; // Exit loop if no more requests available
	            }
	        }
    }
}