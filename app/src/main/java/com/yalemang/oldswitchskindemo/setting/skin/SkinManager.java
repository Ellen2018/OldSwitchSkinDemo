package com.yalemang.oldswitchskindemo.setting.skin;

import android.graphics.Color;

import com.yalemang.oldswitchskindemo.R;

import java.util.ArrayList;
import java.util.List;

public class SkinManager {

    private volatile static SkinManager INSTANCE;
    //这里的皮肤集合数据可通过后端进行配置 & 添加 & 下载
    private List<Skin> skinList;
    private List<SwitchSkinListener> switchSkinListeners;
    private int currentSkinId = ID_SKIN_BLUE;
    public static final int ID_SKIN_BLUE = 1;
    public static final int ID_SKIN_GREEN = 2;
    public static final int ID_SKIN_RED = 3;

    private SkinManager(){
        skinList = new ArrayList<>();
        switchSkinListeners = new ArrayList<>();
        initSkin();
    }

    /*
     * 添加皮肤切换监听
     */
    public void addSwitchSkinListener(SwitchSkinListener switchSkinListener){
        switchSkinListeners.add(switchSkinListener);
    }

    /**
     * 移除皮肤切换监听
     * @param switchSkinListener
     */
    public void removeSwitchSkinListener(SwitchSkinListener switchSkinListener){
        switchSkinListeners.remove(switchSkinListener);
    }

    private void initSkin() {
        Skin skinBlue = new Skin(ID_SKIN_BLUE,"蓝色", Color.BLUE, R.mipmap.skin_blue);
        Skin skinGreen = new Skin(ID_SKIN_GREEN,"绿色", Color.GREEN, R.mipmap.skin_green);
        Skin skinRed = new Skin(ID_SKIN_RED,"红色", Color.RED, R.mipmap.skin_red);
        skinList.add(skinBlue);
        skinList.add(skinGreen);
        skinList.add(skinRed);
    }

    /**
     * 切换皮肤
     * @param skinId
     */
    public void switchSkin(int skinId){
        if(skinId == currentSkinId){
            return;
        }
        Skin oldSkin = null,newSkin = null;
        for(Skin skin:skinList){
            if(skin.getId() == currentSkinId){
               oldSkin = skin;
            }
            if(skin.getId() == skinId){
                newSkin = skin;
            }
        }
        for(SwitchSkinListener switchSkinListener:switchSkinListeners){
            switchSkinListener.switchSkin(oldSkin,newSkin);
        }
        currentSkinId = skinId;
    }

    public Skin getCurrentSkin(){
        Skin newSkin = null;
        for(Skin skin:skinList){
            if(skin.getId() == currentSkinId){
                newSkin = skin;
            }
        }
        return newSkin;
    }

    public static SkinManager getInstance(){
        if(INSTANCE == null){
            synchronized (SkinManager.class){
                if(INSTANCE == null){
                    INSTANCE = new SkinManager();
                }
            }
        }
        return INSTANCE;
    }

    interface SwitchSkinListener{
        void switchSkin(Skin oldSkin,Skin newSkin);
    }

}
