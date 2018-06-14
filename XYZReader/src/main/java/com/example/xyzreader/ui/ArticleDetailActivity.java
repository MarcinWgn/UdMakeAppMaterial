package com.example.xyzreader.ui;
import android.os.Build;
import android.os.Bundle;
import android.support.transition.Slide;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;

import com.example.xyzreader.R;
import com.example.xyzreader.data.ItemsContract;

public class ArticleDetailActivity extends AppCompatActivity {

    public static final String TAG = ArticleDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        if (savedInstanceState == null) {
            if (getIntent() != null && getIntent().getData() != null) {
                long mStartId = ItemsContract.Items.getItemId(getIntent().getData());

                Log.d(TAG,"position: "+ String.valueOf(mStartId));

                ArticleDetailFragment fragment = ArticleDetailFragment.newInstance(mStartId);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fr_container,fragment)
                        .commit();
            }
        }
    }
}
