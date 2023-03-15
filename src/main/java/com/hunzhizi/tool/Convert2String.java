package com.hunzhizi.tool;

/**
 * @author 魂之子
 * @since 2023-03-12 22:05
 * program: graduation-design
 * description:
 */
public class Convert2String {
    public static void main(String[] args) {
        String s = "person,bicycle,car,motorcycle,airplane,bus,train,truck,boat,trafficLight,fireHydrant," +
                "stopSign,parkingMeter,bench,bird,cat,dog,horse,sheep,cow,elephant,bear,zebra,giraffe,backpack,umbrella,handbag,tie," +
                "suitcase,frisbee,skis,snowboard,sportsBall,kite,baseballBat,baseballGlove,skateboard,surfboard,tennisRacket,bottle," +
                "wineGlass,cup,fork,knife,spoon,bowl,banana,apple,sandwich,orange,broccoli,carrot,hot_dog,pizza,donut,cake,chair," +
                "couch,pottedPlant,bed,diningTable,toilet,tv,laptop,mouse,remote,keyboard,cellPhone,microwave,oven,toaster,sink," +
                "refrigerator,book,clock,vase,scissors,teddyBear,hairDrier,toothbrush";
        char[] chars = s.toCharArray();
        System.out.print("#{");
        for (char aChar : chars) {
            if(aChar!=','){
                System.out.print(aChar);
            }else{
                System.out.print("},#{");
            }
        }
        System.out.print('}');

        System.out.println();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            char[] chars1 = split[i].toCharArray();
            chars1[0] = Character.toUpperCase(chars1[0]);
            split[i] = String.valueOf(chars1);
        }
        for (int i = 1; i < split.length+1; i++) {
            System.out.println("case " + i +": " + "set" + split[i-1] +"(true);"+ " break;");
        }
    }
}
