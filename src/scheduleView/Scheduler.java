package scheduleView;

import java.io.IOException;
import java.text.ParseException;

public abstract class Scheduler{
    abstract int schedule() throws IOException, ParseException;

}
