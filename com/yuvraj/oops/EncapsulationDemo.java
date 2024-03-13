package com.yuvraj.oops;

// fully encapsulated class -> all properties are private and have getters and setters

class College{
    int rooms;
    String name;

    public void setRooms(int rooms){
        this.rooms = rooms;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRooms(){
        return this.rooms;
    }

    public String getName(){
        return this.name;
    }
    
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        
    }
}
