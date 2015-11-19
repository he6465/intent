package myapplication.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    RadioGroup rGroup;
    EditText edtNum1;
    EditText edtNum2;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        edtNum1 = (EditText) findViewById(R.id.edtNum1);
        edtNum2 = (EditText) findViewById(R.id.edtNum2);
        btnCalc = (Button) findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.btnAdd:
                        Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                        intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                        intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                        intent.putExtra("Num3", 0);
                        intent.putExtra("Num4", 0);
                        intent.putExtra("Num5", 0);
                        intent.putExtra("Num6", 0);
                        intent.putExtra("Num7", 0);
                        intent.putExtra("Num8", 1);
                        startActivityForResult(intent, 0);
                        break;
                    case R.id.btnSub:
                        Intent ntent = new Intent(getApplicationContext(), secondActivity.class);
                        ntent.putExtra("Num3", Integer.parseInt(edtNum1.getText().toString()));
                        ntent.putExtra("Num4", Integer.parseInt(edtNum2.getText().toString()));
                        ntent.putExtra("Num1", 0);
                        ntent.putExtra("Num2", 0);
                        ntent.putExtra("Num5", 0);
                        ntent.putExtra("Num6", 0);
                        ntent.putExtra("Num7", 0);
                        ntent.putExtra("Num8", 1);
                        startActivityForResult(ntent, 0);
                        break;
                    case R.id.btnMul:
                        Intent tent = new Intent(getApplicationContext(), secondActivity.class);
                        tent.putExtra("Num5", Integer.parseInt(edtNum1.getText().toString()));
                        tent.putExtra("Num6", Integer.parseInt(edtNum2.getText().toString()));
                        tent.putExtra("Num3", 0);
                        tent.putExtra("Num4", 0);
                        tent.putExtra("Num1", 0);
                        tent.putExtra("Num2", 0);
                        tent.putExtra("Num7", 0);
                        tent.putExtra("Num8", 1);
                        startActivityForResult(tent, 0);
                        break;
                    case R.id.btnDiv:
                        Intent nt = new Intent(getApplicationContext(), secondActivity.class);
                        nt.putExtra("Num7", Integer.parseInt(edtNum1.getText().toString()));
                        nt.putExtra("Num8", Integer.parseInt(edtNum2.getText().toString()));
                        nt.putExtra("Num3", 0);
                        nt.putExtra("Num4", 0);
                        nt.putExtra("Num5", 0);
                        nt.putExtra("Num6", 0);
                        nt.putExtra("Num1", 0);
                        nt.putExtra("Num2", 0);
                        startActivityForResult(nt, 0);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
