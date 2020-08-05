 //*********************************************************************************************
// CLASS: Searcher (Searcher.java) //
// CSE205 Object Oriented Programming and Data Structures, Summer 2020
// Project Number: 3 //
// AUTHOR: Nathaniel MacKinlay, nmackinl@asu.edu, nmackinl
//*********************************************************************************************


package proj3;

import java.util.ArrayList;

public class Searcher {
	
	/**
	* Implements a simple binary search to find a Student object within an ArrayList
	* */

		public static int search(ArrayList<Student> pList, String pKey) {
			int low = 0, high = pList.size() -1;
			while (low <= high) {
				int middle = (low + high) / 2;
				int compare = pKey.compareTo(pList.get(middle).getLastName());
				if (compare == 0) {
					return middle;
				} else if (compare < 0) {
					high = middle - 1;
				} else {
					low = middle +1;
				}
			}  return -1; //not Found
		}
}
