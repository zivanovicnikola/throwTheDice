package nikolazzivanovic.com.randomdice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String RANDOM_NUMBER_TAG = "randomNumberTag";
    private static final String DEBUG_MAIN_ACTIVITY = "MyApp[MainActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSeekBarListener();
    }

    private int getRandomNumber() {
        int maxNumber = ((SeekBar) findViewById(R.id.seekBar)).getProgress() + 1;
        Log.d(DEBUG_MAIN_ACTIVITY, "maxNumber: " + Integer.toString(maxNumber));
        Random r = new Random();
        int randomNum = r.nextInt(maxNumber + 1);
        Log.d(DEBUG_MAIN_ACTIVITY, "randomNumber: " + Integer.toString(randomNum));

        return randomNum;
    }

    private void setSeekBarListener() {
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView textView = (TextView) findViewById(R.id.diceNumberTextView);
                textView.setText(Integer.toString(progress + 1));

            }
        });
    }

    public void buttonOnClick(View view) {
        Log.d(DEBUG_MAIN_ACTIVITY, "button clicked");
        final int maxDice = ((SeekBar) findViewById(R.id.seekBar)).getProgress();
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra(RANDOM_NUMBER_TAG, Integer.toString(getRandomNumber()));
        startActivity(intent);
    }
}