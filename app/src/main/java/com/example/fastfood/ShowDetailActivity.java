package com.example.fastfood;

import static java.util.ResourceBundle.getBundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fastfood.Domain.FoodDomain;
import com.example.fastfood.Helper.ManagementCart;

public class ShowDetailActivity extends AppCompatActivity {

    TextView addToCartBtn, titleTxt, feeTxt, descriptionTxt, numberOrderTxt;
    ImageView plusBtn, minusBtn, picFood;

    FoodDomain object;
    int numberOrder = 1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);
        initWidget();
        getBundle();

    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResoucreId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResoucreId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$" + object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(numberOrder > 1){
                   numberOrder = numberOrder - 1;
               }
               numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberinCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void initWidget() {
        addToCartBtn = findViewById(R.id.addToCartBTn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.picfood);
    }
}