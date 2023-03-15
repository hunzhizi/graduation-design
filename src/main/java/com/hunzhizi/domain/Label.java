package com.hunzhizi.domain;

/**
 * @author 魂之子
 * @since 2023-03-12 20:07
 * program: graduation-design
 * description:
 */
public class Label {
    private Integer labelId;
    private Integer photoId;
    private Boolean person;
    private Boolean bicycle;
    private Boolean car;
    private Boolean motorcycle;
    private Boolean airplane;
    private Boolean bus;
    private Boolean train;
    private Boolean truck;
    private Boolean boat;
    private Boolean trafficLight;
    private Boolean fireHydrant;
    private Boolean stopSign;
    private Boolean parkingMeter;
    private Boolean bench;
    private Boolean bird;
    private Boolean cat;
    private Boolean dog;
    private Boolean horse;
    private Boolean sheep;
    private Boolean cow;
    private Boolean elephant;
    private Boolean bear;
    private Boolean zebra;
    private Boolean giraffe;
    private Boolean backpack;
    private Boolean umbrella;
    private Boolean handbag;
    private Boolean tie;
    private Boolean suitcase;
    private Boolean frisbee;
    private Boolean skis;
    private Boolean snowboard;
    private Boolean sportsBall;
    private Boolean kite;
    private Boolean baseballBat;
    private Boolean baseballGlove;
    private Boolean skateboard;
    private Boolean surfboard;
    private Boolean tennisRacket;
    private Boolean bottle;
    private Boolean wineGlass;
    private Boolean cup;
    private Boolean fork;
    private Boolean knife;
    private Boolean spoon;
    private Boolean bowl;
    private Boolean banana;
    private Boolean apple;
    private Boolean sandwich;
    private Boolean orange;
    private Boolean broccoli;
    private Boolean carrot;
    private Boolean hot_dog;
    private Boolean pizza;
    private Boolean donut;
    private Boolean cake;
    private Boolean chair;
    private Boolean couch;
    private Boolean pottedPlant;
    private Boolean bed;
    private Boolean diningTable;
    private Boolean toilet;
    private Boolean tv;
    private Boolean laptop;
    private Boolean mouse;
    private Boolean remote;
    private Boolean keyboard;
    private Boolean cellPhone;
    private Boolean microwave;
    private Boolean oven;
    private Boolean toaster;
    private Boolean sink;
    private Boolean refrigerator;
    private Boolean book;
    private Boolean clock;
    private Boolean vase;
    private Boolean scissors;
    private Boolean teddyBear;
    private Boolean hairDrier;
    private Boolean toothbrush;

