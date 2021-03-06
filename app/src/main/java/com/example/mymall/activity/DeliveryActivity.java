package com.example.mymall.activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.mymall.Adapter.CartAdapter;
import com.example.mymall.Model.CartItemModel;
import com.example.mymall.R;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {
    Toolbar toolbar;
    private RecyclerView deliveryRecyclerview;
    private Button changeOraddNewAddressBtn;
    public static final int SELECTE_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryRecyclerview = findViewById(R.id.delivery_recyclerview);
        changeOraddNewAddressBtn = findViewById(R.id.change_or_add_address_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        deliveryRecyclerview.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0, R.drawable.gionee, "Gionee", 2, "Rs.49999/-", "Rs.51000/-", 1, 0, 0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.gionee, "Gionee", 0, "Rs.49999/-", "Rs.51000/-", 1, 1, 0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.gionee, "Gionee", 2, "Rs.49999/-", "Rs.51000/-", 1, 2, 0));
        cartItemModelList.add(new CartItemModel(1, "Price (3 items)", "Rs.15999/-", "Free", "Rs.48000/-", "5000"));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        deliveryRecyclerview.setAdapter(cartAdapter);
        deliveryRecyclerview.setHasFixedSize(true);
        cartAdapter.notifyDataSetChanged();
        changeOraddNewAddressBtn.setVisibility(View.VISIBLE);
        changeOraddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent = new Intent(DeliveryActivity.this, MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE",SELECTE_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
