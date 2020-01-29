package com.codecool.pa.life_of_the_ants;

import java.util.ArrayList;

public class Queen extends Field {

    Queen(int[] place) {
        super(Type.Queen, place);
    }



    @Override
    int[] stepOne() {return place;}
}
