package com.example.ecommerceapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.Html;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.Utils.Constants;
import com.example.ecommerceapplication.databinding.ActivityProductDetailsBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;

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
    }
    void getProductDetails(int id){
        RequestQueue queue= Volley.newRequestQueue(this);
        String url= Constants.GET_PRODUCT_DETAILS_URL+id;
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    if(object.getString("status").equals("success"))
                    {
                        JSONObject product= object.getJSONObject("product");
                        String description=product.getString("description");
                        binding.txtProductDetails.setText(Html.fromHtml(description));
                    }
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