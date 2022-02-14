package com.yalemang.oldswitchskindemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yalemang.oldswitchskindemo.setting.SwitchBySettingActivity;
import com.yalemang.oldswitchskindemo.style.SwitchByStyleActivity;

public class SkinActivity extends AppCompatActivity {

    private Button btSwitchOne,btSwitchTwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);
        btSwitchOne = findViewById(R.id.bt_switch_skin_by_style);
        btSwitchTwo = findViewById(R.id.bt_switch_skin_by_setting);
        btSwitchOne.setOnClickListener(v -> {
            //Style修改方式切换皮肤
            startActivity(new Intent(this, SwitchByStyleActivity.class));
        });
        btSwitchTwo.setOnClickListener(v -> {
            //Setting方式切换皮肤
            startActivity(new Intent(this, SwitchBySettingActivity.class));
        });
    }
}
