package com.example.cookrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {
    TextView recipe,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);



        title = findViewById(R.id.recipeTitle);
        recipe = findViewById(R.id.recipeOfCook);
        Intent i = getIntent();
        String titleOfrecipe = i.getStringExtra("name");
        String recipeContent = i.getStringExtra("desc");

        recipe.setMovementMethod(new ScrollingMovementMethod());
        title.setText(titleOfrecipe);
        recipe.setText(recipeContent);






    }
}