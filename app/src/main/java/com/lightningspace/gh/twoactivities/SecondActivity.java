package com.lightningspace.gh.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.lightningspace.gh.twoactivities.MainActivity.extra.REPLY";
    private TextView textView;
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

        mReply = (EditText) findViewById(R.id.reply_text);
    }


    @Override
    public void onRestart() {
        super.onRestart();
        Log.d("LOG_TAG2", "onRestart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("LOG_TAG2", "onResume");
    }

    @Override
    public void onStop () {
        super.onStop();
        Log.d("LOG_TAG2", "onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("LOG_TAG2", "onDestroy");
    }


    public void returnReply (View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK, replyIntent);
        Log.d("LOG_TAG2", "End SecondActivity");
        finish();
    }
}