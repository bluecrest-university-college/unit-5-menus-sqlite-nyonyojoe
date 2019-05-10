package eyrastudios.com.autocompletewithsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "word.db";
    public static final String TABLE_NAME = "wordTable";
    public static final String COL1 = "Id";
    public static final String COL2 = "CORRECT";
    public static final String COL3 = "MISSPELT";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "CORRECT TEXT, MISSPELT TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, word.getCorrect());
        contentValues.put(COL3, word.getMisspelt());

        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public int updateData(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, word.getCorrect());
        contentValues.put(COL3, word.getMisspelt());

        return db.update(TABLE_NAME,contentValues,COL1+" =?",new String[]{String.valueOf(word.getId())});
    }

    public void deleteData(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,COL1+" =?",new String[]{String.valueOf(word.getId())});
        db.close();
    }

    public Word getWord(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,new String[]{COL1,COL2,COL3},COL1+"=?",
                new String[]{String.valueOf(id)},null,null,null, null);

        if (cursor != null)
            cursor.moveToFirst();
        return new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
    }

    public List<Word> getAllQuiz(){
        List<Word> frstword = new ArrayList<>();
        String selectQuery = "SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                Word word= new Word();
                word.setId(cursor.getInt(0));
                word.setCorrect(cursor.getString(1));
                word.setMisspelt(cursor.getString(2));

                frstword.add(word);
            }
            while (cursor.moveToNext());
        }
        return  frstword;
    }
}
