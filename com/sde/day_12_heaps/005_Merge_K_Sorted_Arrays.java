package com.sde.day_12_heaps;
import java.util.* ;
import java.util.ArrayList;

class Solution 
{
	static class CustomeComparator implements Comparator<int[]>{
		public int compare(int a[], int b[]){
			return a[0]-b[0];
		}
	}
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		// Write your code here.
		PriorityQueue<int[]> pq = new PriorityQueue<>(new CustomeComparator());
		ArrayList<Integer> ans = new ArrayList<>();

		// insert starting points from each array
		for(int i=0; i<kArrays.size(); i++){
			pq.add(new int[]{kArrays.get(i).get(0), i, 0});
		}

		while (pq.isEmpty()==false) {
			int[] el = pq.poll();
			ans.add(el[0]);
			if(kArrays.get(el[1]).size() > el[2]+1){
				pq.add(new int[]{kArrays.get(el[1]).get(el[2]+1), el[1], el[2]+1});
			}
		}

		return ans;
	}
}
