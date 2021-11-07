package pk.edu.uiit.Arid_2585.UI_Controls.assignment2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView Heading, expertise, skills, result, single;
    EditText Username;
    ImageButton imageButton;
    ImageView imageview;
    RadioGroup radioGroup;
    RadioButton SelectedRadioButton, R1, R2;
    CheckBox ck1, ck2, ck3;
    SeekBar seekBar;
    ToggleButton toggleButton;
    Button button;
    String checkboxresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Heading = findViewById(R.id.uiheading);
        Username = findViewById(R.id.edittextui);
        imageButton = findViewById(R.id.imagebutton);
        imageview = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radiogroup);
        R1 = findViewById(R.id.radioButton1);
        R2 = findViewById(R.id.radioButton2);
        ck1 = findViewById(R.id.checkbox1);
        ck2 = findViewById(R.id.checkbox2);
        ck3 = findViewById(R.id.checkbox3);
        expertise = findViewById(R.id.expertiseid);
        skills = findViewById(R.id.cstextview);
        seekBar = findViewById(R.id.seekbarid);
        result = findViewById(R.id.resulttv);
        single = findViewById(R.id.Singletxt);
        toggleButton = findViewById(R.id.togglebtnid);
        button = findViewById(R.id.signoutbtnid);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int i = 0;

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i = progress;
                result.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        toggleButton.setOnClickListener(v -> {
            String result2 = toggleButton.getText().toString();
            Toast.makeText(MainActivity.this, result2, Toast.LENGTH_SHORT).show();
        });


        button.setOnClickListener(v -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });
    }

    public void CheckBtn(View view) {
        if (ck1.isChecked()) {
            checkboxresult = ck1.getText().toString();
        }
        if (ck2.isChecked()) {
            checkboxresult += ck2.getText().toString();
        }
        if (ck3.isChecked()) {
            checkboxresult += ck3.getText().toString();
        }
        Toast.makeText(MainActivity.this, checkboxresult, Toast.LENGTH_SHORT).show();
    }

    public void select(View view) {

        int radioID = radioGroup.getCheckedRadioButtonId();
        SelectedRadioButton = findViewById(radioID);
        Toast.makeText(MainActivity.this, SelectedRadioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
