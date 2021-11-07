package pk.edu.uiit.Arid_2585.UI_Controls.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpform extends AppCompatActivity {

    DatabaseHelper db;
    TextView R_heading;
    EditText Name, Email, Phone, Pass, ConfirmPass, Country;
    Button register, reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_upform);

        db = new DatabaseHelper(this);
        Name = findViewById(R.id.eName);
        Email = findViewById(R.id.eEmail);
        Phone = findViewById(R.id.ePhone);
        Pass = findViewById(R.id.ePassword);
        ConfirmPass = findViewById(R.id.eConfirmPassword);
        Country = findViewById(R.id.eCountry);
        register = findViewById(R.id.btnSignup);
        reset = findViewById(R.id.btnsignin);
        R_heading = findViewById(R.id.registerHeading);

        reset.setOnClickListener(v -> {
            Name.setText("");
            Email.setText("");
            Phone.setText("");
            Pass.setText("");
            ConfirmPass.setText("");
            Country.setText("");
            Intent intent= new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
        });
        register.setOnClickListener(v -> {
            String newName = Name.getText().toString();
            String newEmail = Email.getText().toString();
            String newPhone = Phone.getText().toString();
            String newPass = Pass.getText().toString();
            String newC_pass = ConfirmPass.getText().toString();
            String newCountry = Country.getText().toString();
            if (newEmail.isEmpty() || newPass.isEmpty()|| newC_pass.isEmpty())
                Toast.makeText(SignUpform.this, "Please Enter Email or password ", Toast.LENGTH_SHORT).show();
             else {
                if (newPass.equals(newC_pass)) {
                    Boolean Checkemail = db.checkemail(newEmail);
                    if (!Checkemail) {
                        boolean insert = db.insertData(newName, newEmail, newPhone, newPass,newC_pass, newCountry);
                        if (insert) {
                            Toast.makeText(SignUpform.this, "User registered Successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(SignUpform.this, "Registration Failed  ", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(SignUpform.this, "Email Already Exists Please Sign in", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUpform.this, "Passwords Not Matching", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
