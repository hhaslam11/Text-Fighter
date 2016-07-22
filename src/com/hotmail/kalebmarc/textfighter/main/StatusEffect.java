package com.hotmail.kalebmarc.textfighter.main;

public class StatusEffect {
    //Will be used for Stats
    //https://github.com/hhaslam11/Text-Fighter/issues/16
    public static enum type{
        HEALTH, STRENGTH, STANIMA, ACCURACY, LUCK;

        @Override
        public String toString() {
            String effectString = super.toString();
            return effectString.substring(0, 1) + effectString.substring(1).toLowerCase();
        }
    }
}

