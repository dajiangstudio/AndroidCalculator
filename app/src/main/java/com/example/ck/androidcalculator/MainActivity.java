package com.example.ck.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayView = null;
    Button btClear = null;
    Button btNum0 = null;
    Button btNum1 = null;
    Button btNum2 = null;
    Button btNum3 = null;
    Button btNum4 = null;
    Button btNum5 = null;
    Button btNum6 = null;
    Button btNum7 = null;
    Button btNum8 = null;
    Button btNum9 = null;
    Button btDiv = null;
    Button btMul = null;
    Button btSub = null;
    Button btDot = null;
    Button btEqual = null;
    Button btAdd = null;

    String enterNumber = null;
    String firstNumber = null;
    String secondNumber = null;
    String operator = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_activity_main);
        findView();
    }

    public void findView() {
        displayView = (TextView) findViewById(R.id.displayView);
        btClear = (Button) findViewById(R.id.btClear);
        btNum0 = (Button) findViewById(R.id.btNum0);
        btNum1 = (Button) findViewById(R.id.btNum1);
        btNum2 = (Button) findViewById(R.id.btNum2);
        btNum3 = (Button) findViewById(R.id.btNum3);
        btNum4 = (Button) findViewById(R.id.btNum4);
        btNum5 = (Button) findViewById(R.id.btNum5);
        btNum6 = (Button) findViewById(R.id.btNum6);
        btNum7 = (Button) findViewById(R.id.btNum7);
        btNum8 = (Button) findViewById(R.id.btNum8);
        btNum9 = (Button) findViewById(R.id.btNum9);
        btDiv = (Button) findViewById(R.id.btDiv);
        btMul = (Button) findViewById(R.id.btMul);
        btSub = (Button) findViewById(R.id.btSub);
        btDot = (Button) findViewById(R.id.btDot);
        btEqual = (Button) findViewById(R.id.btEqual);
        btAdd = (Button) findViewById(R.id.btAdd);
    }

    public void enterDigit(View buttonView) {
        if (displayView.getText().toString().contains(".") && buttonView.equals(btDot)) {
            //do nothing
        } else {
            if (!(buttonView.equals(btDot)) && firstNumber == null) {
                displayView.setText("");
            }
            if (firstNumber != null && operator != null && secondNumber == null) {
                displayView.setText("");
            }
            if (operator == null) {
                enterNumber = ((Button) buttonView).getText().toString();
                displayView.append(enterNumber);
                firstNumber = displayView.getText().toString();
            } else {
                enterNumber = ((Button) buttonView).getText().toString();
                displayView.append(enterNumber);
                secondNumber = displayView.getText().toString();
            }
        }

    }

    public void enterOperation(View operateView) {
        this.enterEquals(btEqual);
        if (firstNumber == null) {
            firstNumber = displayView.getText().toString();
        }
        operator = ((Button) operateView).getText().toString();
    }

    public void enterEquals(View equalView) {

        double numFirst = 0;
        double numSecond = 0;
        double result = 0;

        if (firstNumber != null && operator != null && secondNumber != null) {
            numFirst = Double.parseDouble(firstNumber);
            numSecond = Double.parseDouble(secondNumber);
            switch (operator) {
                case "/":
                    result = numFirst / numSecond;
                    break;
                case "*":
                    result = numFirst * numSecond;
                    break;
                case "-":
                    result = numFirst - numSecond;
                    break;
                case "+":
                    result = numFirst + numSecond;
                    break;
            }
            displayView.setText(result + "");
            firstNumber = null;
            operator = null;
            secondNumber = null;
        }
    }

    public void enterClear(View clearView){
        displayView.setText("0");
        firstNumber = null;
        operator = null;
        secondNumber = null;
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
