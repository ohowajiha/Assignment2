package pk.edu.uiit.Arid_2585.UI_Controls.assignment2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentCard extends AppCompatActivity {
    DatabaseHelper db;
    TextView S_heading, S_name,S_Data;
    Button signout ,close;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.drawable.background);
        setContentView(R.layout.activity_student_card);
        S_heading=findViewById(R.id.studentHeading);
        S_name=findViewById(R.id.ShowName);
        S_Data=findViewById(R.id.ShowData);
        close=findViewById(R.id.Closebtn);
        signout=findViewById(R.id.Signoutbtn);
        image=findViewById(R.id.studentImage);
        db= new DatabaseHelper(this);

        Intent intent = getIntent();
        String Get_Email=intent.getStringExtra("Emailp");
        S_name.setText(Get_Email);

        Cursor cursor= db.getData(Get_Email);
        StringBuilder stringBuilder=new StringBuilder();
        while (cursor.moveToNext()){
            stringBuilder.append("\n").append(cursor.getString(1)).append("\n").append(cursor.getString(3)).append("\nPassword: ").append(cursor.getString(4)).append("\nCountry: ").append(cursor.getString(6));

        }
        S_Data.setText(stringBuilder);

        signout.setOnClickListener(v -> {
           Intent intentL= new Intent(StudentCard.this,Login.class);
           startActivity(intentL);
           finish();
            Toast.makeText(StudentCard.this,"Logged Out successfully ",Toast.LENGTH_SHORT).show();
        });
        close.setOnClickListener(v -> {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        });

    }
}