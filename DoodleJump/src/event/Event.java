package event;

import character.*;

public class Event {
    public static boolean checkHit(Dog dog, Wave wave) {
        if(dog.x + dog.dogSize > wave.x && dog.x < wave.x){
            System.out.println("HIT AT [X] !!!!!!");
            if(dog.y + dog.dogSize >= wave.y - wave.height){
                System.out.println("HIT AT [Y] !!!!!!");
                return true;
            }
        }
        return false;
    }
}