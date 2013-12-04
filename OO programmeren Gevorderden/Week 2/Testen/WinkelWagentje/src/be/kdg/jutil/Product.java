package be.kdg.jutil;

/**
 * @author Kristiaan Behiels
 * @version 1.0 28-apr-2004 20:02:49
 */
public class Product {
    private String naam;
    private double prijs;

    public Product(String naam, double prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product)) return false;
        final Product anderProduct = (Product) object;
        return naam.equals(anderProduct.naam) && prijs == anderProduct.prijs;
    }

    public int hashCode() {
        int result = naam.hashCode();
        long temp = Double.doubleToLongBits(prijs);
        int code = (int) (temp ^ (temp >>> 32));
        return 37 * result + code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "naam='" + naam + '\'' +
                ", prijs=" + prijs +
                '}';
    }
}