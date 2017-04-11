

/**
 *  NAME: Ruoxin Huang
 *  ID: A99084753
 *  LOGIN: cs12whl
 * */
import java.util.*;
/**
 *  Title: class dHeap
 *  Description: implements dHeapInterface
 *  @author Ruoxin Huang
 *  @version 1.0
 *  @since 02-19-2016
 * */
class dHeap <T extends Comparable <? super T>> implements dHeapInterface<T> {
    private int children = 0;
    private int nelems = 0;
    private int size = 0; 
    private T[ ] array = (T[ ]) new Comparable[100];
    /**
     * The cdefault onstructor of binary heap
     * 
     * @param  heapSize  an initial capacity
     */
    public dHeap (int heapSize)
    {
        array = (T[ ]) new Comparable[heapSize]; 
        // initialize variables
        size = heapSize; 
        nelems = 0;
        children = 2;
    }

    /**
     * The constructor of dHeap 
     * 
     * @param  heapSize  an initial capacity
     * @param  d  the number of children
     * @exception  IllegalArgumentException  if d is less than 1
     */
    public dHeap (int d, int heapSize) throws IllegalArgumentException 
    {
        array = (T[ ]) new Comparable[heapSize];
        if(d<1) // If children less than 1 throw IllegalArgumentException
        {
            throw new IllegalArgumentException ();
        }
        // initialize variables
        children = d;
        size = heapSize;
        nelems = 0;
    }

    /**
     * Gives the size of the heap
     * 
     * @return   the size of the heap
     */
    public int size () 
    {
        return nelems; // Size is equal to number of elements
    }

    /**
     * Adds the specified element to the heap
     * data cannot be null. Resizes the storage if full.
     * 
     * @param  newItem   the element to add to the heap
     * @exception  NullPointerException  if add null data
     */
    public void add (T data) 
    {
        if(data==null) // If add null data throw NullPointerException
        {
            throw new NullPointerException();
        }
        if(nelems==size) // If full resize
        {
            doubleSize();
        }
        array[nelems] = data; // Add the data to the end of the heap
        bubbleUp(nelems); // Bubble up the added element to correct position
        nelems++;
    }

    /**
     * Removes the smallest element in the heap
     * cannot return from empty heap.
     * 
     * @return   the element removed from the heap
     * @exception  NoSuchElementException  if the heap is empty
     */
    public T removeSmallest () throws NoSuchElementException 
    {
        if(nelems==0) // If remove from empty set throw NoSuchElementException
        {
            throw new NoSuchElementException();
        }
        T data = array[0]; // Store the data on the element to be removed 
        array[0] = array[nelems-1]; // remove top element and put the last element to the top
        trickleDown(0); // Trickle the top element down to correct position
        nelems--;
        return data; // Return the removed balue
    }

    /**
     * Helper method to bubble an element up the heap to correct position.
     * 
     * @param  indx  the index of the element to bubble up
     */
    private void bubbleUp(int indx)
    {
        if(indx==0) // If already at top, then exit
        {
            return;
        }
        int parent = (int) ((indx-1)/children); // The index of its parent 
        if(array[indx].compareTo(array[parent])==1) // If child greater than parent, then exit
        {
            return;
        }
        // Swap the parent and the child
        T temp = array[indx];
        array[indx] = array[parent];
        array[parent] = temp;
        // Recursion until in correct position and exit
        bubbleUp(parent);
    }

    /**
     * Helper method to trickle an element down the heap to correct position.
     * 
     * @param  indx  the index of the element to trickle down
     */
    private void trickleDown(int indx)
    {
        int smallestChild = smallestChild(indx); // The index of the smallest child
        if(smallestChild>=nelems-1) // If already at bottom, then exit
        {
            return;
        }
        if(array[indx].compareTo(array[smallestChild])==-1) // If parent smaller than child, then exit
        {
            return;
        }
        // Swap child and parent
        T temp = array[indx];
        array[indx] = array[smallestChild];
        array[smallestChild] = temp;
        // Recursion until in correct position and exit
        trickleDown(smallestChild);
    }

    /**
     * Helper method for trickle down to find the smallest child
     * @param  indx  the index of the parent
     * @return  the index of the smallest child
     */
    private int smallestChild(int indx)
    {
        int smallestIndx = indx*children+1; // Index of smallest children set to first child
        for(int i=2; i<=children; i++) // Loop through every child
        {
            if(indx*children+i>=nelems-1) // If no more children to compare, return smallest chiild
            {
                return smallestIndx;
            }
            // If a child smaller than smallest child, renew smallest child
            if(array[smallestIndx].compareTo(array[indx*children+i])==1) 
            {
                smallestIndx = indx*children+i;
            }
        }
        return smallestIndx;
    }

    /**
     * Helper method used to double the size of the heap when full
     * creates new heap with double size plus 1 to counter empty heaps
     * 
     */
    public void doubleSize()
    {
        T[] doubleSize = (T[ ]) new Comparable[size*2+1]; // Make new array with double the size plus 1
        // Copy the old array into the new array
        for(int i=0; i<nelems; i++)
        {
            doubleSize[i] = array[i]; 
        }
        // Reset size and array
        array = doubleSize;
        size = size*2+1;
    }
}
