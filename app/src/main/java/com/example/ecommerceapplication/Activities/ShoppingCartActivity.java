package com.example.ecommerceapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ecommerceapplication.Adapters.ShoppingCartAdapter;
import com.example.ecommerceapplication.ModelClasses.ProductClass;
import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.databinding.ActivityShoppingCartBinding;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.model.Item;
import com.hishd.tinycart.util.TinyCartHelper;

import java.util.ArrayList;
import java.util.Map;

public class ShoppingCartActivity extends AppCompatActivity {
    ActivityShoppingCartBinding binding;
    ShoppingCartAdapter adapter;
    ArrayList<ProductClass> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        products=new ArrayList<>();

        Cart cart = TinyCartHelper.getCart();

        for(Map.Entry<Item, Integer> item: cart.getAllItemsWithQty().entrySet()){
            ProductClass product=(ProductClass) item.getKey();
            int quantity= item.getValue();
            product.getQuantity();
            products.add(product);

        }

        adapter=new ShoppingCartAdapter(this,products);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration=new DividerItemDecoration(this,layoutManager.getOrientation());

        binding.cartList.setLayoutManager(layoutManager);
        binding.cartList.addItemDecoration(itemDecoration);
        binding.cartList.setAdapter(adapter);

        binding.subtotal.setText(String.format("PKR %.2f" , cart.getTotalPrice()));

    }
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}