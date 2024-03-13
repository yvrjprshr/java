package com.sde.day_27_trie;

class Node{
	Node links[] = new Node[26];
	
	boolean containsKey(char ch){
		return links[ch-'a'] != null;
	}

	Node get(char ch){
		return links[ch-'a'];
	}

	void put(char ch, Node node){
		links[ch-'a'] = node;
	}
}

class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		int cnt = 0;
		Node root = new Node();
		for(int i = 0; i < s.length(); i++){
			Node node = root;
			for(int j = i; j < s.length(); j++){
				char ch = s.charAt(j);
				if(node.containsKey(ch)==false){
					node.put(ch, new Node());
					cnt++;
				}
				node = node.get(ch);
			}
		}

		return cnt + 1;
	}
}