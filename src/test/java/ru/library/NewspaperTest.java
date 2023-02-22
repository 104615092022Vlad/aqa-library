package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class NewspaperTest {
    @Test
    public void shouldGetDate() {
        Instant date = Instant.now();
        Newspaper newspaper = new Newspaper("AIF", date);
        Assertions.assertEquals(newspaper.getDate(), date);
    }
}
