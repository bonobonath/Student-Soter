//*********************************************************************************************
// CLASS: Sorter (Sorter.java) //
// CSE205 Object Oriented Programming and Data Structures, Summer 2020
// Project Number: 3 //
// AUTHOR: Nathaniel MacKinlay, nmackinl@asu.edu, nmackinl
//******************************************
package proj3;

import java.util.ArrayList;

public class Sorter {
	
	/**
	*  This function takes last element as pivot, places
   		the pivot element at its correct position in sorted
    	array, and places all smaller (smaller than pivot)
   		to left of pivot and all greater elements to right
   		of pivot
	* */

	private static int partion(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
		Student pivot = pList.get(pFromIdx);
		int leftIdx = pFromIdx -1, rightIdx = pToIdx + 1;
		while (leftIdx < rightIdx) {
			++leftIdx;
			while(pList.get(leftIdx).compareTo(pivot) < 0) ++leftIdx;
			--rightIdx;
			while(pList.get(rightIdx).compareTo(pivot) > 0) --rightIdx;
			if (leftIdx < rightIdx) swap(pList, leftIdx, rightIdx);
			
		}return rightIdx;
	}
	
	//This function implements the quicksort algorithim
	private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
		if (pFromIdx >= pToIdx) return;
		int partionIdx = partion(pList, pFromIdx, pToIdx);
		quickSort(pList, pFromIdx, partionIdx);
		quickSort(pList, partionIdx +1, pToIdx);
	}
	
	//applys quickSort publically to allow for use outside class
	public static void sort(ArrayList<Student> pList) {
		quickSort(pList, 0, pList.size()-1);
	}
	
	//uses a place holder temp to switch items within an ArrayList
	public static void swap (ArrayList<Student> pList, int pIdx1, int pIdx2) {
		Student temp = pList.get(pIdx1);
		pList.set(pIdx1, pList.get(pIdx2));
		pList.set(pIdx2, temp);
	}
}
