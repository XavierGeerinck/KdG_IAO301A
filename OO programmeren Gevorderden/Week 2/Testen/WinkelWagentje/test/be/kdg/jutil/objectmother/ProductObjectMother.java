package be.kdg.jutil.objectmother;

import be.kdg.jutil.Product;

public class ProductObjectMother {
    public static Product maakXPBoek() {
        return new Product("Extreme Programming", 23.95);
    }

    public static Product maakRefactoringBoek() {
        return new Product("Refactoring", 53.95);
    }

    public static Product maakAnderBoek() {
        return new Product("Ender's Game", 4.95);
    }
}
