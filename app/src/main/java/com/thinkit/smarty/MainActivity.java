package com.thinkit.smarty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.thinkit.smarty.homeUi.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static com.thinkit.smarty.Utils.Utils.NAME_KEY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.btn_continue)
    Button btnContinue;

    @BindView(R.id.edt_name)
    EditText editTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case  R.id.btn_continue : {
                BaseSmarty.getSessionManager().setUserLoggedIn(editTextName.getText().toString());
                Intent homeIntent = new Intent(this, HomeActivity.class);
                //homeIntent.putExtra(NAME_KEY,editTextName.getText().toString());
                homeIntent.addFlags(FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_NEW_TASK | FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeIntent);

                break;
            }
            default: break;
        }

    }
}