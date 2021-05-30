package com.lightningspace.gh.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.lightningspace.gh.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    private TextView mReply;
    public  static final int TEXT_REQUEST =1;
    private TextView mReplyHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.editText_main);
        mReply = (TextView) findViewById(R.id.reply_message);
       mReplyHead = (TextView) findViewById(R.id.reply_message);

        mReply.setText(mReply.getText().toString());
        mReplyHead.setText(mReplyHead.getText().toString());
    }

    public void launchSecondActivity (View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d(TAG, "launchSecondActivity:Button CLICK! ");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHead.setVisibility(View.VISIBLE);
                mReply.setText(reply);
                mReply.setVisibility(View.VISIBLE);
            }
        }
    }
}