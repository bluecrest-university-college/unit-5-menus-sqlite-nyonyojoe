package eyrastudios.com.autocompletewithsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import entities.words;

public class MainActivity extends AppCompatActivity {

   private AutoCompleteTextView inputWord;
    words mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new words(this);

        inputWord = findViewById(R.id.inputID);

    }
}
