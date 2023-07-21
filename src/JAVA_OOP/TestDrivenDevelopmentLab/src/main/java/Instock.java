
import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private final List<Product> productList = new ArrayList<>();

    @Override
    public int getCount() {
//        throw new UnsupportedOperationException();
        return productList.size();
    }

    @Override
    public boolean contains(Product product) {
//        throw new UnsupportedOperationException();
        return productList.contains(product);
    }

    @Override
    public void add(Product product) {
//        throw new UnsupportedOperationException();
        this.productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
//        throw new UnsupportedOperationException();
        try {
            this.productList.stream().filter(product1 -> product1.label.equals(product)).findFirst().orElseThrow().setQuantity(quantity);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
//        throw new UnsupportedOperationException();
        return this.productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
//        throw new UnsupportedOperationException();
        try {
            return this.productList.stream().filter(product -> product.label.equals(label)).findFirst().orElseThrow();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
//        throw new UnsupportedOperationException();
        if (count > this.getCount()) {
            return new ArrayList<>();
        }
        return this.productList.stream().limit(count).sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
