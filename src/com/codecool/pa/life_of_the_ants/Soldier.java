package com.codecool.pa.life_of_the_ants;

public class Soldier extends Field{
    int stepCounter = 0;
    int direction = 0;

    Soldier(int[] place) {
        super(Type.Soldier, place);
    }

    @Override
    int[] stepOne() {
        int currentDirection = direction;
        if (stepCounter != 4) {
            stepCounter++;
        } else {
            stepCounter = 0;
            if (direction != 4) {
                direction++;
            } else {
                direction = 0;
            }
        }
        switch (currentDirection) {
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
