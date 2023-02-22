package ru.library;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SearchOperationsTest {
    @Test
    public void shouldGetBookByNameAndAuthorPositive() {
        Random r = new Random();
        Faker faker = new Faker();
        List<Book> books = new ArrayList<>();
        int edge = r.nextInt(1, 10);
        String title = faker.book().title();
        String author = faker.book().author();
        for (int i = 0; i < edge; i++) {
            if (i == edge - 1) {
                books.add(new Book(title, author));
            } else {
                books.add(new Book(faker.book().title(), faker.book().author()));
            }
        }
        List<Book> singleElementList = new ArrayList<>();
        singleElementList = SearchOperations.getBookByNameAndAuthor(title, author, books).stream().toList();
        String actual = singleElementList.get(0).getName();
        Assertions.assertEquals(title, actual);
    }

    @Test
    public void shouldBookByNameAndAuthorNegative() {
        Random r = new Random();
        Faker faker = new Faker();
        List<Book> books = new ArrayList<>();
        int edge = r.nextInt(1, 10);
        for (int i = 0; i < edge; i++) {
            books.add(new Book("", ""));
        }
        List<Book> singleElementList = new ArrayList<>();
        singleElementList = SearchOperations.getBookByNameAndAuthor(faker.book().title(), faker.book().author(), books).stream().toList();
        List<Book> expected = new ArrayList<>();
        Assertions.assertEquals(expected, singleElementList);
    }

    @Test
    public void shouldGetBookByNamePositive() {
        Random r = new Random();
        Faker faker = new Faker();
        List<Book> books = new ArrayList<>();
        int edge = r.nextInt(1, 10);
        String title = faker.book().title();
        for (int i = 0; i < edge; i++) {
            if (i == edge - 1) {
                books.add(new Book(title, faker.book().author()));
            } else {
                books.add(new Book(faker.book().title(), faker.book().author()));
            }
        }
        List<Book> singleElementList = new ArrayList<>();
        singleElementList = SearchOperations.getBookByName(title, books).stream().toList();
        String actual = singleElementList.get(0).getName();
        Assertions.assertEquals(title, actual);
    }

    @Test
    public void shouldGetBookByNameNegative() {
        Random r = new Random();
        Faker faker = new Faker();
        List<Book> books = new ArrayList<>();
        int edge = r.nextInt(1, 10);
        for (int i = 0; i < edge; i++) {
            books.add(new Book("", faker.book().author()));
        }
        List<Book> singleElementList = new ArrayList<>();
        singleElementList = SearchOperations.getBookByName(faker.book().title(), books).stream().toList();
        List<Book> expected = new ArrayList<>();
        Assertions.assertEquals(expected, singleElementList);
    }

}

