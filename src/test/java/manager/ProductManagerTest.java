package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Book book1 = new Book(01, "Доктор Гарин", 100, "Сорокин В.Г.");
    Book book2 = new Book(02, "Герой нашего времени", 80, "Лермонтов М.Ю.");
    Book book3 = new Book(03, "Мы", 75, "Замятин Е.И.");
    Book book4 = new Book(04, "Метель", 50, "Сорокин В.Г.");
    Book book5 = new Book(05, "Палата №6", 50, "Чехов А.П.");

    Smartphone smartphone1 = new Smartphone(01, "IPhone", 200, "USA");
    Smartphone smartphone2 = new Smartphone(02, "Samsung", 150, "Korea");
    Smartphone smartphone3 = new Smartphone(03, "Sony", 200, "Japan");
    Smartphone smartphone4 = new Smartphone(04, "Nokia", 100, "Finland");
    Smartphone smartphone5 = new Smartphone(05, "Xiaomi", 150, "China");

    Product product1 = new Product(07, "Шорты", 500);

    @Test
    public void shouldNoProduct () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Honor");

        assertArrayEquals (expected, actual);
    }

    @Test
    public void shouldOneBook () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Замятин Е.И.");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForOneAuthor () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {book1, book4};
        Product[] actual = manager.searchBy("Сорокин В.Г.");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufacturer () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {smartphone3};
        Product[] actual = manager.searchBy("Japan");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByName () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldProductPartOfName () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Герой");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAnotherProduct () {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(book5);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.save(smartphone4);
        repository.save(smartphone5);
        repository.save(product1);

        ProductManager manager = new ProductManager(repository);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Шорты");

        assertArrayEquals(expected, actual);

    }

}