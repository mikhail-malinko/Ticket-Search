package ru.netology.TicketSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    TicketRepository repo = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 3_500, "ROV", "LED", 150);
    Ticket ticket2 = new Ticket(2, 2_700, "ROV", "DME", 180);
    Ticket ticket3 = new Ticket(3, 2_900, "KRR", "LED", 140);
    Ticket ticket4 = new Ticket(4, 2_500, "ROV", "DME", 155);
    Ticket ticket5 = new Ticket(5, 2_500, "KRR", "LED", 150);
    Ticket ticket6 = new Ticket(6, 2_500, "KRR", "LED", 150);
    Ticket ticket7 = new Ticket(7, 2_500, "ROV", "DME", 150);

    @Test
    public void addingTicket() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }
}
