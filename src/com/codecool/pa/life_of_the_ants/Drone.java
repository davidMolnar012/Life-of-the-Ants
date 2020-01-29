package com.codecool.pa.life_of_the_ants;

public class Drone extends Field {
    Drone(int[] place) {
        super(Type.Drone, place);
    }



    @Override
    int[] stepOne() {

        assert place[0] < 0;
        assert place[1] < 0;

        if (place[0] > place[1]){
            return new int[]{place[0] - 1, place[1]};
        } else {
            return new int[]{place[0], place[1] - 1};
        }
    }
}
