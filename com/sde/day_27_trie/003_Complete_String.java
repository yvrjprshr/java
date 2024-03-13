package com.sde.day_27_trie;

class Node{
  Node links[] = new Node[26];
  boolean flag = false;
  boolean containsKey(char ch){
    return links[ch-'a'] != null;
  }

  Node get(char ch){
    return links[ch-'a']; 
  }

  void put(char ch, Node node){
    links[ch-'a'] = node;
  }

  void setEnd(){
    flag = true;
  }

  boolean isEnd(){
    return flag;
  }
}

class Trie{
  Node root;
  public Trie(){
    root = new Node();
  }

  public void insert(String word){
    Node node = root;

    for(int i=0; i<word.length(); i++){
      char ch = word.charAt(i);
      if(node.containsKey(ch) == false){
        node.put(ch, new Node());
      }
      node = node.get(ch);
    }

    node.setEnd();
  }

  public boolean checkPrefix(String word){
    boolean flag = true;
    Node node = root;
    for(int i = 0; i < word.length(); i++){
      char ch = word.charAt(i);
      if(node.containsKey(ch)){
        node = node.get(ch);
        flag = flag & node.isEnd();
      }else{
        return false;
      }
    }
    return flag;
  }
}
class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
    Trie trie = new Trie();

    for(String str: a){
      trie.insert(str);
    }
    
    String longestString = "";

    for(String str: a){
      if(trie.checkPrefix(str)){
        if(longestString.length() < str.length()){
          longestString = str;
        }else if((longestString.length() == str.length()) && longestString.compareTo(str) > 0){
          longestString = str;
        }
      }
    }

    if(longestString.length() == 0) longestString = "None";

    return longestString;
  }
}