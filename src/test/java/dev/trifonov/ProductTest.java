package dev.trifonov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void addProduct_whenProductDoesNotContainIngredient_shouldReturnTrue() {
        Product cake = new Product("Торт");
        Product flour = new Product("Мука");

        boolean result = cake.addProduct(flour); // можно без проблем добавить фарш в Болоньезе

        Assertions.assertTrue(result);
    }

    @Test
    public void addProduct_whenIngredientIsInSeveralProducts_shouldReturnTrue() {
        Product cake = new Product("Торт");
        Product donat = new Product("Пончик");
        Product flour = new Product("Мука");
        cake.addProduct(flour);

        boolean result = donat.addProduct(flour);

        Assertions.assertTrue(result);
    }

    @Test
    public void addProduct_whenNewProductEqualsCurrentProduct_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");

        boolean result = bolognese.addProduct(bolognese); // нельзя добавить продукт в самого себя

        Assertions.assertFalse(result);
    }

    @Test
    public void addProduct_whenNewProductIsIngredient_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе

        boolean result = bolognese.addProduct(mince); // нельзя снова добавить фарш в Болоньезе

        Assertions.assertFalse(result);
    }

    @Test
    public void addProduct_whenNewProductIsParent_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе

        boolean result = mince.addProduct(bolognese); // нельзя добавить Болоньезе в фарш, т.к. тогда в составе Болоньезе будет сама Болоньезе

        Assertions.assertFalse(result);
    }

    @Test
    public void addProduct_whenNewProductIsParentOfParent_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        Product onion = new Product("Лук");
        mince.addProduct(onion); // добавляем лук в фарш
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе

        boolean result = onion.addProduct(bolognese); // нельзя добавить Болоньезе в лук, т.к. тогда в составе Болоньезе будет сама Болоньезе

        Assertions.assertFalse(result);
    }

}
