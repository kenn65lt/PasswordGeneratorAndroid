package kennedyraine.passwordgen;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Object;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView txt, pWordTxt;
    Button btn, copyBtn;

//    int passwordLength = 0;
//    String spinnerText = "";
int passwordLength;
    CheckBox numsCheck;
    CheckBox specialsCheck;
    CheckBox upperCheck;
    CheckBox lowerCheck;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.TextView);
        btn = (Button) findViewById(R.id.randomBtn);
        Spinner spinner = (Spinner) findViewById(R.id.password_length);
        RandomGenerate generate = new RandomGenerate();


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.password_length, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);




        btn.setOnClickListener(new View.OnClickListener() {
            Spinner spin = (Spinner) findViewById(R.id.password_length);


            @Override
            public void onClick(View view) {
                RandomGenerate generate = new RandomGenerate();
                numsCheck = (CheckBox) findViewById(R.id.numCheck);
                if (numsCheck.isChecked()){
                    String nums = "1234567890";
                    generate.setNum(nums);
                } else{
                    generate.setNum("");
                }
                upperCheck = (CheckBox) findViewById(R.id.upperCheck);
                if (upperCheck.isChecked()){
                    String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    generate.setUpperLetters(upperLetters);
                }else{
                    generate.setSpecials("");
                }
                lowerCheck = (CheckBox) findViewById(R.id.lowerCheck);
                if (lowerCheck.isChecked()){
                    String lowerCase = "abcdefghijklmnopqrstuvwxyz";
                    generate.setLowers(lowerCase);
                }else{
                    generate.setLowers("");
                }
                specialsCheck = (CheckBox) findViewById(R.id.specialsCheck);
                if (specialsCheck.isChecked()){
                    String specials = "!@#$%&*()_+-=[]|,./?><";
                    generate.setSpecials(specials);
                }else{
                    generate.setSpecials("");
                }

                String passwordString = spin.getSelectedItem().toString();
                //Parsing string password to int
                 passwordLength = Integer.parseInt(passwordString);
                 generate.setPassword(passwordLength);

                 txt.setText(generate.getMerged());
//                 txt.setText(generate.getMerged());

            }
        });


    }




}