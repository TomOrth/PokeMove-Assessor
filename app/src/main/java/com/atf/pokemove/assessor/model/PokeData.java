package com.atf.pokemove.assessor.model;

import android.util.Log;

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

    public String determineVulnerability(){
        boolean isNotEffective = false;
        
        if(this.getNameType().equals("normal") && this.getMoveType().equals("ghost") || this.getNameType().equals("ghost") && this.getMoveType().equals("normal")) isNotEffective = true;
        if(this.getNameType().equals("ground") && this.getMoveType().equals("electric")) isNotEffective = true;
        if(this.getNameType().equals("flying") && this.getMoveType().equals("ground")) isNotEffective = true;
        if(this.getNameType().equals("ghost") && this.getMoveType().equals("fighting")) isNotEffective = false;
        if(this.getNameType().equals("dark") && this.getMoveType().equals("psychic")) isNotEffective = false;
        if(this.getNameType().equals("steel") && this.getMoveType().equals("poison")) isNotEffective = false;
        if(this.getNameType().equals("fairy") && this.getMoveType().equals("dragon")) isNotEffective = false;

        return isNotEffective ? "This move would have no effect on this pokemon" : "This move would have an effect on this pokemon";
    }
}
