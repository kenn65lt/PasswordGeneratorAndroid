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
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Object;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    TextView txt;
    Button btn;


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

        ImageButton clipBtn = (ImageButton) findViewById(R.id.clipboardBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            Spinner spin = (Spinner) findViewById(R.id.password_length);
            @Override
            public void onClick(View view) {

                //Checking the chekbox and setting values for it. Ifs are better to use in this case rather than using
                //Switch statements
                RandomGenerate generate = new RandomGenerate();
                String passwordString = spin.getSelectedItem().toString();
                //Parsing string password to int
                passwordLength = Integer.parseInt(passwordString);
                generate.setPassword(passwordLength);

                numsCheck = (CheckBox) findViewById(R.id.numCheck);
                if (numsCheck.isChecked()){
                    String nums = "1234567890";
                    generate.setNum(nums);
                }
                upperCheck = (CheckBox) findViewById(R.id.upperCheck);
                if (upperCheck.isChecked()){
                    String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    generate.setUpperLetters(upperLetters);
                }
                lowerCheck = (CheckBox) findViewById(R.id.lowerCheck);
                if (lowerCheck.isChecked()){
                    String lowerCase = "abcdefghijklmnopqrstuvwxyz";
                    generate.setLowers(lowerCase);
                }
                specialsCheck = (CheckBox) findViewById(R.id.specialsCheck);
                if (specialsCheck.isChecked()){
                    String specials = "!@#$%&*()_+-=[]|,./?><";
                    generate.setSpecials(specials);
                }


                //If the checkboxes are not checked then tell user it is unchecked.
                if(!numsCheck.isChecked() && !upperCheck.isChecked() &&
                        !lowerCheck.isChecked() && !specialsCheck.isChecked() ){
                    txt.setText("None of the options are selected.");
                } else {
                    txt.setText(generate.getMerged());
                }
            }
        });

        //Clipboard
        clipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code to Copy the content of Text View to the Clip board.
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("simple text", txt.getText());
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getApplicationContext(), "Password Copied to Clipboard",
                        Toast.LENGTH_LONG).show();

                //For pasting purposes/debugging
//                ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
//                String pasteData = item.getText().toString();
//                btn.setText(pasteData);
            }
        });


    }




}