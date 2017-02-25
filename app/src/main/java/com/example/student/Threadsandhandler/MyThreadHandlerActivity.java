package com.example.student.Threadsandhandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.androidprograms.R;

public class MyThreadHandlerActivity extends AppCompatActivity {
    private TextView threadHandlerTextView;
    private EditText threadHandlerEditText;
    private Button threadHandlerButton;

    /*//Handler for receiving empty message from separate thread
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            threadHandlerTextView.setText("");
        }
    };*/

    //Handler for receiving some message from separate thread
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String s = bundle.getString("message");
            threadHandlerTextView.setText(s);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_thread_handler);

        //find view by id
        threadHandlerTextView = (TextView) findViewById(R.id.thread_handler_textview);
        threadHandlerEditText = (EditText) findViewById(R.id.thread_handler_edittext);
        threadHandlerButton = (Button) findViewById(R.id.thread_handler_button);
/*
        //OnClickListener for main thread
        threadHandlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long endTime = System.currentTimeMillis() + 5 * 1000;

                //
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }//end of while()

                //After 5 seconds, the following message will be shown
                threadHandlerTextView.setText("Button is clicked");

            }//end of onClick()
        });*/



        /*//onClickListener for separate thread(sending empty message)
        threadHandlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis() + 5 * 1000;

                        //
                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime - System.currentTimeMillis());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }//end of while()
                        handler.sendEmptyMessage(0);
                    }//end of run()

                };//end of runnable

                //Creating object of thread class and starting a new thread
                Thread thread = new Thread(runnable);
                thread.start();

            }//end of onClick
        });//end of anonymous OnClickListener*/


        //onClickListener for separate thread(sending empty message)
        threadHandlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        long endTime = System.currentTimeMillis() + 5 * 1000;

                        //
                        while (System.currentTimeMillis() < endTime) {
                            synchronized (this) {
                                try {
                                    wait(endTime - System.currentTimeMillis());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }//end of while()

                        //sending some message to handler through separate thread
                        Message message = handler.obtainMessage();
                        Bundle bundle = new Bundle();
                        bundle.putString("message", "This is message");
                        message.setData(bundle);
                        handler.sendMessage(message);

                    }//end of run()

                };//end of runnable

                //Creating object of thread class and starting a new thread
                Thread thread = new Thread(runnable);
                thread.start();

            }//end of onClick
        });//end of anonymous OnClickListener

    }//end of onCreate()
}
