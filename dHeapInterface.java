/**
 *  NAME: Ruoxin Huang
 *  ID: A99084753
 *  LOGIN: cs12whl
 * */
import java.util.*;
/**
 *  Title: class dHeapInterface
 *  Description: an interface for heap with add, remove, and size functions
 *  @author Ruoxin Huang
 *  @version 1.0
 *  @since 02-19-2016
 * */
public interface dHeapInterface<T extends java.lang.Comparable<? super T>>
{
    /**
     * Adds the specified element to the heap
     * newItem cannot be null. Resizes the storage if full.
     * 
     * @param  newItem   the element to add to the heap
     */
    public void add(T newItem);
    
    /**
     * Removes and returns the smallest element stored in the heap. 
     * 
     * @exception  NoSuchElementException  if the heap is empty
     * @return     the smallest element stored in the heap.
     */
    public T removeSmallest() throws NoSuchElementException;
    

    /**
     * Returns the number of elements stored in the heap.  
     * @return     the number of elements stored in the heap.
     */
    public int size();
}
