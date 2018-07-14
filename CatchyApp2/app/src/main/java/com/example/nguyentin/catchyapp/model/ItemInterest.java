package com.example.nguyentin.catchyapp.model;

public class ItemInterest {

    private String nameOfItemInterest;
    private int imageOfItemInterest;
    private boolean interest;

    public ItemInterest() {
    }

    public ItemInterest(String nameOfItemInterest, int imageOfItemInterest, boolean interest) {
        this.nameOfItemInterest = nameOfItemInterest;
        this.imageOfItemInterest = imageOfItemInterest;
        this.interest = interest;
    }


    public String getNameOfItemInterest() {
        return nameOfItemInterest;
    }

    public void setNameOfItemInterest(String nameOfItemInterest) {
        this.nameOfItemInterest = nameOfItemInterest;
    }

    public int getImageOfItemInterest() {
        return imageOfItemInterest;
    }

    public void setImageOfItemInterest(int imageOfItemInterest) {
        this.imageOfItemInterest = imageOfItemInterest;
    }

    public boolean isInterest() {
        return interest;
    }

    public void setInterest(boolean interest) {
        this.interest = interest;
    }
}
