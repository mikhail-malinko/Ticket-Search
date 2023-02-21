package ru.netology.TicketSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 3_500, "ROV", "LED", 150);
    Ticket ticket2 = new Ticket(2, 2_700, "ROV", "DME", 180);
    Ticket ticket3 = new Ticket(3, 2_900, "KRR", "LED", 140);
    Ticket ticket4 = new Ticket(4, 2_500, "ROV", "DME", 155);
    Ticket ticket5 = new Ticket(5, 2_500, "KRR", "LED", 150);
    Ticket ticket6 = new Ticket(6, 2_500, "KRR", "LED", 150);
    Ticket ticket7 = new Ticket(7, 2_500, "ROV", "DME", 150);


//    @Test
//    public void saveTicket() {
//        manager.saveTicket(ticket1);
//        manager.saveTicket(ticket2);
//        manager.saveTicket(ticket3);
//        manager.saveTicket(ticket4);
//        manager.saveTicket(ticket5);
//
//        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
//        Assertions.assertArrayEquals(expected, manager.getRepo().findAll());
//    }

    @Test // когда есть совпадения
    public void listSuitableForDepartureAndArrival() {
        manager.saveTicket(ticket1);
        manager.saveTicket(ticket2);
        manager.saveTicket(ticket3);
        manager.saveTicket(ticket4);
        manager.saveTicket(ticket5);
        manager.saveTicket(ticket6);
        manager.saveTicket(ticket7);

        Ticket[] actual = manager.findAll("KRR", "LED");
        Ticket[] expected = {ticket5, ticket6, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test // когда нет совпадений по вылету
    public void listIfNoMatchByDeparture() {
        manager.saveTicket(ticket1);
        manager.saveTicket(ticket2);
        manager.saveTicket(ticket3);
        manager.saveTicket(ticket4);
        manager.saveTicket(ticket5);
        manager.saveTicket(ticket6);
        manager.saveTicket(ticket7);

        Ticket[] actual = manager.findAll("DME", "LED");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test // когда нет совпадений по прилету
    public void listIfThereAreNoMatchesOnArrival() {
        manager.saveTicket(ticket1);
        manager.saveTicket(ticket2);
        manager.saveTicket(ticket3);
        manager.saveTicket(ticket4);
        manager.saveTicket(ticket5);
        manager.saveTicket(ticket6);
        manager.saveTicket(ticket7);

        Ticket[] actual = manager.findAll("KPP", "ROV");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
