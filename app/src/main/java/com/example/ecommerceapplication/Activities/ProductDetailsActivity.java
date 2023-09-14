package com.example.ecommerceapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.ModelClasses.ProductClass;
import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.Utils.Constants;
import com.example.ecommerceapplication.databinding.ActivityProductDetailsBinding;
import com.hishd.tinycart.model.Cart;
import com.hishd.tinycart.util.TinyCartHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;
    ProductClass currentProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_product_details);

        String name=getIntent().getStringExtra("name");
        String image=getIntent().getStringExtra("image");
        int id=getIntent().getIntExtra("id",0);
        double price=getIntent().getDoubleExtra("price",0);

        Glide.with(this).load(image).into(binding.imageProductsDetails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getProductDetails(id);
        getSupportActionBar().setTitle(name);
        Cart cart = TinyCartHelper.getCart();
        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cart.addItem(currentProduct,1);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.cart){
            startActivity(new Intent(this,ShoppingCartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    void getProductDetails(int id){
        RequestQueue queue= Volley.newRequestQueue(this);
        String url= Constants.GET_PRODUCT_DETAILS_URL+id;
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONObject product = null;
                    if (object.getString("status").equals("success")) {
                        product = object.getJSONObject("product");
                        String description = product.getString("description");
                        binding.txtProductDetails.setText(Html.fromHtml(description));
                    }
                    currentProduct = new ProductClass(
                            product.getString("name"),
                            Constants.PRODUCTS_IMAGE_URL + product.getString("image"),
                            product.getString("status"),
                            product.getDouble("price"),
                            product.getDouble("price_discount"),
                            product.getInt("stock"),
                            product.getInt("id")


                    );
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}