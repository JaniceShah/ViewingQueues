package scheduleView;

import java.io.IOException;
import java.text.ParseException;

import initialQueue.InitialQueue;
import viewers_info.ViewingRequest;
import viewers_info.ViewingRequestReader;

public class WaitingScheduled extends Scheduler {
    private ViewingRequestReader reader;
    private InitialQueue viewingWaitlist;

    public WaitingScheduled(InitialQueue viewingWaitlist, ViewingRequestReader reader) {
        this.reader = reader;
        this.viewingWaitlist = viewingWaitlist;
    }

    public ViewingRequest getRequest() throws IOException, ParseException {
        return getRequest();
    }
    
    public int schedule() throws IOException, ParseException {
        ViewingRequest viewer = reader.readViewingRequest();
        if(viewer==null)
            return -1;
        viewingWaitlist.enqueue(viewer);
        return 1;
    }
}
