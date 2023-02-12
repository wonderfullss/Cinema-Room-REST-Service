package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {
    private String token;
    @JsonProperty("ticket")
    private Place place;

    public Ticket() {
    }

    public Ticket(String token) {
        this.token = token;
    }

    public Ticket(Place place) {
        this.place = place;
    }

    public Ticket(String token, Place place) {
        this.token = token;
        this.place = place;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
