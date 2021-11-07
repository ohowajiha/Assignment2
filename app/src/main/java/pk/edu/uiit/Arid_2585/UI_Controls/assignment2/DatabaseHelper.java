package pk.edu.uiit.Arid_2585.UI_Controls.assignment2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Database_Name="Assignment2Database.db";
    private static final String Table_Name="Register";
    private static final int db_version=1;

    public DatabaseHelper(Context context) {
        super(context, Database_Name,null,db_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table if not exists "+ Table_Name +"(user_ID integer Primary key Autoincrement,Name Varchar, Email Varchar,Phone integer,Password Varchar ,ConfirmPassword Varchar,Country Varchar)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if EXISTS "+ Table_Name);
        onCreate(db);
    }



    public boolean insertData( String Name, String email, String phone, String pass,String c_pass, String country) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Email",email);
        contentValues.put("Phone",phone);
        contentValues.put("Password",pass);
        contentValues.put("ConfirmPassword",c_pass);
        contentValues.put("Country",country);
        long result = db.insert(Table_Name,null,contentValues);
        return result != -1;
    }
    public Boolean checkemail(String email) {
        SQLiteDatabase db= this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("Select * from " + Table_Name + " Where Email = ?  ", new String[] {email});
        return cursor.getCount() > 0;
    }

    public Boolean checkusernamepassword(String email,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor cursor=db.rawQuery("Select * from "+ Table_Name+ " Where Email= ? and Password=? ",new String[]{email,password});
        return cursor.getCount() > 0;
    }
    public Cursor getData(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.rawQuery("Select * from "+ Table_Name +" Where Email=?", new String[] {email});
    }
}

