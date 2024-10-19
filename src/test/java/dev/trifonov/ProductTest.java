package dev.trifonov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void addProduct_whenProductDoesNotContainIngredient_shouldReturnTrue() {
        Product cake = new Product("Торт");
        Product flour = new Product("Мука");

        boolean result = cake.addProduct(flour); // можно добавить муку в торт

        Assertions.assertTrue(result);
    }

    @Test
    public void addProduct_whenIngredientIsInSeveralProducts_shouldReturnTrue() {
        Product cake = new Product("Торт");
        Product donat = new Product("Пончик");
        Product flour = new Product("Мука");
        cake.addProduct(flour); // добавляем муку в торт

        boolean result = donat.addProduct(flour); // можно добавить муку в пончик

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
    public void addProduct_whenNewProductIsIngredientOfIngredient_shouldReturnTrue() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        Product onion = new Product("Лук");
        Product pasta = new Product("Паста");
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе
        mince.addProduct(onion); // добавляем лук в фарш
        bolognese.addProduct(pasta); // добавляем пасту в Болоньезе

        boolean result = bolognese.addProduct(onion); // можно добавить лук в Болоньезе

        Assertions.assertTrue(result);
    }

    @Test
    public void addProduct_whenCurrentProductIsIngredientOfNewIngredient_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе

        boolean result = mince.addProduct(bolognese); // нельзя добавить Болоньезе в фарш, т.к. тогда в составе Болоньезе будет сама Болоньезе

        Assertions.assertFalse(result);
    }

    @Test
    public void addProduct_whenCurrentProductIsSubingredientOfNewIngredient_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        Product meat = new Product("Мясо");
        Product onion = new Product("Лук");
        mince.addProduct(onion); // добавляем лук в фарш
        mince.addProduct(meat);
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе

        boolean result = meat.addProduct(bolognese); // нельзя добавить Болоньезе в мясо, т.к. тогда в составе Болоньезе будет сама Болоньезе

        Assertions.assertFalse(result);
    }


    @Test
    public void addProduct_whenNewIngredientIsAlreadyInProduct_shouldReturnFalse() {
        Product bolognese = new Product("Болоньезе");
        Product mince = new Product("Фарш");
        Product onion = new Product("Лук");
        Product pasta = new Product("Паста");
        bolognese.addProduct(mince); // добавляем фарш в Болоньезе
        mince.addProduct(onion); // добавляем лук в фарш
        bolognese.addProduct(onion); // добавляем лук в Болоньезе
        bolognese.addProduct(pasta); // добавляем пасту в Болоньезе

        boolean result = bolognese.addProduct(onion); // нельзя снова добавить лук в Болоньезе

        Assertions.assertFalse(result);
    }
}
