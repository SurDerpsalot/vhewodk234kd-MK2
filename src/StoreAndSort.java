/**
 * So from how I understand this, we have a 8 block memory that we put blocks into,
 * sort those 8 blocks when the memory is full,
 * then store those in another memory, then merge them sometime later?
 * 
 *
 */
public class StoreAndSort {
	//private array of blocks to act as memory
	/**
	 * this will store a block into the array of blocks
	 */
	public void store (/*the block (an array of bytes?)*/){
		
	}
	/**
	 * where we sort the private array of blocks in ascending order via the keys.
	 * it is then immediately stored into a new memory to be murged later?
	 */
	public void heapSort(){
		
	}
	/**
	 * This merges the 8 blocks of memory into just one block of memeory? Or is it merging 
	 * 8 rows of 8 blocks in memory into just one row of 8 blocks in memory? Either way, I think
	 * this will need to be doing a Merge Sort algorithm in here since otherwise there is no guarantee
	 * that the end result would be in order.
	 */
	public void multiMerge(){
		
	}
}
