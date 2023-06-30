package JAVA_OOP.InheritanceExercise.Restaurant;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        setName(name);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

}
