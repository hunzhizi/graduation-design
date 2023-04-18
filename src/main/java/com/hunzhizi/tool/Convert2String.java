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
//        for (int i = 0; i < split.length; i++) {
//            char[] chars1 = split[i].toCharArray();
//            chars1[0] = Character.toUpperCase(chars1[0]);
//            split[i] = String.valueOf(chars1);
//        }
        for (int i = 1; i < split.length+1; i++) {
            System.out.println("case " + i +": " + "set" + split[i-1] +"(true);"+ " break;");
        }
        for (int i = 1; i < split.length+1; i++) {
            System.out.println("case \"\"" + ": return \"" + split[i-1] + "\";" );
        }
    }

    public static String ConvertChineseToEnglish(String label){
//        label = label.trim();
        char[] chars = label.toCharArray();
        char aChar = chars[0];
            if(('a'<=aChar && aChar<='z') || ('A'<=aChar && aChar<='Z')){
                return label;
            }
        switch (label){
            case "人物": return "person";
            case "自行车": return "bicycle";
            case "汽车": return "car";
            case "摩托车": return "motorcycle";
            case "飞机": return "airplane";
            case "公共汽车": return "bus";
            case "火车": return "train";
            case "卡车": return "truck";
            case "船": return "boat";
            case "交通信号灯": return "trafficLight";
            case "消防栓": return "fireHydrant";
            case "停车标志": return "stopSign";
            case "停车计时收费器": return "parkingMeter";
            case "长椅": return "bench";
            case "鸟": return "bird";
            case "猫": return "cat";
            case "狗": return "dog";
            case "马": return "horse";
            case "羊": return "sheep";
            case "奶牛": return "cow";
            case "大象": return "elephant";
            case "熊": return "bear";
            case "斑马": return "zebra";
            case "长颈鹿": return "giraffe";
            case "双肩背包": return "backpack";
            case "伞": return "umbrella";
            case "手提包": return "handbag";
            case "领带": return "tie";
            case "手提箱": return "suitcase";
            case "飞盘": return "frisbee";
            case "滑雪双板": return "skis";
            case "滑雪单板": return "snowboard";
            case "球": return "sportsBall";
            case "风筝": return "kite";
            case "棒球棒": return "baseballBat";
            case "棒球手": return "baseballGlove";
            case "滑板": return "skateboard";
            case "冲浪板": return "surfboard";
            case "网球拍": return "tennisRacket";
            case "水瓶": return "bottle";
            case "酒杯": return "wineGlass";
            case "咖啡杯": return "cup";
            case "叉子": return "fork";
            case "刀": return "knife";
            case "汤勺": return "spoon";
            case "碗": return "bowl";
            case "香蕉": return "banana";
            case "苹果": return "apple";
            case "三明治": return "sandwich";
            case "橙子": return "orange";
            case "西兰花": return "broccoli";
            case "胡萝卜": return "carrot";
            case "热狗": return "hot_dog";
            case "披萨": return "pizza";
            case "甜甜圈": return "donut";
            case "蛋糕": return "cake";
            case "椅子": return "chair";
            case "沙发": return "couch";
            case "盆栽": return "pottedPlant";
            case "床": return "bed";
            case "餐桌": return "diningTable";
            case "马桶": return "toilet";
            case "电视": return "tv";
            case "笔记本": return "laptop";
            case "鼠标": return "mouse";
            case "遥控器": return "remote";
            case "键盘": return "keyboard";
            case "手机": return "cellPhone";
            case "微波炉": return "microwave";
            case "烤箱": return "oven";
            case "面包机": return "toaster";
            case "水池子": return "sink";
            case "冰箱": return "refrigerator";
            case "书": return "book";
            case "钟表": return "clock";
            case "花瓶": return "vase";
            case "剪刀": return "scissors";
            case "泰迪熊": return "teddyBear";
            case "吹风机": return "hairDrier";
            case "牙刷": return "toothbrush";
        }
        return null;

    }
}
