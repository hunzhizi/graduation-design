package com.hunzhizi.domain;

/**
 * @author 魂之子
 * @since 2023-03-11 21:28
 * program: graduation-design
 * description:
 */
public class Color {
    private Integer colorId;
    private Integer photoId;
    private Integer themeOneR;
    private Integer themeOneG;
    private Integer themeOneB;
    private Integer themeTwoR;
    private Integer themeTwoG;
    private Integer themeTwoB;
    private Integer themeThreeR;
    private Integer themeThreeG;
    private Integer themeThreeB;
    private Integer themeFourR;
    private Integer themeFourG;
    private Integer themeFourB;
    private Integer themeFiveR;
    private Integer themeFiveG;
    private Integer themeFiveB;
    private Integer themeSixR;
    private Integer themeSixG;
    private Integer themeSixB;

    public Color(Integer colorId, Integer photoId, Integer themeOneR, Integer themeOneG, Integer themeOneB, Integer themeTwoR, Integer themeTwoG, Integer themeTwoB, Integer themeThreeR, Integer themeThreeG, Integer themeThreeB, Integer themeFourR, Integer themeFourG, Integer themeFourB, Integer themeFiveR, Integer themeFiveG, Integer themeFiveB, Integer themeSixR, Integer themeSixG, Integer themeSixB) {
        this.colorId = colorId;
        this.photoId = photoId;
        this.themeOneR = themeOneR;
        this.themeOneG = themeOneG;
        this.themeOneB = themeOneB;
        this.themeTwoR = themeTwoR;
        this.themeTwoG = themeTwoG;
        this.themeTwoB = themeTwoB;
        this.themeThreeR = themeThreeR;
        this.themeThreeG = themeThreeG;
        this.themeThreeB = themeThreeB;
        this.themeFourR = themeFourR;
        this.themeFourG = themeFourG;
        this.themeFourB = themeFourB;
        this.themeFiveR = themeFiveR;
        this.themeFiveG = themeFiveG;
        this.themeFiveB = themeFiveB;
        this.themeSixR = themeSixR;
        this.themeSixG = themeSixG;
        this.themeSixB = themeSixB;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Integer getThemeOneR() {
        return themeOneR;
    }

    public void setThemeOneR(Integer themeOneR) {
        this.themeOneR = themeOneR;
    }

    public Integer getThemeOneG() {
        return themeOneG;
    }

    public void setThemeOneG(Integer themeOneG) {
        this.themeOneG = themeOneG;
    }

    public Integer getThemeOneB() {
        return themeOneB;
    }

    public void setThemeOneB(Integer themeOneB) {
        this.themeOneB = themeOneB;
    }

    public Integer getThemeTwoR() {
        return themeTwoR;
    }

    public void setThemeTwoR(Integer themeTwoR) {
        this.themeTwoR = themeTwoR;
    }

    public Integer getThemeTwoG() {
        return themeTwoG;
    }

    public void setThemeTwoG(Integer themeTwoG) {
        this.themeTwoG = themeTwoG;
    }

    public Integer getThemeTwoB() {
        return themeTwoB;
    }

    public void setThemeTwoB(Integer themeTwoB) {
        this.themeTwoB = themeTwoB;
    }

    public Integer getThemeThreeR() {
        return themeThreeR;
    }

    public void setThemeThreeR(Integer themeThreeR) {
        this.themeThreeR = themeThreeR;
    }

    public Integer getThemeThreeG() {
        return themeThreeG;
    }

    public void setThemeThreeG(Integer themeThreeG) {
        this.themeThreeG = themeThreeG;
    }

    public Integer getThemeThreeB() {
        return themeThreeB;
    }

    public void setThemeThreeB(Integer themeThreeB) {
        this.themeThreeB = themeThreeB;
    }

    public Integer getThemeFourR() {
        return themeFourR;
    }

    public void setThemeFourR(Integer themeFourR) {
        this.themeFourR = themeFourR;
    }

    public Integer getThemeFourG() {
        return themeFourG;
    }

    public void setThemeFourG(Integer themeFourG) {
        this.themeFourG = themeFourG;
    }

    public Integer getThemeFourB() {
        return themeFourB;
    }

    public void setThemeFourB(Integer themeFourB) {
        this.themeFourB = themeFourB;
    }

    public Integer getThemeFiveR() {
        return themeFiveR;
    }

    public void setThemeFiveR(Integer themeFiveR) {
        this.themeFiveR = themeFiveR;
    }

    public Integer getThemeFiveG() {
        return themeFiveG;
    }

    public void setThemeFiveG(Integer themeFiveG) {
        this.themeFiveG = themeFiveG;
    }

    public Integer getThemeFiveB() {
        return themeFiveB;
    }

    public void setThemeFiveB(Integer themeFiveB) {
        this.themeFiveB = themeFiveB;
    }

    public Integer getThemeSixR() {
        return themeSixR;
    }

    public void setThemeSixR(Integer themeSixR) {
        this.themeSixR = themeSixR;
    }

    public Integer getThemeSixG() {
        return themeSixG;
    }

    public void setThemeSixG(Integer themeSixG) {
        this.themeSixG = themeSixG;
    }

    public Integer getThemeSixB() {
        return themeSixB;
    }

    public void setThemeSixB(Integer themeSixB) {
        this.themeSixB = themeSixB;
    }

    public Color() {
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorId=" + colorId +
                ", photoId=" + photoId +
                ", themeOneR=" + themeOneR +
                ", themeOneG=" + themeOneG +
                ", themeOneB=" + themeOneB +
                ", themeTwoR=" + themeTwoR +
                ", themeTwoG=" + themeTwoG +
                ", themeTwoB=" + themeTwoB +
                ", themeThreeR=" + themeThreeR +
                ", themeThreeG=" + themeThreeG +
                ", themeThreeB=" + themeThreeB +
                ", themeFourR=" + themeFourR +
                ", themeFourG=" + themeFourG +
                ", themeFourB=" + themeFourB +
                ", themeFiveR=" + themeFiveR +
                ", themeFiveG=" + themeFiveG +
                ", themeFiveB=" + themeFiveB +
                ", themeSixR=" + themeSixR +
                ", themeSixG=" + themeSixG +
                ", themeSixB=" + themeSixB +
                '}';
    }
}
