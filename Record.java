/**
 *  NAME: Ruoxin Huang
 *  ID: A99084753
 *  LOGIN: cs12whl
 * */
 /**
 *  Title: class Record
 *  Description: creates a record object that keeps track of event`s name, duration, and deadline
 *  @author Ruoxin Huang
 *  @version 1.0
 *  @since 02-19-2016
 * */
public class Record implements Comparable<Record> {
    private String process;
    private long deadline; 
    private long duration; 

    /**
     * constructor to create a new record
     *
     * @param  precess   the name of the process
     * @param  deadline   the deadline of the process
     * @param  duration   the duration of the process
     */
    Record (String process, long deadline, long duration)
    {
        this.process = process;
        this.deadline = deadline;
        this.duration = duration;
    }

    /**
     * constructor to create a new record
     * from the esisting record and new
     *
     * @param  duration   the duration left of the process
     */
    Record (Record r, long duration)
    {
        this.process=r.process;
        this.deadline=r.deadline;
        this.duration=duration;
    }

    /**
     * access the duration of a precess
     *
     * @return  the duration the process
     */
    public long GetDuration()
    {
        return duration;
    }

    /**
     * toString method for a record object
     *
     * @return  the string representation fo record
     */
    public String toString()
    {
        return process+" with deadline "+deadline+" and duration "+duration;
    }

    /**
     * toString method for a record object
     *
     * @param  current_time   the current time of the system
     * @return  the string representation fo record
     */
    public String toString(long current_time)
    {
        // If the already past the deadline, then return process with late 
        if(current_time > deadline) return process + " (late)"; 
        return process;
    }

    /**
     * Compares the objext with another record
     *
     * @param  o   the record to be compared with
     * @return  -1 if o bigger, 1 if o smaller, 0 if equal
     */
    @Override
    public int compareTo(Record o) 
    {
        if(this.deadline<o.deadline) // If o is bigger return -1
        {
            return -1;
        }else if(this.deadline>o.deadline) // If o i smaller return 1
        {
            return 1;
        }else // Otherwise they are equal return 0
        {
            return 0;
        }
    }
}
