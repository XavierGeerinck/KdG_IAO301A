package be.kdg.webapps101.model;

public class Product {
    private final int id;
    private final String description;

    public Product(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return description;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }

        final Product product = (Product) o;

        if (id != product.id) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        return id;
    }

}
