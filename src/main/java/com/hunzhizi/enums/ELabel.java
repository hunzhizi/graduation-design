package com.hunzhizi.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 魂之子
 * @since 2023-03-13 19:48
 * program: graduation-design
 * description:
 */
public enum ELabel {
    NULL,photo_id,person,bicycle,car,motorcycle,airplane,bus,train,truck,boat,traffic_light,fire_hydrant,
    stop_sign,parking_meter,bench,bird,cat,dog,horse,sheep,cow,elephant,bear,zebra,giraffe,backpack,umbrella,handbag,tie,
    suitcase,frisbee,skis,snowboard,sports_ball,kite,baseball_bat,baseball_glove,skateboard,surfboard,tennis_racket,bottle,
    wine_glass,cup,fork,knife,spoon,bowl,banana,apple,sandwich,orange,broccoli,carrot,hot_dog,pizza,donut,cake,chair,
    couch,potted_plant,bed,dining_table,toilet,tv,laptop,mouse,remote,keyboard,cell_phone,microwave,oven,toaster,sink,
    refrigerator,book,clock,vase,scissors,teddy_bear,hair_drier,toothbrush;

    private static Map<Integer,ELabel> map = new HashMap<>();
    static {
        ELabel[] values = ELabel.values();
        for (int i = 0; i < values.length; i++) {
            map.put(i,values[i]);
        }
    }
    public static String getELabelByNumber(int i){
        return map.get(i).name();
    }

//    public static void main(String[] args) {
//        System.out.println(getELabelByNumber(80));
//    }
}
