/**
 *  NAME: Ruoxin Huang
 *  ID: A99084753
 *  LOGIN: cs12whl
 * */ 
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *  Title: class EDF
 *  Description: Earliest Deadline First time management program
 *  @author Ruoxin Huang
 *  @version 1.0
 *  @since 02-19-2016
 * */
public class EDF {
    public static void main(String[] args) {
        if(args.length != 1) // Check if number of arguments correct
        {
            System.err.println("Incorrect number of arguments: "+args.length);
            System.err.println("java hw6.EDF <input-file>");
            System.exit(1); 
        }
        // Read file from command line
        File file = new File(args[0]);
        // Create new queue with size 10
        MyPriorityQueue<Record> queue = new MyPriorityQueue<Record>(10);
        // Initialize size and current_time
        int size =0;
        long current_time=0;
        try
        {
            Scanner sc = new Scanner(file); // Create scanner object
            while(sc.hasNext()) // While there exist more words in the file
            {
                String s1 = sc.next(); // Store the next word
                if(s1.equals("schedule")) // If the word is schedule creat record and add to queue
                {
                    size++; // Add 1 to size
                    // Store the next word and next two numbers
                    String s2 = sc.next(); 
                    int deadline = sc.nextInt();
                    int duration = sc.nextInt();
                    // Create new record object with the name, deadline, and duration
                    Record r1 = new Record(s2, deadline, duration);
                    // Add the record to the queue
                    queue.add(r1);
                    // Print it out
                    System.out.println(current_time+": adding " + r1.toString());
                }
                if(s1.equals("run")) // If the word is run run the time in the system
                {
                    long runTime = sc.nextInt()-current_time; // Calculate how many time to advance
                    // While runTime still has time remaining and while queue is not empty
                    while(runTime>0 && size>0) 
                    {
                        // Remove the record with earliest deadline
                        Record temp = queue.poll();
                        // Print out doing the process
                        System.out.println(current_time+": busy with " +temp.toString());
                        size--; // renew size
                        // renew runtime to take out the duration
                        runTime -= temp.GetDuration();
                        // Advance current time with the duration
                        current_time += temp.GetDuration();
                        if(runTime<0) // If run out of runTime
                        {
                            // create new record with remaining time and add it to queue
                            queue.add(new Record(temp, -runTime)); 
                            // Add twice and remove once to store the newly created record
                            queue.add(new Record(temp, -runTime)); 
                            temp = queue.poll();
                            size++;
                            // Refund the ecxceeded runTime to the current time 
                            current_time += runTime;
                            // Print out adding new record
                            System.out.println(current_time+": adding " +temp.toString());
                            // Break out of while loop and read new line
                            break;
                        }
                        // Print out done with process
                        System.out.println(current_time+": done with " +temp.toString(current_time));
                    }
                }
            }
        }
        catch(FileNotFoundException e) // Catch file not found exception
        {
            System.err.println("Failed to open "+file); // Tell user did not find file
            System.exit(1); 
        }
        System.exit(0);
    }
}
