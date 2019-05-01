package com.mikkelgud.person;

public class CostumerID {
    public int costumerID;
    public CostumerID(){
        this.costumerID = 0;
    }

    public int generateID(){
        System.out.print(costumerID++);
        return costumerID++;
    }
}
