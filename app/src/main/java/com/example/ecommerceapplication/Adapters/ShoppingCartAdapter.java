package com.example.ecommerceapplication.Adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapplication.ModelClasses.ProductClass;
import com.example.ecommerceapplication.R;
import com.example.ecommerceapplication.databinding.ItemCartBinding;
import com.example.ecommerceapplication.databinding.QuantityDialogBinding;

import java.util.ArrayList;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {
    Context context;
    ArrayList<ProductClass> products;

    public ShoppingCartAdapter(Context context, ArrayList<ProductClass> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingCartAdapter.ViewHolder holder, int position) {
        ProductClass productClass=products.get(position);

        Glide.with(context).load(productClass.getImage())
                .into(holder.binding.imageView2);

        holder.binding.txtProductName.setText(productClass.getName());
        holder.binding.quantity.setText("PKR"+productClass.getPrice());
        holder.binding.quantity.setText(productClass.getQuantity()+"item(s)");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                QuantityDialogBinding quantityDialogBinding=QuantityDialogBinding.inflate(LayoutInflater.from(context));
                AlertDialog dialog= new AlertDialog.Builder(context)
                        .setView(quantityDialogBinding.getRoot())
                        .create();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));

                quantityDialogBinding.productName.setText(productClass.getName());
                quantityDialogBinding.productStock.setText("Stock :"+productClass.getStock());
                quantityDialogBinding.quantity.setText(String.valueOf(productClass.getQuantity()));
                int stock =productClass.getStock();
                quantityDialogBinding.plusBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                quantityDialogBinding.minusBtn.setOnClickListener(new View.OnClickListener() {
                     @Override
                    public void onClick(View v) {

                    }
                });
                quantityDialogBinding.saveBtn .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCartBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= ItemCartBinding.bind(itemView);
        }
    }
}
