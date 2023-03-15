package com.hunzhizi.controller.result.dto;

import java.util.List;

/**
 * @author 魂之子
 * @since 2023-02-22 12:10
 * program: graduation-design
 * description: 分析调用返回的结果
 */
public class Analysis {
    private List<String> rgb;

    public List<String> getRgb() {
        return rgb;
    }

    public void setRgb(List<String> rgb) {
        this.rgb = rgb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Analysis(List<String> rgb, String address) {
        this.rgb = rgb;
        this.address = address;
    }

    private String address;


}
