package kennedyraine.passwordgen;

import java.util.Random;


public class RandomGenerate extends MainActivity {
    public int pWordLength = 0;
    public int characterCount = 0;

    String lowerCase = "";
    String upperLetters = "";
    String nums = "";
    String specials = "";

    //constructors

    public RandomGenerate() {
    }

    public void setPassword(int pWordLength){
        this.pWordLength = pWordLength;
    }
    public int getPassword(){
        return this.pWordLength;
    }

    //Setter for lower letters
    public void setLowers(String lowerCase){
        this.lowerCase = lowerCase;
    }
    public String getLowerLetters(){ return this.lowerCase; }

    //Setter and getter for upper letters
    public void setUpperLetters(String upperLetters){
        this.upperLetters = upperLetters;
    }
    public String getUpperLetters(){ return this.upperLetters;}

    //Setter and getter for Special letters
    public void setSpecials(String specials){
        this.specials = specials;
    }
    public String getSpecial(){return this.specials;}

    //Setters and getters for nums
    public void setNum(String nums){
        this.nums = nums;
    }
    public String getNums(){return this.nums;}


    public String getMerged() {
//        String merged = getLowerLetters() + getSpecial() + getUpperLetters() + getNums();
        String merged = nums + upperLetters + lowerCase+ getSpecial();
        StringBuilder chars = new StringBuilder();
        Random rnd = new Random();

        while (chars.length() < getPassword()) { // length of the random string.
            int index = (int) (rnd.nextFloat() * merged.length());
            chars.append(merged.charAt(index));
        }
        return chars.toString();
    }



}



