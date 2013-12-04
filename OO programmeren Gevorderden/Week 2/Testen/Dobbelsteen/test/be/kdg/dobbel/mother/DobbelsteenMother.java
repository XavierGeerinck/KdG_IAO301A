package be.kdg.dobbel.mother;

import be.kdg.dobbel.mock.MockDobbelsteen;

public class DobbelsteenMother {

    public static MockDobbelsteen maakDrieMaalEen() {
        return new MockDobbelsteen(1, 1, 1);
    }

    public static MockDobbelsteen maakDrieMaalTwee() {
        return new MockDobbelsteen(2, 2, 2);
    }

    public static MockDobbelsteen maakDrieMaalVijf() {
        return new MockDobbelsteen(5, 5, 5);
    }

    public static MockDobbelsteen maakVierVijfZes() {
        return new MockDobbelsteen(4, 5, 6);
    }

    public static MockDobbelsteen maakTweeDrieVier() {
        return new MockDobbelsteen(2, 3, 4);
    }

    public static MockDobbelsteen maakVijfZesTwee() {
        return new MockDobbelsteen(5, 6, 2);
    }

    public static MockDobbelsteen maakVijfVierVijf() {
        return new MockDobbelsteen(5, 4, 5);
    }

    public static MockDobbelsteen maakDrieZesEen() {
        return new MockDobbelsteen(3, 6, 1);

    }

    public static MockDobbelsteen maakVijfZesEen() {
        return new MockDobbelsteen(5, 6, 1);
    }

    public static MockDobbelsteen maakEenEenVier() {
        return new MockDobbelsteen(1, 1, 4);
    }
}
