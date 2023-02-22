package ru.library;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

class SortOperationsTest {
    @Test
    public void shouldGetBooksCategoriesPositive() {
        Random r = new Random();
        Faker faker = new Faker();
        List<Book> books = new ArrayList<>();
        Set<Category> categories = new HashSet<>();
        int edge = r.nextInt(1, 10);
        for (int i = 0; i < edge; i++) {
            String genre = faker.book().genre();
            books.add(new Book(null, null));
            books.get(i).setCategory(new Category(genre));
            categories.add(books.get(i).getCategory());
        }
        Assertions.assertEquals(SortOperations.getBooksCategories(books), categories);
    }

    @Test
    public void shouldGetBooksCategoriesNewspaperIn() {
        List<Book> books = new ArrayList<>();
        books.add(new Newspaper("AIF", Instant.now()));
        Set<Category> emptySet = new HashSet<>();
        Assertions.assertEquals(emptySet, SortOperations.getBooksCategories(books));
    }

    @Test
    public void shouldGetBooksCategoriesEmptyCategories() {
        Random r = new Random();
        List<Book> books = new ArrayList<>();
        Set<Category> categories = new HashSet<>();
        int edge = r.nextInt(1, 10);
        for (int i = 0; i < edge; i++) {
            books.add(new Book(null, null));
            categories.add(books.get(i).getCategory());
        }
        Set<Category> emptySet = new HashSet<>();
        Assertions.assertEquals(emptySet, SortOperations.getBooksCategories(books));
    }

    @Test
    public void shouldGetBooksByCategoryPositive() {
        Faker faker = new Faker();
        Random r = new Random();
        List<Book> books = new ArrayList<>();
        int edge = r.nextInt(1, 10);
        String genre = faker.book().genre();
        Category category = new Category(genre);
        for (int i = 0; i < edge; i++) {
            if (i == edge - 1) {
                books.add(new Book("title", "author"));
                books.get(i).setCategory(category);
            } else {
                books.add(new Book(faker.book().title(), faker.book().author()));
                books.get(i).setCategory(new Category(faker.book().genre()));
            }
        }
        Assertions.assertEquals(1, SortOperations.getBooksByCategory(books, category).size());
    }

    @Test
    public void shouldGetBooksByCategoryNegative() {
        Faker faker = new Faker();
        Random r = new Random();
        List<Book> books = new ArrayList<>();
        int edge = r.nextInt(1, 10);
        Category category = new Category(":)");
        for (int i = 0; i < edge; i++) {
            books.add(new Book(faker.book().title(), faker.book().author()));
        }
        Assertions.assertNull(SortOperations.getBooksByCategory(books, category));
    }

    @Test
    public void shouldSortNewspapersByDate() {
        Instant date1 = Instant.ofEpochMilli(1519275395000L);
        Instant date2 = Instant.ofEpochMilli(1550811395000L);
        Instant date3 = Instant.ofEpochMilli(1582347395000L);
        Instant date4 = Instant.ofEpochMilli(1613969795000L);
        Instant date5 = Instant.ofEpochMilli(1645505795000L);
        List<Newspaper> sampleListUnordered = new ArrayList<>();
        sampleListUnordered.add(new Newspaper("AIF", date4));
        sampleListUnordered.add(new Newspaper("AIF", date3));
        sampleListUnordered.add(new Newspaper("AIF", date5));
        sampleListUnordered.add(new Newspaper("AIF", date1));
        sampleListUnordered.add(new Newspaper("AIF", date2));
        List<Newspaper> newspapers = SortOperations.sortNewspapersByDate(sampleListUnordered);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String[] arrayActual = new String[5];
        arrayActual[0] = df.format(Date.from((newspapers.get(4).getDate())));
        arrayActual[1] = df.format(Date.from((newspapers.get(3).getDate())));
        arrayActual[2] = df.format(Date.from((newspapers.get(2).getDate())));
        arrayActual[3] = df.format(Date.from((newspapers.get(1).getDate())));
        arrayActual[4] = df.format(Date.from((newspapers.get(0).getDate())));
        String[] arrayExpected = new String[5];
        arrayExpected[0] = df.format(Date.from(date1));
        arrayExpected[1] = df.format(Date.from(date2));
        arrayExpected[2] = df.format(Date.from(date3));
        arrayExpected[3] = df.format(Date.from(date4));
        arrayExpected[4] = df.format(Date.from(date5));
        Assertions.assertEquals(Arrays.toString(arrayExpected), Arrays.toString(arrayActual));
    }
}
