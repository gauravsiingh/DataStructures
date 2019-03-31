package com.gaurav.datastructures.impl;

import java.util.Arrays;

//Code explaining deep copy 
class Deep {

	private int[] data;

	// altered to make a deep copy of values
	public Deep(int[] values) {
		data = new int[values.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = values[i];
		}
	}

	public void showData() {
		System.out.println(Arrays.toString(data));
	}
}

public class PriDeepCopy {

	public static void main(String[] args) {
		int[] vals = { 3, 7, 9 }; // original array
		Deep deep = new Deep(vals);
		deep.showData(); // prints out [3, 7, 9]
		vals[0] = 13;
		deep.showData(); // prints out [3, 7, 9]

		// changes in array values will not be
		// shown in data values.

	}

}
