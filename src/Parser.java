import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
//import java.io.PrintWriter;
import java.util.Scanner;

public class Parser {
    int BLOCK_BYTES = 4096;
    int RECORD_BYTES = 8;
	private String inFile;
	private String outFile;
	private String runningFile1;
	private Scanner sc;
	private Node in;
	private RandomAccessFile raf; 
	private DataBufferSort dbs;
	public Parser(String inputFile, String outputFile){
	    dbs = new DataBufferSort();
	    inFile = inputFile;
		outFile = outputFile;
		try {
		    raf = new RandomAccessFile(inFile, "rw");
		}
        catch (FileNotFoundException e) {
            System.err.println("Could not file file:" );
        } 
	}
	/**
	 * This function will read in the first block and then parse it out and
	 * store the values and keys to be heapSorted. To be 100% honest, I am
	 * very confused about how most everything in this project is working.
	 */
	public void parse() { 
		/*
		 * so in this try loop, we would be reading in each block i think? then parsing it?
		 * or we are reading in byte by byte and determining values and keys from that.
		 * either way, after this method, we store a block into a buffer? I don't know.
		 */
		try {
			long offset = 0;
			//Get the position of the first record (should be 0):
			offset = raf.getFilePointer();
			//Grab first line (first complete record):
            if (raf.length() % (8 * BLOCK_BYTES) != 0 ) {
                System.out.println("Error: bad file length");
                return;
            }
            long numberOfBlocks = raf.length() / (BLOCK_BYTES);
            for(long b = 0; b < numberOfBlocks; b++) {
                offset = parseAndDump(b, offset);
            };
            System.out.println("The number of blocks is: " + (raf.length()/BLOCK_BYTES));
			
		} 
		catch (IOException e) {
			System.err.println("Writing error: " + e);
		}
	}
	/**
	 * This class outputs the finished sort to the standard output
	 * and will generate the statistics file (probably?)
	 */
//  public void outputDump(){}
//
	/**
	 * This function parses the input file 
	 */
	private long parseAndDump(long blockNumber, long fileOffset){
	    try {
	        raf.seek(fileOffset);
            for(int i = 0; i < BLOCK_BYTES/RECORD_BYTES; i++) {
                //read the record value as an unsigned int 
                //by saving it in a long format while bitmasked:
                long value = raf.readInt() & 0x00000000ffffffffL;
                float key = raf.readFloat();
                //Tell the world:
                System.out.println("The record number is: " 
                        + (blockNumber*BLOCK_BYTES/RECORD_BYTES + i));
                System.out.println("The record key-value pair is: " 
                        + key + ", " + value);
                //TODO: move values into a HashMap
                in = new Node(value,key);
                dbs.hmIn.add(in);
            }
            return raf.getFilePointer();        
	    }
	    catch (IOException e) {
            System.err.println("Writing error: " + e);
	    }
	    //TODO: Once the HashMap is filled
	    return -1;
	}
} //end of ParseData class

