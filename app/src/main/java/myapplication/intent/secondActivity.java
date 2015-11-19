package myapplication.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by com on 2015-11-19.
 */
public class secondActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();

        final int hapValue = (inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0))
                + (inIntent.getIntExtra("Num3", 0) - inIntent.getIntExtra("Num4", 0))
                + (inIntent.getIntExtra("Num5", 0) * inIntent.getIntExtra("Num6", 0))
                + (inIntent.getIntExtra("Num7", 0) / inIntent.getIntExtra("Num8", 0));

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                    outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