    public void setLabelByOrder(int order){
        switch (order){
            case 1: setPerson(true); break;
            case 2: setBicycle(true); break;
            case 3: setCar(true); break;
            case 4: setMotorcycle(true); break;
            case 5: setAirplane(true); break;
            case 6: setBus(true); break;
            case 7: setTrain(true); break;
            case 8: setTruck(true); break;
            case 9: setBoat(true); break;
            case 10: setTrafficLight(true); break;
            case 11: setFireHydrant(true); break;
            case 12: setStopSign(true); break;
            case 13: setParkingMeter(true); break;
            case 14: setBench(true); break;
            case 15: setBird(true); break;
            case 16: setCat(true); break;
            case 17: setDog(true); break;
            case 18: setHorse(true); break;
            case 19: setSheep(true); break;
            case 20: setCow(true); break;
            case 21: setElephant(true); break;
            case 22: setBear(true); break;
            case 23: setZebra(true); break;
            case 24: setGiraffe(true); break;
            case 25: setBackpack(true); break;
            case 26: setUmbrella(true); break;
            case 27: setHandbag(true); break;
            case 28: setTie(true); break;
            case 29: setSuitcase(true); break;
            case 30: setFrisbee(true); break;
            case 31: setSkis(true); break;
            case 32: setSnowboard(true); break;
            case 33: setSportsBall(true); break;
            case 34: setKite(true); break;
            case 35: setBaseballBat(true); break;
            case 36: setBaseballGlove(true); break;
            case 37: setSkateboard(true); break;
            case 38: setSurfboard(true); break;
            case 39: setTennisRacket(true); break;
            case 40: setBottle(true); break;
            case 41: setWineGlass(true); break;
            case 42: setCup(true); break;
            case 43: setFork(true); break;
            case 44: setKnife(true); break;
            case 45: setSpoon(true); break;
            case 46: setBowl(true); break;
            case 47: setBanana(true); break;
            case 48: setApple(true); break;
            case 49: setSandwich(true); break;
            case 50: setOrange(true); break;
            case 51: setBroccoli(true); break;
            case 52: setCarrot(true); break;
            case 53: setHot_dog(true); break;
            case 54: setPizza(true); break;
            case 55: setDonut(true); break;
            case 56: setCake(true); break;
            case 57: setChair(true); break;
            case 58: setCouch(true); break;
            case 59: setPottedPlant(true); break;
            case 60: setBed(true); break;
            case 61: setDiningTable(true); break;
            case 62: setToilet(true); break;
            case 63: setTv(true); break;
            case 64: setLaptop(true); break;
            case 65: setMouse(true); break;
            case 66: setRemote(true); break;
            case 67: setKeyboard(true); break;
            case 68: setCellPhone(true); break;
            case 69: setMicrowave(true); break;
            case 70: setOven(true); break;
            case 71: setToaster(true); break;
            case 72: setSink(true); break;
            case 73: setRefrigerator(true); break;
            case 74: setBook(true); break;
            case 75: setClock(true); break;
            case 76: setVase(true); break;
            case 77: setScissors(true); break;
            case 78: setTeddyBear(true); break;
            case 79: setHairDrier(true); break;
            case 80: setToothbrush(true); break;

        }

    }
    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Boolean getPerson() {
        return person;
    }

    public void setPerson(Boolean person) {
        this.person = person;
    }

    public Boolean getBicycle() {
        return bicycle;
    }

    public void setBicycle(Boolean bicycle) {
        this.bicycle = bicycle;
    }

    public Boolean getCar() {
        return car;
    }

    public void setCar(Boolean car) {
        this.car = car;
    }

