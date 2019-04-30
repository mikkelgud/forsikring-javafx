package com.mikkelgud.person;

public class CostumerID {
    public int costumerID;
    public CostumerID(int costumerID){
        this.costumerID = 0;
    }

    public int generateID(){
        return costumerID++;
    }
}
