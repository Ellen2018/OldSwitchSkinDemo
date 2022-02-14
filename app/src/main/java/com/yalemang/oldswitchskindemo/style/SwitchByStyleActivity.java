package com.yalemang.oldswitchskindemo.style;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.yalemang.oldswitchskindemo.App;
import com.yalemang.oldswitchskindemo.R;

/**
 * 通过切换Style的方式进行皮肤更换
 * 缺点:
 * 1.要声明不同的Style,不方便管理
 * 2.apk体积会随着皮肤越多而越大
 */
public class SwitchByStyleActivity extends AppCompatActivity {

    private Button bt1, bt2, bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这句很重要，而且必须在setContentView方法之前调用
        setTheme(App.INSTANCE.getCurrentSkin());
        setContentView(R.layout.activity_skin_by_style);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt1.setOnClickListener(v -> {
            App.INSTANCE.setTheme(R.style.Theme_OldSwitchSkinDemo_SkinBlue);
        });
        bt2.setOnClickListener(v -> {
            App.INSTANCE.setTheme(R.style.Theme_OldSwitchSkinDemo_SkinGreen);
        });
        bt3.setOnClickListener(v -> {
            App.INSTANCE.setTheme(R.style.Theme_OldSwitchSkinDemo_SkinRed);
        });
    }

}