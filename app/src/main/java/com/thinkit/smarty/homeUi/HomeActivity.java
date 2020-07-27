package com.thinkit.smarty.homeUi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.thinkit.smarty.BaseSmarty;
import com.thinkit.smarty.R;
import com.thinkit.smarty.Utils.Utils;
import com.thinkit.smarty.homeUi.Models.Room;
import com.thinkit.smarty.homeUi.roomsAdapter.RoomsAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.thinkit.smarty.Utils.Utils.NAME_KEY;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.rooms_recycler)
    RecyclerView roomRecyclerView;

    @BindView(R.id.welcome_home_tv)
    TextView welcomeHomeTV;

    @BindView(R.id.home_date)
    TextView tvDate;

    private String userName;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        //userName = getIntent().getStringExtra(NAME_KEY);
        welcomeHomeTV.setText(welcomeHomeTV.getText() + " " + BaseSmarty.getSessionManager().getUserName()+"!");

        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        tvDate.setText(formattedDate);


        ArrayList<Room> roomArrayList = Utils.createRoomsList();
        RoomsAdapter roomsAdapter = new RoomsAdapter(this, roomArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        roomRecyclerView.setLayoutManager(linearLayoutManager);
        roomRecyclerView.setAdapter(roomsAdapter);




    }


}