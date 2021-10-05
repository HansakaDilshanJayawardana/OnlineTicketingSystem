package service;

import model.Ticket;

public interface ITicket {

    public boolean validateTicket(int id);
    public void issueTicket(Ticket ticket);
}
