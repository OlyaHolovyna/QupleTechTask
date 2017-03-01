package com.android.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private String[] messages = new String[]{"You are lucky today.", "No luck today.", "Sincerely yours..."};
    private TextView messageView;
    private int triesLeft = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.messageView = (TextView) findViewById(R.id.message);

        String text = this.getMessageView();
        this.messageView.setText(text);

//        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.main);
//        RandomMessage message = new RandomMessage();
//        binding.setVariable(BR.messageView, message);

    }

    public String getMessageView() {
        int i = new Random().nextInt(3);
        return messages[i];
    }

    public void onAgainClick(View view) {
        String text = this.getMessageView();

        if(--triesLeft > 0)
            this.messageView.setText(text);
        else
            this.messageView.setText("Sorry, no more prophecies today.");
    }
}
