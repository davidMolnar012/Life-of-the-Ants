package com.codecool.pa.life_of_the_ants;

import java.util.Random;

public class Worker extends Field{


    Worker(int[] place) {
        super(Type.Worker, place);
    }

    @Override
    int[] stepOne() {
        Random direction = new Random();
        switch (direction.nextInt(4)) {
            case 0:
                return new int[]{place[0] + 1, place[1]};
            case 1:
                return new int[]{place[0] - 1, place[1]};
            case 2:
                return new int[]{place[0], place[1] + 1};
            case 3:
                return new int[]{place[0] + 1, place[1] - 1};
        }
    }
}
