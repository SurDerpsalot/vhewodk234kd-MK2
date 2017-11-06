import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
//import java.io.PrintWriter;
import java.util.Scanner;

public class Parser {
	private String inFile;
	private String outFile;
	private String runningFile1;
	private Scanner sc;
	public Parser(String inputFile, String outputFile){
		inFile = inputFile;
		outFile = outputFile;
	}
	/**
	 * This function will read in the first block and then parse it out and
	 * store the values and keys to be heapSorted. To be 100% honest, I am
	 * very confused about how most everything in this project is working.
	 */
	public void parse() { 
		byte readByte[] = {};
		int value;
		int hold;
		float key;
		/*
		 * so in this try loop, we would be reading in each block i think? then parsing it?
		 * or we are reading in byte by byte and determining values and keys from that.
		 * either way, after this method, we store a block into a buffer? I don't know.
		 */
		try {
			long offset = 0;
			RandomAccessFile raf = new RandomAccessFile(inFile, "rw");
			//Get the position of the first record (should be 0):
			offset = raf.getFilePointer();
			//Grab first line (first complete record):
			String record = raf.readLine();
			//Tell the world:
			System.out.println("The record offset is: " + offset);
			System.out.println("The record is: " + record);
		} 
		catch (FileNotFoundException e) {
			System.err.println("Could not file file:" );
		} 
		catch (IOException e) {
			System.err.println("Writing error: " + e);
		}
	}
	/**
	 * This class outputs the finished sort to the standard output
	 * and will generate the statistics file (probably?)
	 */
	public void outputDump(){
		
	}
} //end of ParseData class

