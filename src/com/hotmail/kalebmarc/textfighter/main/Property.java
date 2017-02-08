package com.hotmail.kalebmarc.textfighter.main;

public class Property {

    private String name;
    private String desc;
    private Type type;
    private int pricePerSqFt;
    private int levelNeeded;
    private final int MAX_SQ_FT = 100;//TODO Change this later. Not sure how the SqFt thing is going to work yet.

    private int sqFtOwned;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public String getDesc(){
        return this.desc;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }
    public void setPricePerSqFt(int pricePerSqFt){
        this.pricePerSqFt = pricePerSqFt;
    }
    public int getPricePerSqFt(){
        return this.pricePerSqFt;
    }
    public void setLevelNeeded(int levelNeeded){
        this.levelNeeded = levelNeeded;
    }
    public int getLevelNeeded(){
        return this.levelNeeded;
    }
    public void setSqFtOwned(int sqFtOwned){
        if (sqFtOwned > MAX_SQ_FT){
            this.sqFtOwned = MAX_SQ_FT;
        } else {
            this.sqFtOwned = sqFtOwned;
        }
    }
    public int getSqFtOwned(){
        return this.sqFtOwned;
    }
    public static void buyProperty(){

    }

    public enum Type{
        CROP_FIELD,
        ORCHARD,
        RIVER;

        @Override
        public String toString() {
            switch(super.toString()){
                case "CROP_FIELD":
                    return "Crop Field";
                case "ORCHARD":
                    return "Orchard";
                case "RIVER":
                    return "River";
                default:
                    Handle.error("Unknown Property Type: " + super.toString());
                    return null;
            }
        }
    }
}

