package eyrastudios.com.autocompletewithsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    EditText correct, misspelt, edtId;
    Button add, update, delete;

    ListView frstword;

    List<Word> data = new ArrayList<>();

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);


        correct = findViewById(R.id.correctID);
        misspelt = findViewById(R.id.misspeltID);
        edtId = findViewById(R.id.ID);
        add = findViewById(R.id.add_ID);
        update = findViewById(R.id.update_ID);
        delete = findViewById(R.id.delete_ID);

        frstword = (ListView) findViewById(R.id.list);




        refreshData();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(Integer.parseInt(edtId.getText().toString()), correct.getText().toString(), misspelt.getText().toString());
                databaseHelper.addData(word);
                refreshData();
                Toast.makeText(getApplicationContext(), "Data added successfully", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(Integer.parseInt(edtId.getText().toString()), correct.getText().toString(), misspelt.getText().toString());
                databaseHelper.updateData(word);
                refreshData();
                Toast.makeText(getApplicationContext(), "Data updated successfully", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word(Integer.parseInt(edtId.getText().toString()), correct.getText().toString(), misspelt.getText().toString());
                databaseHelper.deleteData(word);
                refreshData();
                Toast.makeText(getApplicationContext(), "Data deleted successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }




    private void refreshData(){
        data = databaseHelper.getAllQuiz();
        WordAdapter wordAdapter = new WordAdapter(MainActivity.this, data, edtId, correct, misspelt);
        frstword.setAdapter(wordAdapter);
    }

}
