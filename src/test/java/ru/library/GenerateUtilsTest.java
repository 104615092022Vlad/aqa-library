package ru.library;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GenerateUtilsTest {
    @Test
    public void shouldGenerateSomeBooks() {
        Random r = new Random();
        int count = r.nextInt(3, 6);
        List<Book> books = GenerateUtils.generateSomeBooks(count);
        Assertions.assertNotNull(books);
    }

    @Test
    public void shouldGenerateSomeNewspapers() {
        Random r = new Random();
        int count = r.nextInt(3, 6);
        List<Newspaper> newspapers = GenerateUtils.generateSomeNewsPapers(count);
        Assertions.assertNotNull(newspapers);
    }
}
