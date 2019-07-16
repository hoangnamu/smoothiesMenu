package com.example.smoothiemenu.object;

import java.io.Serializable;

public class Smoothy implements Serializable {
    private String smoothyName;
    private int smoothyPrice;
    private boolean active;

    public Smoothy(String smoothyName, int smoothyPrice, boolean active) {
        this.smoothyName = smoothyName;
        this.smoothyPrice = smoothyPrice;
        this.active = active;
    }

    public Smoothy(String smoothyName, int smoothyPrice) {
        this.smoothyName = smoothyName;
        this.smoothyPrice = smoothyPrice;
        this.active = false;
    }

    public void setSmoothyName(String name){
        this.smoothyName = name;
    }
    public void setSmoothyPrice(int price){
        this.smoothyPrice = price;
    }
    public void setActive(boolean active){
        this.active = active;
    }

    public String getSmoothyName(){
        return this.smoothyName;
    }
    public int getSmoothyPrice(){
        return this.smoothyPrice;
    }
    public boolean isActive(){
        return this.active;
    }

    @Override
    public String toString() {
        return this.smoothyName +" --> " + this.smoothyPrice;
    }
}
