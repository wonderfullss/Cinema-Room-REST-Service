package cinema;

public class ReturnedTicket {
    Place returned_ticket;

    public ReturnedTicket(Place returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    public Place getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Place returned_ticket) {
        this.returned_ticket = returned_ticket;
    }
}
