package pk.edu.uiit.Arid_2585.UI_Controls.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    DatabaseHelper db;
    TextView login, name, password;
    EditText Email, pass;
    Button
            Loginn, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        login = findViewById(R.id.loginHeading);
        name = findViewById(R.id.emailHeading);
        password = findViewById(R.id.passHeading);
        Email = findViewById(R.id.editTextemail);
        pass = findViewById(R.id.editTextPassword);
        Loginn = findViewById(R.id.loginbtn);
        back = findViewById(R.id.signupbtn);
        back.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SignUpform.class);
            startActivity(intent);
        });
        Loginn.setOnClickListener(v -> {
            String NewEmail = Email.getText().toString();
            String Newpass = pass.getText().toString();
            if (NewEmail.equals("") || Newpass.equals(""))
                Toast.makeText(Login.this, "Please Enter All the fields", Toast.LENGTH_SHORT).show();
            else {
                Boolean checkusernamepass = db.checkusernamepassword(NewEmail, Newpass);
                if ( checkusernamepass) {
                    Toast.makeText(Login.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(), StudentCard.class);
                    intent1.putExtra("Emailp",NewEmail);
                    startActivity(intent1);

                } else {
                    Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}




