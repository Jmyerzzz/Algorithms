import java.io.*;
import java.util.ArrayList;

public class Select {

    public static void main(String[] args) throws Exception {

      	BufferedReader stdIn = new java.io.BufferedReader ( new java.io.InputStreamReader ( System.in ) );
        String s = stdIn.readLine();// grab the first line (or null, if end-of-file)
        ArrayList<Integer> numList = new ArrayList<Integer>();

        while ( s != null ) { // while not end-of-file
            numList.add(Integer.parseInt(s));
            s = stdIn.readLine(); // grab the next line (or null)
        }
				findKthLargest(numList, Integer.parseInt(args[0]));
		}

    public static int findKthLargest (ArrayList<Integer> numList, int k) {
			if (k < 1 || numList == null){
				throw new IllegalArgumentException();
			}

			int pivotIndex = (int)(Math.random() * numList.size() -1);
			swapAtIndex(numList, pivotIndex, numList.size() - 1);
			pivotIndex = partition(numList, 0, numList.size() - 1);

			if ((k-1) < pivotIndex) {

				return findKthLargest(numList.sublist(0, pivotIndex), k);

			} else if ((k-1) > pivotIndex) {

				return findKthLargest(numList.sublist(pivotIndex + 1, numList.size() - 1), (k-1)-pivotIndex);

			} else {
				return numList.get(k-1);
			}

    }

		private static int partition (ArrayList<Integer> numList, int begin, int end) {
          int pivotVal = numList.get(end),
              swapIndex  = begin;

          for (int j = begin; j < end; j++) {
              if (numList.get(j) <= pivotVal) {
                  swapAtIndex(numList, swapIndex, j);
                  swapIndex++;
              }
          }

          swapAtIndex(numList, swapIndex, end);
          return swapIndex;
      }

    private static void swapAtIndex (ArrayList<Integer> arr, int p1, int p2) {
        int temp = arr.get(p1);
        arr.set(p1, arr.get(p2));
        arr.set(p2, temp);
    }

}
