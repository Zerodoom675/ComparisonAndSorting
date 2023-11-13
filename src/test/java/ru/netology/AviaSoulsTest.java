package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket ticket = new Ticket("Москва", "Краснодар", 100, 16, 20);  //4ч
    Ticket ticket2 = new Ticket("Москва", "Краснодар", 200, 17, 21);  //4ч
    Ticket ticket3 = new Ticket("Москва", "Краснодар", 50, 16, 22);   //6ч
    Ticket ticket4 = new Ticket("Москва", "Сочи", 400, 16, 19);   //3
    Ticket ticket5 = new Ticket("Москва", "Краснодар", 350, 17, 19);   //2ч
    Ticket ticket6 = new Ticket("Москва", "Сочи", 100, 17, 21);   //4
    Ticket ticket7 = new Ticket("Москва", "Краснодар", 500, 15, 17);    //2ч
    Ticket ticket8 = new Ticket("Москва", "Сочи", 250, 18, 21);   //3
    Ticket ticket9 = new Ticket("Москва", "Сочи", 450, 18, 20);   //2
    Ticket ticket10 = new Ticket("Москва", "Сочи", 175, 19, 22);   //3

    @Test
    public void defaultComparisonTesting() {
        //System.out.println(ticket.compareTo(ticket2));
        int expected = -1;
        int actual = ticket.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void defaultComparisonTesting2() {
        //System.out.println(ticket.compareTo(ticket2));
        int expected = 1;
        int actual = ticket.compareTo(ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void defaultComparisonTesting3() {
        //System.out.println(ticket.compareTo(ticket2));
        int expected = 0;
        int actual = ticket.compareTo(ticket6);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingDefaultSorting() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

        Ticket[] expected = {ticket3, ticket, ticket2, ticket5, ticket7};
        Ticket[] actual = tickets.search("Москва", "Краснодар");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingDefaultSortin2() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

        Ticket[] expected = {ticket6, ticket10, ticket8, ticket4, ticket9};
        Ticket[] actual = tickets.search("Москва", "Сочи");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingAGivenComparison() {
        int expected = 0;
        int actual = timeComparator.compare(ticket, ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingAGivenComparison2() {
        int expected = -1;
        int actual = timeComparator.compare(ticket, ticket3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingAGivenComparison3() {
        int expected = 1;
        int actual = timeComparator.compare(ticket, ticket7);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testingAGivenSort() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

        Ticket[] expected = {ticket5, ticket7, ticket, ticket2, ticket3};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Краснодар", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingAGivenSort2() {
        AviaSouls tickets = new AviaSouls();

        tickets.add(ticket);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

        Ticket[] expected = {ticket9, ticket4, ticket8, ticket10, ticket6};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Сочи", timeComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
