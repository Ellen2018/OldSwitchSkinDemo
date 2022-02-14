package com.yalemang.oldswitchskindemo.setting.skin;

/**
 * 皮肤Bean类
 */
public class Skin {
    private int id;
    private int mainColor;
    private int ivSrc;
    private String skinName;

    public Skin(int id,String skinName,int mainColor, int ivSrc) {
        this.id = id;
        this.mainColor = mainColor;
        this.ivSrc = ivSrc;
        this.skinName = skinName;
    }

    public int getMainColor() {
        return mainColor;
    }

    public void setMainColor(int mainColor) {
        this.mainColor = mainColor;
    }

    public int getIvSrc() {
        return ivSrc;
    }

    public void setIvSrc(int ivSrc) {
        this.ivSrc = ivSrc;
    }

    public String getSkinName() {
        return skinName;
    }

    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
