package ru.library;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    public void shouldSetCategoryEmptyName() {
        final Book book = new Book("bookName", "bookAuthor");
        Category category = new Category(null);
        book.setCategory(category);
        Assertions.assertEquals(book.getCategory(), null);
    }

    @Test
    public void shouldSetCategoryRandomName() {
        Faker faker = new Faker();
        final Book book = new Book("bookName", "bookAuthor");
        String genre = faker.book().genre();
        Category category = new Category(genre);
        book.setCategory(new Category(genre));
        Assertions.assertEquals(book.getCategory().getName(), category.getName());
    }

    @Test
    public void shouldSetName() {
        Book book = new Book("bookName", "bookAuthor");
        Assertions.assertEquals(book.getName(), "bookName");
    }

    @Test
    public void shouldSetAuthor() {
        Book book = new Book("bookName", "bookAuthor");
        Assertions.assertEquals(book.getAuthor(), "bookAuthor");
    }
}
