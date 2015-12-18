/*
So running this 3 times might output: 
%	java	ChooseServer	Seattle
Sea-2 Sea-1 Sea-3 Dal-1	Dal-3 Dal-2	Chi-2 Chi-3	Chi-1
%	java	ChooseServer	Seattle
Sea-1 Sea-3	Sea-2 Dal-3	Dal-2 Dal-1	Chi-1 Chi-2	Chi-3
%	java	ChooseServer	Seattle
Sea-3 Sea-1	Sea-2 Dal-1	Dal-2 Dal-3	Chi-1 Chi-3	Chi-2
*/

/* Author: Melissa Auclaire
 * Email: rhapsody.ai@gmail.com
 * 
 * Note: If run in Eclipse this program requires you to pass in an argument in the run configurations menu.
 * Click Run->Run Configurations->Arguments (Tab) and pass in an argument of type String via the 'program arguments' dialog prompt.
 */

import java.lang.reflect.Array;
import java.util.Random;

public class WriteBlobSequence {
	static int[] array = {1,2,3};
	static boolean[] blobs =  {false,false,false}; //Seattle, Chicago, Dallas

	final static String SEATTLE = "Seattle";
	final static String CHICAGO = "Chicago";
	final static String DALLAS = "Dallas";
	
	public static void main(String	args[]) {

		//Initialize
		int blobIndex;
		Random rand = new Random();
		String dataCenterName = args[0];
		
		//Print First Region
		printBlobRegion(dataCenterName);
		
		//Print Second Region
		blobIndex = rand.nextInt(3);
		while(blobs[blobIndex] == true) {
			blobIndex = rand.nextInt(3);
		}
		dataCenterName = getBlobString(blobIndex);
		printBlobRegion(dataCenterName);
		
		//Print Third Region
		blobIndex = rand.nextInt(3);
		while(blobs[blobIndex] == true) {
			blobIndex = rand.nextInt(3);
		}
		
		dataCenterName = getBlobString(blobIndex);
		printBlobRegion(dataCenterName);
	}
	
	public static int[] shuffleArray(int[] a) {
		Random rnd = new Random();
		for(int i = 0; i < a.length; i++) {
			int temp = a[i];
			int swapIndex = rnd.nextInt(a.length);
			a[i] = a[swapIndex];
			a[swapIndex] = temp;
		}
		return a;
	}
	
	public static void printBlobStorage(String dcName) {
		if(dcName.equals(SEATTLE)) {
			for(int i = 0; i < array.length; i++) {
				if(array[i] == 1)
					System.out.print("Sea-1 ");
				if(array[i] == 2)
					System.out.print("Sea-2 ");
				if(array[i] == 3)
					System.out.print("Sea-3 ");
			}
		}
		else if(dcName.equals(CHICAGO)) {
			for(int i = 0; i < array.length; i++) {
				if(array[i] == 1)
					System.out.print("Chi-1 ");
				if(array[i] == 2)
					System.out.print("Chi-2 ");
				if(array[i] == 3)
					System.out.print("Chi-3 ");
			}
		}
		
		else if(dcName.equals(DALLAS)) {
			for(int i = 0; i < array.length; i++) {
				if(array[i] == 1)
					System.out.print("Dal-1 ");
				if(array[i] == 2)
					System.out.print("Dal-2 ");
				if(array[i] == 3)
					System.out.print("Dal-3 ");
			}
		}
	}
	
	public static void updateBlobIndices(String s) {
		if(s.equals(SEATTLE))
			blobs[0] = true;
		else if(s.equals(CHICAGO))
			blobs[1] = true;
		else if(s.equals(DALLAS))
			blobs[2] = true;
	}

	public static String getBlobString(int i) {
		if(i== 0)
			return SEATTLE;
		else if(i == 1)
			return CHICAGO;
		else if(i == 2)
			return DALLAS;
		return "";
	}
	
	public static void printBlobRegion(String dcName) {
		shuffleArray(array);
		printBlobStorage(dcName);
		updateBlobIndices(dcName);
	}
}