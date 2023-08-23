package com.example.ecommerceapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.ecommerceapplication.Adapters.CategoryAdapter;
import com.example.ecommerceapplication.Adapters.ProductAdapter;
import com.example.ecommerceapplication.ModelClasses.Category;
import com.example.ecommerceapplication.ModelClasses.ProductClass;
import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    ProductAdapter productAdapter;
    ArrayList<ProductClass> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      initCategory();
      initProducts();


    }
    void initCategory(){
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
    void  initProducts(){
        products  = new ArrayList<>();
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,1));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,2));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,3));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,4));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,5));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,6));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,7));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,8));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,9));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,10));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,6));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,6));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,6));
        products.add(new ProductClass("Samsung S23 Ultra","https://images.pexels.com/photos/2112651/pexels-photo-2112651.jpeg?auto=compress&cs=tinysrgb&w=600","READY STOCK",22,12,2,6));
        productAdapter=new ProductAdapter(this,products);

        GridLayoutManager layoutManager=new GridLayoutManager(this,2);

        binding.productList.setLayoutManager(layoutManager);
        binding.productList.setAdapter(productAdapter);


    }
}