package com.gaurav.datastructures.others;

import java.util.Arrays;

//code illustrating shallow copy 
class Shallow {

	private int[] data;

	// makes a shallow copy of values
	public Shallow(int[] values) {
		data = values;
	}

	public void showData() {
		System.out.println(Arrays.toString(data));
	}
}

public class PriShallowCopy {

	public static void main(String[] args) {
		int[] vals = { 3, 7, 9 }; //original array
		Shallow shallow = new Shallow(vals);
		shallow.showData(); // prints out [3, 7, 9]
		vals[0] = 13;
		shallow.showData(); // prints out [13, 7, 9]

		// Very confusing, because we didn't
		// intentionally change anything about
		// the object e refers to.

	}

}
