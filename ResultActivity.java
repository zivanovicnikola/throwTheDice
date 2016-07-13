package nikolazzivanovic.com.randomdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private static final String DEBUG_RESULT_ACTIVITY = "MyApp[ResultActivity]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setRandomNumber();
    }

    private void setRandomNumber() {
        ((TextView) findViewById(R.id.randomNumTextView)).setText("Dice Rolled: " + getNumber());
    }

    private String getNumber() {
        String randomNum = getIntent().getStringExtra(MainActivity.RANDOM_NUMBER_TAG);
        Log.d(DEBUG_RESULT_ACTIVITY, "Extras from intent: " + randomNum);
        return randomNum;
    }
}
