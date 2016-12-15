package com.example.soapmaze.android_pizzaorder;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText qty_pizza, qty_pasta, qty_salad;
    CheckBox chkbox_member;
    RadioGroup rd;
    RadioButton r_pickle, r_sauce;
    ImageView image_choice;
    Button order;
    TextView order_qty, order_price, order_choice;
    String sidemenuchoiced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qty_pizza = (EditText)findViewById(R.id.editPizza);
        qty_pasta = (EditText)findViewById(R.id.editPasta);
        qty_salad = (EditText)findViewById(R.id.editSalad);
        chkbox_member = (CheckBox)findViewById(R.id.chkbox_membership);
        rd = (RadioGroup)findViewById(R.id.radio_choice);
        r_pickle = (RadioButton)findViewById(R.id.radio_pickle);
        r_sauce = (RadioButton)findViewById(R.id.radio_sauce);
        image_choice = (ImageView)findViewById(R.id.img_choice);
        order = (Button)findViewById(R.id.btn_order);
        order_qty = (TextView)findViewById(R.id.txt_qty);
        order_price = (TextView)findViewById(R.id.txt_price);
        order_choice = (TextView)findViewById(R.id.txt_choice);
        image_choice.setVisibility(View.INVISIBLE);
        order_qty.setVisibility(View.INVISIBLE);
        order_price.setVisibility(View.INVISIBLE);
        order_choice.setVisibility(View.INVISIBLE);



        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case  R.id.radio_pickle :
                        image_choice.setImageResource(R.drawable.pickle);
                        image_choice.setVisibility(View.VISIBLE);
                        sidemenuchoiced = "피클";
                        break;
                    case R.id.radio_sauce :
                        image_choice.setImageResource(R.drawable.hot_sauce);
                        image_choice.setVisibility(View.VISIBLE);
                        sidemenuchoiced = "소스";
                        break;
                }
            }
        });

        order.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ordered_qty =  Integer.parseInt(qty_pizza.getText().toString()) + Integer.parseInt(qty_pasta.getText().toString()) + Integer.parseInt(qty_salad.getText().toString());
                double ordered_price = 0.0;
                double pizza = Double.parseDouble(qty_pizza.getText().toString());
                double pasta = Double.parseDouble(qty_pasta.getText().toString());
                double salad = Double.parseDouble(qty_salad.getText().toString());
                ordered_price = (pizza * 16000) + (pasta * 11000) + (salad * 4000);
                if(chkbox_member.isChecked()) {
                    ordered_price *= 0.93;
                }
                order_qty.setText("주문 개수 : " + ordered_qty);
                order_price.setText("주문 금액 : " + Double.toString(ordered_price));
                order_choice.setText(sidemenuchoiced + "를 선택하셨습니다.");
                order_qty.setVisibility(View.VISIBLE);
                order_price.setVisibility(View.VISIBLE);
                order_choice.setVisibility(View.VISIBLE);
            }
        });
    }
}
