package kennedyraine.passwordgen;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import java.util.ArrayList;

public class Spinners extends AppCompatActivity {




    public int numPercentage = 0;
    public int lowerPercentage = 0;
    public int upperPercentage = 0;
    public int specialsPercentage = 0;



    //Default Constructor
    public Spinners(){
    }
    //Setters and getters for percentages
    public void setNumPercentage(int numPercentage) {
        this.numPercentage = numPercentage;
    }
    public int getNumPercentage() {
        return numPercentage;
    }

    public void setLowerPercentage(int lowerPercentage) {
        this.lowerPercentage = lowerPercentage;
    }
    public int getLowerPercentage() {
        return lowerPercentage;
    }

    public void setSpecialsPercentage(int specialsPercentage) {
        this.specialsPercentage = specialsPercentage;
    }
    public int getSpecialsPercentage() {
        return specialsPercentage;
    }

    public void setUpperPercentage(int upperPercentage) {
        this.upperPercentage = upperPercentage;
    }
    public int getUpperPercentage() {
        return upperPercentage;
    }




}
