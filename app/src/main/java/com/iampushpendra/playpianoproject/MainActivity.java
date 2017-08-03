package com.iampushpendra.playpianoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();
    private Context context = null;
    private AlertDialog alertDialog;
    private boolean play = false;

    MediaPlayer mPlay;
    int i = 0;
    String editText = "";
    ImageView play_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        this.setFinishOnTouchOutside(false);

//        setContentView(R.layout.activity_main);
        context = this;
        alertDailog(context);


    }

    private void alertDailog(Context contextAlert) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(contextAlert);

        // set title
        LayoutInflater factory = getLayoutInflater();
        View view = factory.inflate(R.layout.activity_main, null);

        alertDialogBuilder.setView(view);

        final EditText mNotes = (EditText) view.findViewById(R.id.et_notes);

        RelativeLayout close = (RelativeLayout) view.findViewById(R.id.close);
        // Close the Alert Dialog Box
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
            }
        });
        play_stop = (ImageView) view.findViewById(R.id.play_pause);

        mPlay = new MediaPlayer();


        play_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = mNotes.getText().toString().toLowerCase();
                i = 0;
                if (play) {
                    mPlay.release(); // After release(), the object is no longer available.
                    play = false;
                    play_stop.setImageResource(R.drawable.ic_play_button);//set image ic_play_button
                } else if (i < editText.length()) {
                    play = true;
                    String label = ("" + editText.charAt(i) + editText.charAt(i + 1));
                    //getting the Note from editText
                    Log.v(TAG, "--->" + label);
                    switch (label) {
                        case "a1":
                            mPlay = MediaPlayer.create(context, R.raw.a1);
                            break;
                        case "a1s":
                            mPlay = MediaPlayer.create(context, R.raw.a1s);
                            break;
                        case "b1":
                            mPlay = MediaPlayer.create(context, R.raw.b1);
                            break;
                        case "c1":
                            mPlay = MediaPlayer.create(context, R.raw.c1);
                            break;
                        case "c1s":
                            mPlay = MediaPlayer.create(context, R.raw.c1s);
                            break;
                        case "c2":
                            mPlay = MediaPlayer.create(context, R.raw.c2);
                            break;
                        case "d1":
                            mPlay = MediaPlayer.create(context, R.raw.d1);
                            break;
                        case "d1s":
                            mPlay = MediaPlayer.create(context, R.raw.d1s);
                            break;
                        case "e1":
                            mPlay = MediaPlayer.create(context, R.raw.e1);
                            break;
                        case "f1":
                            mPlay = MediaPlayer.create(context, R.raw.f1);
                            break;
                        case "f1s":
                            mPlay = MediaPlayer.create(context, R.raw.f1s);
                            break;
                        case "g1":
                            mPlay = MediaPlayer.create(context, R.raw.g1);
                            break;
                        case "g1s":
                            mPlay = MediaPlayer.create(context, R.raw.g1s);
                            break;

                    }
                    mPlay.start();
                    play_stop.setImageResource(R.drawable.ic_stop_button);
                    mPlay.setOnCompletionListener(listener);
                    i = i + 2;
                }
            }
        });


        // set dialog message
        alertDialogBuilder.setCancelable(false);

        // create alert dialog
        alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }// Alert Dialog end

    //Called when the end of a media source is reached during playback.
    MediaPlayer.OnCompletionListener listener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            Log.v(TAG, "check --->" + mp);
            try {
                mp.release();
            } catch (Exception e) {

            }
            playMusic();
        }
    };

    private void playMusic() {
        // i + 1
        if (i + 1 < editText.length()) {
            if (editText.charAt(i) == '.') {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.v(TAG, "check --->");
                        try {
                            Thread.sleep(100);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    playMusic();
                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                i++;
            } else {
                if (i + 1 < editText.length()) {
                    try {
                        String label = ("" + editText.charAt(i) + editText.charAt(i + 1));

                        Log.v(TAG, "--->" + label);
                        switch (label) {
                            case "a1":
                                mPlay = MediaPlayer.create(context, R.raw.a1);
                                break;
                            case "a1s":
                                mPlay = MediaPlayer.create(context, R.raw.a1s);
                                break;

                            case "b1":
                                mPlay = MediaPlayer.create(context, R.raw.b1);
                                break;
                            case "c1":
                                mPlay = MediaPlayer.create(context, R.raw.c1);
                                break;
                            case "c1s":
                                mPlay = MediaPlayer.create(context, R.raw.c1s);
                                break;
                            case "c2":
                                mPlay = MediaPlayer.create(context, R.raw.c2);
                                break;
                            case "d1":
                                mPlay = MediaPlayer.create(context, R.raw.d1);
                                break;
                            case "d1s":
                                mPlay = MediaPlayer.create(context, R.raw.d1s);
                                break;
                            case "e1":
                                mPlay = MediaPlayer.create(context, R.raw.e1);
                                break;
                            case "f1":
                                mPlay = MediaPlayer.create(context, R.raw.f1);
                                break;
                            case "f1s":
                                mPlay = MediaPlayer.create(context, R.raw.f1s);
                                break;
                            case "g1":
                                mPlay = MediaPlayer.create(context, R.raw.g1);
                                break;
                            case "g1s":
                                mPlay = MediaPlayer.create(context, R.raw.g1s);
                                break;
                        }
                        mPlay.start();
                        mPlay.setOnCompletionListener(listener);
                        i = i + 2;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        } else {
            play_stop.setImageResource(R.drawable.ic_play_button);
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //alertDialog.dismiss();
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlay.release();
    }

}
