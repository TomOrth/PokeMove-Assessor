package com.atf.pokemove.assessor.model;

/**
 * Created by tom on 4/18/17.
 */

public class PokeData {
    String name, move, nameType, moveType;

    public PokeData(){
        this.name = "";
        this.move = "";
        this.nameType = "";
        this.moveType = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }
}
