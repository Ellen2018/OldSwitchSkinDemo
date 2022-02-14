package com.yalemang.oldswitchskindemo.setting.skin;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseSkinActivity extends AppCompatActivity {

    /**
     * 是否首次刷新皮肤
     */
    private boolean isFirstRefreshSkin = false;

    private SkinManager.SwitchSkinListener switchSkinListener = (oldSkin, newSkin) -> {
        switchSkin(oldSkin, newSkin);
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SkinManager.getInstance().addSwitchSkinListener(switchSkinListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!isFirstRefreshSkin) {
            //主动刷新一次
            switchSkin(null, SkinManager.getInstance().getCurrentSkin());
            isFirstRefreshSkin = true;
        }
    }

    /**
     * 切换皮肤回调
     * @param oldSkin 旧皮肤
     * @param newSkin 新皮肤
     */
    protected abstract void switchSkin(Skin oldSkin, Skin newSkin);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().removeSwitchSkinListener(switchSkinListener);
    }
}
