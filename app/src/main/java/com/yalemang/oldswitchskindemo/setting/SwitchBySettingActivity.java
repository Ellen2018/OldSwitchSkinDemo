package com.yalemang.oldswitchskindemo.setting;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.yalemang.oldswitchskindemo.App;
import com.yalemang.oldswitchskindemo.R;
import com.yalemang.oldswitchskindemo.setting.skin.BaseSkinActivity;
import com.yalemang.oldswitchskindemo.setting.skin.Skin;
import com.yalemang.oldswitchskindemo.setting.skin.SkinManager;

public class SwitchBySettingActivity extends BaseSkinActivity {

    private Button bt1, bt2, bt3;
    private TextView tv;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_by_setting);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);

        bt1.setOnClickListener(v -> {
            SkinManager.getInstance().switchSkin(SkinManager.ID_SKIN_BLUE);
        });
        bt2.setOnClickListener(v -> {
            SkinManager.getInstance().switchSkin(SkinManager.ID_SKIN_GREEN);
        });
        bt3.setOnClickListener(v -> {
            SkinManager.getInstance().switchSkin(SkinManager.ID_SKIN_RED);
        });
    }

    @Override
    protected void switchSkin(Skin oldSkin, Skin newSkin) {
        iv.setImageResource(newSkin.getIvSrc());
        tv.setTextColor(newSkin.getMainColor());
        tv.setText(newSkin.getSkinName());
    }
}
