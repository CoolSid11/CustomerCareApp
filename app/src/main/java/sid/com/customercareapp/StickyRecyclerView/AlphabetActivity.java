package sid.com.customercareapp.StickyRecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import sid.com.customercareapp.Adapter.AlphabetAdapter;
import sid.com.customercareapp.Interface.IOnAlphabetClickListener;
import sid.com.customercareapp.R;


public class AlphabetActivity extends AppCompatActivity {

    RecyclerView recycler_alphabet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        recycler_alphabet   = (RecyclerView)findViewById(R.id.recycler_alphabet);
        AlphabetAdapter alphabetAdapter = new AlphabetAdapter();

        alphabetAdapter.setiOnAlphabetClickListener(new IOnAlphabetClickListener() {
            @Override
            public void onAlphabetClickListener(String alphabet, int position) {
                if(position != -1){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("result",alphabet);
                    setResult(Activity.RESULT_OK,returnIntent);
                    Log.d("*****",alphabet);
                    finish();
                }
            }
        });
        recycler_alphabet.setLayoutManager(new GridLayoutManager(this,4));
        recycler_alphabet.setAdapter(alphabetAdapter);
    }
}
