package software.kalender.pocketcase.chances;

import androidx.annotation.NonNull;

import java.security.PublicKey;
import java.util.Random;

import software.kalender.pocketcase.constants.GameConstant;
import software.kalender.pocketcase.enums.ColorEnum;
import software.kalender.pocketcase.enums.ItemQualityEnum;

/*
    Query
    Enum Ordinal "," Chance ";"
 */
public class ItemQualityChance {
    private int[] chances = new int[GameConstant.QUALITY_COUNT];

    public ItemQualityChance() {
        ItemQualityEnum[] itemQualityEnums = ItemQualityEnum.values();

        for (int i = 0; i < GameConstant.QUALITY_COUNT; i++) {
            chances[i] = itemQualityEnums[i].getChance();
        }
    }

    public ItemQualityChance(String query) {
        if (query == null || query.isEmpty()) {
            return;
        }

        String[] chances = query.split(";");

        for (String chance : chances) {
            String[] value = chance.split(",");

            this.setChance(ItemQualityEnum.values()[Integer.parseInt(value[0])], Integer.parseInt(value[1]));
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

    public ItemQualityChance setChance(@NonNull ItemQualityEnum itemQualityEnum, int chance) {
        chances[itemQualityEnum.ordinal()] = chance;

        return this;
    }

    public int getChance(ItemQualityEnum itemQualityEnum) {
        return getChance(itemQualityEnum.ordinal());
    }

    public int getChance(int index) {
        int chance = 0;

        for (int i = 0; i <= index; i++) {
            chance += chances[i];
        }

        return chance;
    }

    public ItemQualityEnum getQualityHaveChance() {
        for (int i = 0; i < chances.length; i++) {
            if (chances[i] != 0) {
                return ItemQualityEnum.values()[i];
            }
        }

        return ItemQualityEnum.values()[0]; //TODO
    }

    public ItemQualityEnum random() {
        Random random = new Random();

        int randomInteger = random.nextInt(10000);

        int chance = 0;

        for (int i = 0; i < chances.length; i++) {
            chance += chances[i];

            if (randomInteger < chance) {
                return ItemQualityEnum.values()[i];
            }
        }

        return getQualityHaveChance();
    }
}
