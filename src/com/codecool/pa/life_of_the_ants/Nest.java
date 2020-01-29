package com.codecool.pa.life_of_the_ants;

import java.util.ArrayList;
import java.util.Random;

public class Nest {
    ArrayList<Field> nest;
    private int size;
    private Random random = new Random();
    private int queenTimer;

    Nest(int size) {
        this.placeBug(new Queen(new int[]{0,0}));
        this.size = size;
        this.queenTimer = setQueenTimer();
    }

    private boolean freeField(int[] place) {
        for (Field currentField: nest) {
            if (currentField.getPlace() == place) {
                return false;
            }
        }
        return true;
    }

    private boolean withinSize(Field bug) {
        return bug.getPlace()[0] >= 0 && bug.getPlace()[0] < size && bug.getPlace()[1] >= 0 && bug.getPlace()[1] < size;
    }


    public void placeBug(Field bug) {
        if (withinSize(bug)) {
            if (freeField(bug.getPlace())) {
                nest.add(bug);
            }
        }
    }

    private void moveBug(Field bug, int[] place) {
        if (withinSize(bug)) {
            if (freeField(bug.getPlace())) {
                bug.move(place);
            }
        }
    }

    public int setQueenTimer() {
        return random.nextInt(101 ) + 100;
    }

    private boolean queenHasMood() {
        if (queenTimer == 0) {
            queenTimer = setQueenTimer();
            return true;
        }
        return false;
    }

    public void moveAnts() {
        if (queenTimer > 0) {
            queenTimer--;
        }
        for (Field bug : nest) {
            if (bug.getType() == Field.Type.Drone ) {
                if (bug.checkStunCounter() == 0) {
                    moveBug(bug, bug.stepOne());
                    if (bug.distanceFromQueen() == 3) {
                        if (queenHasMood()) {
                            bug.say("HALLELUJAH");
                            bug.setStunCounter(10);
                        } else {
                            bug.say("D’OH");
                            bug.move(new int[]{99,99});
                        }
                    }
                } else if (bug.checkStunCounter() == 1) {

                    moveBug(bug, new int[]{random.nextInt(100), random.nextInt(100)});
                }
            } else {
                moveBug(bug, bug.stepOne());
            }
        }
    }

}
