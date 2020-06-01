package software.kalender.pocketcase.models;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.util.Random;

import software.kalender.pocketcase.constants.GameConstant;
import software.kalender.pocketcase.enums.ColorEnum;

/*
    Query
    Enum Ordinal "," Chance ";"

 */
public class CaseChanceModel {
    private int[] chances = new int[GameConstant.COLOR_COUNT];

    public CaseChanceModel(){
        ColorEnum[] colorEnums = ColorEnum.values();

        for(int i = 0; i < GameConstant.COLOR_COUNT; i++){
            chances[i] = colorEnums[i].chance();
        }
    }

    public CaseChanceModel(String query) {
        if (query == null || query.isEmpty()) {
            return;
        }

        String[] chances = query.split(";");

        for (String chance : chances) {
            String[] value = chance.split(",");

            this.setChance(ColorEnum.values()[Integer.parseInt(value[0])], Integer.parseInt(value[1]));
        }
    }

    public String toQuery() {
        StringBuilder query = new StringBuilder();

        for (int i = 0; i < chances.length; i++) {
            query.append(i)
                    .append(",")
                    .append(chances[i])
                    .append(i != chances.length - 1 ? ";" : "");
        }

        return query.toString();
    }

    public CaseChanceModel setChance(@NonNull ColorEnum colorEnum, int colorChance) {
        chances[colorEnum.ordinal()] = colorChance;

        return this;
    }

    public int getChance(ColorEnum colorEnum){
        return getChance(colorEnum.ordinal());
    }

    public int getChance(int index){
        int chance = 0;

        for(int i = 0; i <= index; i++){
            chance += chances[i];
        }

        return chance;
    }

    public ColorEnum getColorHaveChance(){
        for(int i = 0; i < chances.length; i++){
            if(chances[i] != 0){
                return ColorEnum.values()[i];
            }
        }

        return ColorEnum.values()[GameConstant.DEFAULT_COLOR];
    }

    public ColorEnum random(){
        Random random = new Random();

        int randomInteger = random.nextInt(10000);

        int chance = 0;

        for(int i = 0; i < chances.length; i++){
            chance += chances[i];

            if(randomInteger < chance){
                return ColorEnum.values()[i];
            }
        }

        return getColorHaveChance();
    }
}
