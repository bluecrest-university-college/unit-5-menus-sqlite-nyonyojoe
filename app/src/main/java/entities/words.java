package entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.UserDictionary;

public class words extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Words.db";
    public static final String TABLE_NAME = "Words_table";
    public static final String COL_1 = "words";



    public words( Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "  (ID INTEGER PRIMARY KEY AUTOINCREMENT,WORDS TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);

    }
}
