package ru.netology.domain;

import org.junit.jupiter.api.Test;
import manager.ProductManager;
import ru.netology.domain.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductManager manager = new ProductManager(new ProductRepository());
    private Book coreJava = new Book(1, "core", 200, "first");
    private Book whiteFang = new Book(2, "fang", 300, "first");
    private Book blackFang = new Book(3, "fang", 550, "three");
    private Smartphone oneX = new Smartphone(1, "one", 5000, "phone1");

    @Test
    void shouldSaveOneItem() {

        manager.saveProduct(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem2() {

        manager.saveProduct(whiteFang);

        Product[] expected = new Product[]{whiteFang};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem3() {

        manager.saveProduct(oneX);

        Product[] expected = new Product[]{oneX};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem4() {

        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{blackFang};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAllItems() {

        manager.saveProduct(coreJava);
        manager.saveProduct(whiteFang);
        manager.saveProduct(oneX);
        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{coreJava, whiteFang, oneX, blackFang};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString() {

        manager.saveProduct(coreJava);
        manager.saveProduct(whiteFang);
        manager.saveProduct(oneX);
        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = manager.searchBy("core");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString2() {

        manager.saveProduct(coreJava);
        manager.saveProduct(whiteFang);
        manager.saveProduct(oneX);
        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{oneX};
        Product[] actual = manager.searchBy("one");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString3() {

        manager.saveProduct(coreJava);
        manager.saveProduct(whiteFang);
        manager.saveProduct(oneX);
        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("two");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString4() {

        manager.saveProduct(coreJava);
        manager.saveProduct(whiteFang);
        manager.saveProduct(oneX);
        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{whiteFang, blackFang};
        Product[] actual = manager.searchBy("fang");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        manager.saveProduct(coreJava);
        manager.saveProduct(whiteFang);
        manager.saveProduct(oneX);
        manager.saveProduct(blackFang);

        Product[] expected = new Product[]{coreJava, oneX, blackFang};
        Product[] actual = manager.removeByIdProducts(2);

        assertArrayEquals(expected, actual);
    }

}