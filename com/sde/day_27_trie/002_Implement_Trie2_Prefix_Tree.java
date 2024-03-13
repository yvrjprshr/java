package com.sde.day_27_trie;

class Node{
    Node links[] = new Node[26];

    int cntEndWith = 0;
    int cntPrefix = 0;

    public Node(){
    }

    boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }

    void increaseEnd(){
        cntEndWith++;
    }

    void decreaseEnd(){
        cntEndWith--;
    }

    void increasePrefix(){
        cntPrefix++;
    }

    void decreasePrefix(){
        cntPrefix--;
    }

    int getPrefix(){
        return cntPrefix;
    }

    int getEnd(){
        return cntEndWith;
    }
}

class Trie {
    Node root;
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch) == false){
                node.put(ch, new Node());
            }
            node = node.get(ch);
            node.increasePrefix();
        }

        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(node.containsKey(ch) == false){
                return 0;
            }

            node = node.get(ch);
        }

        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(node.containsKey(ch) == false){
                return 0;
            }

            node = node.get(ch);
        }

        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            node = node.get(ch);
            node.decreasePrefix();
        }

        node.decreaseEnd();
    }
}
