package com.example.ecommerceapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.ecommerceapplication.Adapters.CategoryAdapter;
import com.example.ecommerceapplication.ModelClasses.Category;
import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categories=new ArrayList<>();
        categories.add(new Category("Sports & Outdoor","","#18ab4e","Some Description",1));
        categories.add(new Category("Sports & Outdoor","","#F03109","Some Description",2));
        categories.add(new Category("Sports & Outdoor","","#FF3109","Some Description",3));
        categories.add(new Category("Sports & Outdoor","","#F031ff","Some Description",4));
        categories.add(new Category("Sports & Outdoor","","#18ab4e","Some Description",5));
        categories.add(new Category("Sports & Outdoor","","#18ab4e","Some Description",6));
        categories.add(new Category("Sports & Outdoor","","#18ab4e","Some Description",7));
        categories.add(new Category("Sports & Outdoor","","#18ab4e","Some Description",8));

        categoryAdapter=new CategoryAdapter(this,categories);

        GridLayoutManager layoutManager=new GridLayoutManager(this,4);
        binding.categoriesList.setLayoutManager(layoutManager);

        binding.categoriesList.setAdapter(categoryAdapter);

    }
}