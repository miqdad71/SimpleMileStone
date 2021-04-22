package com.miqdad71.milesstone;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.miqdad71.milesstone.Adapter.ListAdapterActivity;

import org.joda.time.DateTime;

public class MileStoneActivity extends AppCompatActivity implements DatePickerListener, PopupMenu.OnMenuItemClickListener {

    RecyclerView recyclerView;

    String[] s1;
    String[] s2;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mile_stone);


        ivBack= findViewById(R.id.iv_arrow_back);
        ivBack.setOnClickListener(v -> {
            Intent intent = new Intent(MileStoneActivity.this, MainActivity.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.rv_item_list);
        s1 = getResources().getStringArray(R.array.times_list);
        s2 = getResources().getStringArray(R.array.items_list);

        ListAdapterActivity myAdapter = new ListAdapterActivity(this, s1, s2);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//rv datePicker
        HorizontalPicker picker= findViewById(R.id.datePicker);
        picker.setListener(this)
                .setDays(120)
                .setOffset(7)
                .setDateSelectedColor(Color.DKGRAY)
                .setDateSelectedTextColor(Color.WHITE)
                .setMonthAndYearTextColor(Color.DKGRAY)
                .setTodayButtonTextColor(getColor(R.color.colorPrimary))
                .setTodayDateTextColor(getColor(R.color.colorPrimary))
                .setTodayDateBackgroundColor(Color.GRAY)
                .setUnselectedDayTextColor(Color.DKGRAY)
                .setDayOfWeekTextColor(Color.DKGRAY)
                .setUnselectedDayTextColor(getColor(R.color.white))
                .showTodayButton(false)
                .init();

        picker.setBackgroundColor(Color.WHITE);
        picker.setDate(new DateTime());
        //.plusDays(4) {untuk menambahkan default tanggal}
//rv datePicker

    }

    public void showPopup(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_main);
        popup.show();
    }

    @Override
    public void onDateSelected(DateTime dateSelected) {
        Toast.makeText(this, dateSelected.toString(), Toast.LENGTH_SHORT).show();
//        Log.i("Miqdad Kerens", "Selected date is " + dateSelected.toString());
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1:
                Toast.makeText(this, "Menu 1 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.m2:
                Toast.makeText(this, "Menu 2 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.m3:
                Toast.makeText(this, "Menu 3 Clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}