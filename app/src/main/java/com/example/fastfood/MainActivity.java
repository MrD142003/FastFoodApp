package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.fastfood.Adopter.CategoryAdopter;
import com.example.fastfood.Adopter.HotAdopter;
import com.example.fastfood.Domain.CategoryDomain;
import com.example.fastfood.Domain.FoodDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView.Adapter adapter, adapter2;
    RecyclerView recyclerViewCategoryList, recyclerViewHotList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewHot();
        bottomNavigation();
    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cardBtn);
        ImageView homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recycleView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Hotdog", "cat_3"));
        category.add(new CategoryDomain("Drink", "cat_4"));
        category.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdopter(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewHot() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewHotList = findViewById(R.id.recycleView2);
        recyclerViewHotList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza", "pop_1", "slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce", 8.79));
        foodList.add(new FoodDomain("Cheese Burger", "pop_2", "beef, Gouda Cheese, special sauce, lettuce, tomato", 5.99));
        foodList.add(new FoodDomain("Vegetable pizza", "pop_3", "olive oil, vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 7.39));

        adapter2 = new HotAdopter(foodList);
        recyclerViewHotList.setAdapter(adapter2);
    }

}