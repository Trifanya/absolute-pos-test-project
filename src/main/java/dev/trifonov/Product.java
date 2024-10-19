package dev.trifonov;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {
    private final String name;
    private final Set<Product> composition = new HashSet<>();

    public Product(String name) {
        this.name = name;
    }

    public boolean addProduct(Product newProduct) {
        if (isValid(newProduct)) {
            return composition.add(newProduct);
        }
        return false;
    }

    private boolean isValid(Product newProduct) {
        return !(equals(newProduct) || this.isIngredientOf(newProduct) || composition.contains(newProduct));
    }

    private boolean isIngredientOf(Product product) {
        for (Product ingredient : product.composition) {
            if (ingredient.equals(this) || this.isIngredientOf(ingredient)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(name.toLowerCase(), product.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }
}
