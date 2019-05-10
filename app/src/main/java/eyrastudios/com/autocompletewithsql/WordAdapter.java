package eyrastudios.com.autocompletewithsql;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends BaseAdapter {
    Activity activity;
    List<Word> frstword;
    LayoutInflater inflater;
    EditText edtId, questn, answer;

    public WordAdapter(Activity activity, List<Word> frstquiz, EditText edtId, EditText questn, EditText answer) {
        this.activity = activity;
        this.frstword = frstquiz;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.edtId = edtId;
        this.questn = questn;
        this.answer = answer;
    }

    @Override
    public int getCount() {
        return frstword.size();
    }

    @Override
    public Object getItem(int position) {
        return frstword.get(position);
    }

    @Override
    public long getItemId(int position) {
        return frstword.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.row,null);
        final TextView txtRowId, txtQuestn, txtAnswer;

        txtRowId = (TextView)rowView.findViewById(R.id.txtRowId);
        txtQuestn = (TextView)rowView.findViewById(R.id.txtRowQunts);
        txtAnswer = (TextView)rowView.findViewById(R.id.txtRowAnswer);

        txtRowId.setText(""+frstword.get(position).getId());
        txtQuestn.setText(""+frstword.get(position).getCorrect());
        txtAnswer.setText(""+frstword.get(position).getMisspelt());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtId.setText(""+txtRowId.getText());
                questn.setText(""+txtQuestn.getText());
                answer.setText(""+txtAnswer.getText());

            }
        });
        return rowView;
    }
}
