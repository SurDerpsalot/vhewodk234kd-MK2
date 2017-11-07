import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//import java.io.PrintWriter;

/**
 * So from how I understand this, we have a 8 block memory that we put blocks into,
 * sort those 8 blocks when the memory is full,
 * then store those in another memory, then merge them sometime later?
 * 
 *
 */
public class DataBufferSort {
	//private array of blocks to act as memory
	/**
	 * this will store a block into the array of blocks
	 */
    
    private long lastExecTime;
    /**
     * Runs the heap sort of the buffer data
     * @return a long value representing the exec time
     */
    protected HashMap<Float,Long> hmIn;    
    protected HashMap<Float,Long> hmOut;
    /**
     * constructor
     */
    public DataBufferSort() {
        hmIn = new HashMap<Float,Long>(1024, (float) 0.75);  
        hmOut = new HashMap<Float,Long>(1024, (float) 0.75);  
        lastExecTime = -1;
    }
   // private HashMap<long k, float v> map;// = new HashMap<>();
    long runHeapSort(){
        lastExecTime = -2;
        long stop = 0;
        long start = System.currentTimeMillis();
       // heapSort();
        stop = System.currentTimeMillis();
        lastExecTime = stop - start;
        return lastExecTime;
    };
	public void store (/*the block (an array of bytes?)*/){
		
	}
    
	/**
     * This merges the 8 blocks of memory into just one block of memory? Or is it merging 
     * 8 rows of 8 blocks in memory into just one row of 8 blocks in memory? Either way, I think
     * this will need to be doing a Merge Sort algorithm in here since otherwise there is no guarantee
     * that the end result would be in order.
     */
    public void multiMerge(RandomAccessFile rafIn, RandomAccessFile rafOut){
        
    }

    
    
    /**
	 * where we sort the private array of blocks in ascending order via the keys.
	 * it is then immediately stored into a new memory to be murged later?
	 */
	public void heapSort(RandomAccessFile rafIn, RandomAccessFile rafOut){
		
	}
	protected class Heap {
	    public void insertHashMap() {
	        
	    }
	    public void outputHashMap() {
	        
	    }
	}
}
