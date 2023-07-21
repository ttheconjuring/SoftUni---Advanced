import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class InStockTest {

    // -----> .contains() + .add() <-----

    // Contains method should return true, since a product is added before the method is called
    @Test
    public void testContainsShouldWorkSuccessfullyWithCorrectArguments() {
        Product product = new Product("wtf", 3.14, 14);
        ProductStock productStock = new Instock();
        productStock.add(product);
        Assert.assertTrue(productStock.contains(product));
    }

    // Contains method should return false, because the created product object is not added
    @Test
    public void testContainsShouldReturnFalseWhenSuchProductDoesNotExist() {
        Product product = new Product("wtf", 3.14, 14);
        ProductStock productStock = new Instock();
        Assert.assertFalse(productStock.contains(product));
    }

    // -----> .getCount() <-----

    // 1) GetCount method should return 0, because the "productStock" is empty
    @Test
    public void testGetCountShouldReturnZeroWhenTheProductListIsEmpty() {
        ProductStock productStock = new Instock();
        Assert.assertEquals(0, productStock.getCount());
    }

    // 2) GetCount method should return 2, because there are two products added
    @Test
    public void testGetCountShouldReturnTheSizeOfTheProductListWhenItIsNotEmpty() {
        Product product1 = new Product("wtf", 3.14, 14);
        Product product2 = new Product("ffs", 5.49, 11);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.add(product2);
        Assert.assertEquals(2, productStock.getCount());
    }

    // -----> .find(int) <-----

    // 1) Find method should fail and throw an exception, because index 2 is invalid
    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindShouldThrowAnExceptionWhenInvalidIndexIsGiven() {
        Product product1 = new Product("wtf", 3.14, 14);
        Product product2 = new Product("ffs", 5.49, 11);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.add(product2);
        productStock.find(2);
    }

    // 2) Find method should return the "ffs"-label object, because index 1 is given
    @Test
    public void testFindShouldReturnAProductObjectWhenItIsCalledWithAValidIndex() {
        Product product1 = new Product("wtf", 3.14, 14);
        Product product2 = new Product("ffs", 5.49, 11);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.add(product2);
        Product foundProduct = productStock.find(1);
        Assert.assertEquals(foundProduct.label, product2.label);
    }

    // -----> .changeQuantity(String, int) <-----

    // 1) ChangeQuantity method should throw an exception, because an invalid label is given
    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowAnExceptionWhenNotExistingLabelIsGiven() {
        Product product1 = new Product("wtf", 3.14, 14);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.changeQuantity("ffs", 20);
    }

    // 2) ChangeQuantity method should change the quantity of "wtf"-label object with 20
    @Test
    public void testChangeQuantityShouldSuccessfullyChangeTheQuantityOfTheObjectWithTheExistingLabelGiven() {
        Product product1 = new Product("wtf", 3.14, 14);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.changeQuantity("wtf", 20);
        Assert.assertEquals(20, product1.quantity);
    }

    // -----> .findByLabel(String) <-----

    // 1) FindByLabel method should fail and throw an exception, because "ffs"-label does not exist
    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowAnExceptionWhenANotExistingLabelIsGiven() {
        Product product1 = new Product("wtf", 3.14, 14);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.findByLabel("ffs");
    }

    // 2) FindByLabel method should return
    @Test
    public void testFindByLabelShouldReturnAnProductObjectWithTheGivenLabel() {
        Product product1 = new Product("wtf", 3.14, 14);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        Product foundByLabelProduct = productStock.findByLabel("wtf");
        Assert.assertEquals(product1.label, foundByLabelProduct.label);
    }

    // ----> .findFirstByAlphabeticalOrder(int) <-----

    // 1) FindByAlphabeticalOrder method makes "firstByAlphabeticalOrder.iterator().hasNext()" to return false, because 3 is invalid count
    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnAnEmptyCollectionWhenTheIntegerGivenIsInvalid() {
        Product product1 = new Product("wtf", 3.14, 14);
        Product product2 = new Product("ffs", 5.49, 11);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.add(product2);
        Iterable<Product> firstByAlphabeticalOrder = productStock.findFirstByAlphabeticalOrder(3);
        Assert.assertFalse(firstByAlphabeticalOrder.iterator().hasNext());
    }

    // 2) FindByAlphabeticalOrder should return a collection of 2 elements
    @Test
    public void testFindByAlphabeticalOrderShouldReturnACollectionWithSizeOfTheGivenCount() {
        Product product1 = new Product("wtf", 3.14, 14);
        Product product2 = new Product("ffs", 5.49, 11);
        ProductStock productStock = new Instock();
        productStock.add(product1);
        productStock.add(product2);
        Iterable<Product> firstByAlphabeticalOrder = productStock.findFirstByAlphabeticalOrder(2);
        int length = 0;
        for (Product product : firstByAlphabeticalOrder) {
            length++;
        }
        Assert.assertEquals(2, length);
    }

    // TODO: test rest of the methods

}