    public Boolean getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Boolean motorcycle) {
        this.motorcycle = motorcycle;
    }

    public Boolean getAirplane() {
        return airplane;
    }

    public void setAirplane(Boolean airplane) {
        this.airplane = airplane;
    }

    public Boolean getBus() {
        return bus;
    }

    public void setBus(Boolean bus) {
        this.bus = bus;
    }

    public Boolean getTrain() {
        return train;
    }

    public void setTrain(Boolean train) {
        this.train = train;
    }

    public Boolean getTruck() {
        return truck;
    }

    public void setTruck(Boolean truck) {
        this.truck = truck;
    }

    public Boolean getBoat() {
        return boat;
    }

    public void setBoat(Boolean boat) {
        this.boat = boat;
    }

    public Boolean getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(Boolean trafficLight) {
        this.trafficLight = trafficLight;
    }

    public Boolean getFireHydrant() {
        return fireHydrant;
    }

    public void setFireHydrant(Boolean fireHydrant) {
        this.fireHydrant = fireHydrant;
    }

    public Boolean getStopSign() {
        return stopSign;
    }

    public void setStopSign(Boolean stopSign) {
        this.stopSign = stopSign;
    }

    public Boolean getParkingMeter() {
        return parkingMeter;
    }

    public void setParkingMeter(Boolean parkingMeter) {
        this.parkingMeter = parkingMeter;
    }

    public Boolean getBench() {
        return bench;
    }

    public void setBench(Boolean bench) {
        this.bench = bench;
    }

    public Boolean getBird() {
        return bird;
    }

    public void setBird(Boolean bird) {
        this.bird = bird;
    }

    public Boolean getCat() {
        return cat;
    }

    public void setCat(Boolean cat) {
        this.cat = cat;
    }

    public Boolean getDog() {
        return dog;
    }

    public void setDog(Boolean dog) {
        this.dog = dog;
    }

    public Boolean getHorse() {
        return horse;
    }

    public void setHorse(Boolean horse) {
        this.horse = horse;
    }

    public Boolean getSheep() {
        return sheep;
    }

    public void setSheep(Boolean sheep) {
        this.sheep = sheep;
    }

    public Boolean getCow() {
        return cow;
    }

    public void setCow(Boolean cow) {
        this.cow = cow;
    }

    public Boolean getElephant() {
        return elephant;
    }

    public void setElephant(Boolean elephant) {
        this.elephant = elephant;
    }

    public Boolean getBear() {
        return bear;
    }

    public void setBear(Boolean bear) {
        this.bear = bear;
    }

    public Boolean getZebra() {
        return zebra;
    }

    public void setZebra(Boolean zebra) {
        this.zebra = zebra;
    }

    public Boolean getGiraffe() {
        return giraffe;
    }

    public void setGiraffe(Boolean giraffe) {
        this.giraffe = giraffe;
    }

    public Boolean getBackpack() {
        return backpack;
    }

    public void setBackpack(Boolean backpack) {
        this.backpack = backpack;
    }

    public Boolean getUmbrella() {
        return umbrella;
    }

    public void setUmbrella(Boolean umbrella) {
        this.umbrella = umbrella;
    }

    public Boolean getHandbag() {
        return handbag;
    }

    public void setHandbag(Boolean handbag) {
        this.handbag = handbag;
    }

    public Boolean getTie() {
        return tie;
    }

    public void setTie(Boolean tie) {
        this.tie = tie;
    }

    public Boolean getSuitcase() {
        return suitcase;
    }

    public void setSuitcase(Boolean suitcase) {
        this.suitcase = suitcase;
    }

    public Boolean getFrisbee() {
        return frisbee;
    }

    public void setFrisbee(Boolean frisbee) {
        this.frisbee = frisbee;
    }

    public Boolean getSkis() {
        return skis;
    }

    public void setSkis(Boolean skis) {
        this.skis = skis;
    }

    public Boolean getSnowboard() {
        return snowboard;
    }

    public void setSnowboard(Boolean snowboard) {
        this.snowboard = snowboard;
    }

    public Boolean getSportsBall() {
        return sportsBall;
    }

    public void setSportsBall(Boolean sportsBall) {
        this.sportsBall = sportsBall;
    }

    public Boolean getKite() {
        return kite;
    }

    public void setKite(Boolean kite) {
        this.kite = kite;
    }

    public Boolean getBaseballBat() {
        return baseballBat;
    }

    public void setBaseballBat(Boolean baseballBat) {
        this.baseballBat = baseballBat;
    }

    public Boolean getBaseballGlove() {
        return baseballGlove;
    }

    public void setBaseballGlove(Boolean baseballGlove) {
        this.baseballGlove = baseballGlove;
    }

    public Boolean getSkateboard() {
        return skateboard;
    }

    public void setSkateboard(Boolean skateboard) {
        this.skateboard = skateboard;
    }

    public Boolean getSurfboard() {
        return surfboard;
    }

    public void setSurfboard(Boolean surfboard) {
        this.surfboard = surfboard;
    }

    public Boolean getTennisRacket() {
        return tennisRacket;
    }

    public void setTennisRacket(Boolean tennisRacket) {
        this.tennisRacket = tennisRacket;
    }

    public Boolean getBottle() {
        return bottle;
    }

    public void setBottle(Boolean bottle) {
        this.bottle = bottle;
    }

    public Boolean getWineGlass() {
        return wineGlass;
    }

    public void setWineGlass(Boolean wineGlass) {
        this.wineGlass = wineGlass;
    }

    public Boolean getCup() {
        return cup;
    }

    public void setCup(Boolean cup) {
        this.cup = cup;
    }

    public Boolean getFork() {
        return fork;
    }

    public void setFork(Boolean fork) {
        this.fork = fork;
    }

    public Boolean getKnife() {
        return knife;
    }

    public void setKnife(Boolean knife) {
        this.knife = knife;
    }

    public Boolean getSpoon() {
        return spoon;
    }

    public void setSpoon(Boolean spoon) {
        this.spoon = spoon;
    }

    public Boolean getBowl() {
        return bowl;
    }

    public void setBowl(Boolean bowl) {
        this.bowl = bowl;
    }

    public Boolean getBanana() {
        return banana;
    }

    public void setBanana(Boolean banana) {
        this.banana = banana;
    }

    public Boolean getApple() {
        return apple;
    }

    public void setApple(Boolean apple) {
        this.apple = apple;
    }

    public Boolean getSandwich() {
        return sandwich;
    }

    public void setSandwich(Boolean sandwich) {
        this.sandwich = sandwich;
    }

    public Boolean getOrange() {
        return orange;
    }

    public void setOrange(Boolean orange) {
        this.orange = orange;
    }

    public Boolean getBroccoli() {
        return broccoli;
    }

    public void setBroccoli(Boolean broccoli) {
        this.broccoli = broccoli;
    }

    public Boolean getCarrot() {
        return carrot;
    }

    public void setCarrot(Boolean carrot) {
        this.carrot = carrot;
    }

    public Boolean getHot_dog() {
        return hot_dog;
    }

    public void setHot_dog(Boolean hot_dog) {
        this.hot_dog = hot_dog;
    }

    public Boolean getPizza() {
        return pizza;
    }

    public void setPizza(Boolean pizza) {
        this.pizza = pizza;
    }

    public Boolean getDonut() {
        return donut;
    }

    public void setDonut(Boolean donut) {
        this.donut = donut;
    }

    public Boolean getCake() {
        return cake;
    }

    public void setCake(Boolean cake) {
        this.cake = cake;
    }

    public Boolean getChair() {
        return chair;
    }

    public void setChair(Boolean chair) {
        this.chair = chair;
    }

    public Boolean getCouch() {
        return couch;
    }

    public void setCouch(Boolean couch) {
        this.couch = couch;
    }

    public Boolean getPottedPlant() {
        return pottedPlant;
    }

    public void setPottedPlant(Boolean pottedPlant) {
        this.pottedPlant = pottedPlant;
    }

    public Boolean getBed() {
        return bed;
    }

    public void setBed(Boolean bed) {
        this.bed = bed;
    }

    public Boolean getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(Boolean diningTable) {
        this.diningTable = diningTable;
    }

    public Boolean getToilet() {
        return toilet;
    }

    public void setToilet(Boolean toilet) {
        this.toilet = toilet;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getLaptop() {
        return laptop;
    }

    public void setLaptop(Boolean laptop) {
        this.laptop = laptop;
    }

    public Boolean getMouse() {
        return mouse;
    }

    public void setMouse(Boolean mouse) {
        this.mouse = mouse;
    }

    public Boolean getRemote() {
        return remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    public Boolean getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Boolean keyboard) {
        this.keyboard = keyboard;
    }

    public Boolean getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(Boolean cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Boolean getMicrowave() {
        return microwave;
    }

    public void setMicrowave(Boolean microwave) {
        this.microwave = microwave;
    }

    public Boolean getOven() {
        return oven;
    }

    public void setOven(Boolean oven) {
        this.oven = oven;
    }

    public Boolean getToaster() {
        return toaster;
    }

    public void setToaster(Boolean toaster) {
        this.toaster = toaster;
    }

    public Boolean getSink() {
        return sink;
    }

    public void setSink(Boolean sink) {
        this.sink = sink;
    }

    public Boolean getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Boolean refrigerator) {
        this.refrigerator = refrigerator;
    }

    public Boolean getBook() {
        return book;
    }

    public void setBook(Boolean book) {
        this.book = book;
    }

    public Boolean getClock() {
        return clock;
    }

    public void setClock(Boolean clock) {
        this.clock = clock;
    }

    public Boolean getVase() {
        return vase;
    }

    public void setVase(Boolean vase) {
        this.vase = vase;
    }

    public Boolean getScissors() {
        return scissors;
    }

    public void setScissors(Boolean scissors) {
        this.scissors = scissors;
    }

    public Boolean getTeddyBear() {
        return teddyBear;
    }

    public void setTeddyBear(Boolean teddyBear) {
        this.teddyBear = teddyBear;
    }

    public Boolean getHairDrier() {
        return hairDrier;
    }

    public void setHairDrier(Boolean hairDrier) {
        this.hairDrier = hairDrier;
    }

    public Boolean getToothbrush() {
        return toothbrush;
    }

    public void setToothbrush(Boolean toothbrush) {
        this.toothbrush = toothbrush;
    }
}
