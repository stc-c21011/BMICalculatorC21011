package jp.suntech.c21011.bmicalculatorc21011;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloListener Listener = new HelloListener();  //リスナのインスタンスを生成
        //btClick.setOnClickListener(Listener);         //ボタンにリスナを組み込む

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(Listener);
        Button btConfirm = findViewById(R.id.btKeisan);
        btConfirm.setOnClickListener(Listener);


    }

//    private class ListItemClickListener implements AdapterView.OnItemClickListener{
//
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
//
//
//            Button btConfirm = findViewById(R.id.btConfirm);
//            btConfirm.setOnClickListener((View.OnClickListener) new ListItemClickListener());
//        }
//    }

    private  class HelloListener implements View.OnClickListener{
        //イベントハンドラ <= イベント発生時の処理
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.etkg);
            EditText inputs = findViewById(R.id.ettall);
            EditText inputx = findViewById(R.id.ettosi);
            TextView inputy = findViewById(R.id.ttBMI);
            TextView inputa = findViewById(R.id.tthiman);
            TextView inputb = findViewById(R.id.textView5);
            TextView inputc = findViewById(R.id.tttekisei);
            TextView inputd = findViewById(R.id.textView7);


            String toshix = inputx.getText().toString();
            Float toshi = Float.parseFloat(toshix);

            String tallx = inputs.getText().toString();
            Float tall = Float.parseFloat(tallx);

            String kgx = input.getText().toString();
            Float kg = Float.parseFloat(kgx);

            Float BMI = kg/(tall/100*tall/100);
            Float tekiweight = ((tall/100)*(tall/100)) * 22;
            String str = Float.toString(tekiweight);



            int id = view.getId();
            switch(id) {
                case R.id.btKeisan:

                        if(BMI<18.5) {
                            inputy.setText("あなたの肥満度は");
                            inputa.setText("低体重");
                            inputb.setText("あなたの適正体重は");
                            inputc.setText(str);

                        }
                    if(BMI>=18.5&&BMI<25) {
                        inputy.setText("あなたの肥満度は");
                        inputa.setText("普通体重");
                        inputb.setText("あなたの適正体重は");
                        inputc.setText(str);

                    }
                    else if(BMI>=25&&BMI<30) {
                    inputy.setText("あなたの肥満度は");
                    inputa.setText("肥満(1度)");
                    inputb.setText("あなたの適正体重は");
                    inputc.setText(str);

                }
                    else if(BMI>=30&&BMI<35) {
                    inputy.setText("あなたの肥満度は");
                    inputa.setText("肥満(2度)");
                    inputb.setText("あなたの適正体重は");
                    inputc.setText(str);

                }
                    else if(BMI>=35&&BMI<40) {
                    inputy.setText("あなたの肥満度は");
                    inputa.setText("肥満(3度)");
                    inputb.setText("あなたの適正体重は");
                    inputc.setText(str);

                }
                    else if(BMI>=40){
                    inputy.setText("あなたの肥満度は");
                    inputa.setText("肥満(4度)");
                    inputb.setText("あなたの適正体重は");
                    inputc.setText(str);

                }
                    inputd.setText("kg");


                    if(toshi<16) {
                        OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                        dialogFragment.show(getSupportFragmentManager(), "Oooooooooooo");
                    }

                    break;

                case R.id.btClear:

                    input.setText("");
                    inputs.setText("");
                    inputx.setText("");
                    inputy.setText("");
                    inputa.setText("");
                    inputb.setText("");
                    inputc.setText("");
                    inputd.setText("");

                    break;
            }
        }
    }
    }
