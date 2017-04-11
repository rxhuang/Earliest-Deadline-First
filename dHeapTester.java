/**
 *  NAME: Ruoxin Huang
 *  ID: A99084753
 *  LOGIN: cs12whl
 * */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.*;
/**
 *  Title: class dHeapTester
 *  Description: JUnit test class for dHeap class
 *  @author Ruoxin Huang
 *  @version 1.0
 *  @since 02-19-2016
 * */
public class dHeapTester
{
    private dHeap<Integer> empty;
    private dHeap<Integer> one;
    private dHeap<Integer> several;
    static final int DIM = 10;

    /**
     * Standard Test Fixture. An empty list, a list with one entry (0) and 
     * a list with several entries (0,1,2)
     */ 
    @Before
    public void setUp()
    {
        empty = new dHeap<Integer>(0);
        one = new dHeap<Integer>(1);
        one.add(new Integer(0));
        several = new dHeap<Integer>(4, DIM);
        // List: 1,2,3,...,Dim
        for (int i = DIM; i > 0; i--)
            several.add(new Integer(i));
    }
    
    /** Test size */
    @Test
    public void testSize()
    {
        assertEquals("empty has size 0", 0, empty.size());
        assertEquals("one has size 1", 1, one.size());
        assertEquals("several has size 10", 10, several.size());
    }
    
    /** Test add on several heap */
    @Test
    public void testAddElement()
    {
        try 
        {
            several.add(null);
            fail("Should have generated an exception!");  
        }
        catch(NullPointerException e)
        {
            //  normal
        }
        empty.add(5);
        empty.add(1);
        assertEquals("Check removed element is returned",new Integer(1), empty.removeSmallest()); // Check removed element is returned
        assertEquals("Check removed element is returned",new Integer(5), empty.removeSmallest()); // Check removed element is returned
        several.add(0);// Adding into several list
        assertEquals("Check removed element is returned",new Integer(0), several.removeSmallest()); // Check removed element is returned
        assertEquals("Check removed element is returned",new Integer(1), several.removeSmallest()); // Check removed element is returned
    }
    
    /** Test removeSmallest on several heap */
    @Test
    public void testRemoveElement()
    {
        try 
        {
            empty.removeSmallest();
            fail("Should have generated an exception!");  
        }
        catch(NoSuchElementException  e)
        {
            //  normal
        }
        assertEquals("Check removed element is returned",new Integer(1), several.removeSmallest()); // Check removed element is returned
        assertEquals("Check removed element is returned",new Integer(2), several.removeSmallest()); // Check removed element is returned
        assertEquals("Check the new size",DIM - 2, several.size()); // Check list resized
    }
}
