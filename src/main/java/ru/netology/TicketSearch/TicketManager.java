package ru.netology.TicketSearch;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

//    public TicketRepository getRepo() {
//        return repo;
//    }

    public void saveTicket(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public Ticket[] findAll(String depAirport, String arrAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matchingRequest(ticket, depAirport, arrAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matchingRequest(Ticket ticket, String departure, String arrival) {
        if (ticket.getDepartureAirport().equals(departure)) {
            if (ticket.getArrivalAirport().equals(arrival)) {
                return true;
            }
        }
        return false;
    }
}
