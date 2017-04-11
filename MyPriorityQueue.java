/**
 *  NAME: Ruoxin Huang
 *  ID: A99084753
 *  LOGIN: cs12whl
 * */
import java.util.*;
/**
 *  Title: class MyPriorityQueue
 *  Description: class that uses dheap to represent a priority queue 
 *  @author Ruoxin Huang
 *  @version 1.0
 *  @since 02-19-2016
 * */
public class MyPriorityQueue<T extends Comparable <? super T>>
{
    private dHeap<T> priorityQueue; // Adapter style, create priority queue with dheap
    
    /** contructor for pirority queue
     */ 
    public MyPriorityQueue(int size)
    {
        priorityQueue = new dHeap<T>(size);
    }

    /** Adds an element to a storage 
     * 
     * @param newItem - item to be added
     */  
    public void add(T newItem)
    {
        priorityQueue.add(newItem);
    }

    /** Removes the object from the storage and returns
     * that object as the value of this function.
     * 
     * @return   value of the removed object.
     */  
    public T poll()
    {
        if(priorityQueue.size() <=0) // If remove from empty queue return null
        {
            return null;
        }
        return priorityQueue.removeSmallest();
    }
    
    /** Private method used to test
     * Returns the size of the storage 
     * 
     * @return   the size of the storage
     */ 
    /*
    private int size()
    {
        return priorityQueue.size();
    }
    */
}
