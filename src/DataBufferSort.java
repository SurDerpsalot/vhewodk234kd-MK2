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
    private int recsPerBlock = 512;
    private int byteSizeOfKey = 4;
    private long lastExecTime;
    /**
     * Runs the heap sort of the buffer data
     * @return a long value representing the exec time
     */
    protected ArrayList<Node> hmIn;    
    protected ArrayList<Node> hmOut;
    /**
     * constructor
     */
    public DataBufferSort() {
        hmIn = new ArrayList<Node>();  
        hmOut = new ArrayList<Node>();  
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
	 * 
	 */
	public void heapSort(RandomAccessFile rafIn, RandomAccessFile rafOut){
		
	}
	protected class Heap {
		private ArrayList<Node> heapStorage;
	    public void insertHashMap() {
	        if(heapStorage.size() < 4096)
	        {
	        	for(int i = 0; i < hmIn.size(); i++)
	        	{
	        		heapStorage.add(hmIn.get(i));
	        	}
	        	int n = (heapStorage.size()*recsPerBlock)/byteSizeOfKey;
	        	heapSort(heapStorage,n);
	        }
	        hmIn.clear();
	    }
	    private void heapSort(ArrayList<Node> theHeap, int n)
	    {
	    	for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(theHeap, n, i);
	     
	        // One by one extract an element from heap
	        for (int i=n-1; i>=0; i--)
	        {
	            // Move current root to end
	            Node temp = new Node(theHeap.get(i).getValue(),theHeap.get(i).getKey());
	            theHeap.get(i).setValue(theHeap.get(0).getValue());
	            theHeap.get(i).setKey(theHeap.get(0).getKey());
	            theHeap.get(0).setValue(temp.getValue());
	            theHeap.get(0).setKey(temp.getKey());
	     
	            // call max heapify on the reduced heap
	            heapify(theHeap, i, 0);
	        }	
	    }
	    private void heapify(ArrayList<Node> theHeap, int n, int i )
	    {

	        int largest = i;  // Initialize largest as root
	        int l = 2*i + 1;  // left = 2*i + 1
	        int r = 2*i + 2;  // right = 2*i + 2
	     
	        // If left child is larger than root
	        if (l < n && theHeap.get(l).getKey() > theHeap.get(largest).getKey())
	            largest = l;
	     
	        // If right child is larger than largest so far
	        if (r < n && theHeap.get(r).getKey() > theHeap.get(largest).getKey())
	            largest = r;
	     
	        // If largest is not root
	        if (largest != i)
	        {
	            Node temp = new Node(theHeap.get(largest).getValue(),theHeap.get(largest).getKey());
	            theHeap.get(largest).setValue(theHeap.get(i).getValue());
	            theHeap.get(largest).setKey(theHeap.get(i).getKey());
	            theHeap.get(i).setValue(temp.getValue());
	            theHeap.get(i).setKey(temp.getKey());
	            heapify(theHeap, n, largest);
	        }
	    }
	    public void outputHashMap() {
	    	hmOut.clear();
	        for(int i = 0; i < 4096;i++)
	        {
	        	hmOut.add(heapStorage.remove(0));
	        }
	    }
	}
	
}
class Node{
	private long value;
	private float key;
	public Node(long val, float k)
	{
		value = val;
		key = k;
	}
	public float getKey(){
		return key;
	}
	public long getValue(){
		return value;
	}
	public void setKey(float k){
		key = k;
	}
	public void setValue(long val){
		value = val;
	}
}
