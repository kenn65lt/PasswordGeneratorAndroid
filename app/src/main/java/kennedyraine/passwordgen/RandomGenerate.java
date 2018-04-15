package kennedyraine.passwordgen;

import java.util.Random;


public class RandomGenerate {
    public int pWordLength = 0;

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
    private int getPassword(){
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
    private String getUpperLetters(){ return this.upperLetters;}

    //Setter and getter for Special letters
    public void setSpecials(String specials){
        this.specials = specials;
    }
    private String getSpecial(){return this.specials;}

    //Setters and getters for nums
    public void setNum(String nums){
        this.nums = nums;
    }
    private String getNums(){return this.nums;}


    //Merging all the characters together and randomizing it
    public String getMerged() {
        String merged = getNums() + getUpperLetters() + getLowerLetters() + getSpecial();
        StringBuilder chars = new StringBuilder();
        Random rnd = new Random();

        while (chars.length() < getPassword()) { // length of the random string.
            int index = (int) (rnd.nextFloat() * merged.length());
            chars.append(merged.charAt(index));
        }
        return chars.toString();
    }



}



