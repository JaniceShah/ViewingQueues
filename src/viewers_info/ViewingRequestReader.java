package viewers_info;

import helpers.CSVReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ViewingRequestReader extends CSVReader {

    public ViewingRequestReader(String path) throws FileNotFoundException {
        super(path);
    }

    public ViewingRequestReader(String path, String delimiter) throws FileNotFoundException {
        super(path, delimiter);
    }

    public ViewingRequest readViewingRequest() throws IOException, ParseException {
        String[] data = this.readLine();
        if (data == null) {
            return null; // Reached end of file
        }

        // Parse data and create ViewingRequest object
        // Assuming the date format is "dd/MM/yyyy HH:mm:ss"
        Date dateApplied = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data[0]);
        String name = data[1];
        String address = data[2];
        int income = Integer.parseInt(data[3]);
        Date moveInDate = new SimpleDateFormat("dd/MM/yyyy").parse(data[4]);

        return new ViewingRequest(dateApplied, name, address, income, moveInDate);
    }
}