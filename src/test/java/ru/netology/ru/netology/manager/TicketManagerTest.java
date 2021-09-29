package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TicketByTimeAscComparator;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 2399, "KZN", "UFA", 120);
    private Ticket second = new Ticket(45, 2568, "DME", "UFA", 240);
    private Ticket third = new Ticket(36, 5783, "DME", "KZN", 190);
    private Ticket fourth = new Ticket(28, 1476, "KZN", "UFA", 120);
    private Ticket fifth = new Ticket(87, 3672, "KZN", "UFA", 120);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void shouldFindAll() {
        Ticket[] actual = manager.findAll("KZN", "UFA", new TicketByTimeAscComparator());
        Ticket[] expected = {first, fourth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNoTicket() {
        Ticket[] actual = manager.findAll("KZN", "LED", new TicketByTimeAscComparator());
        Ticket[] expected = {};
        assertArrayEquals(expected, actual);
    }
}