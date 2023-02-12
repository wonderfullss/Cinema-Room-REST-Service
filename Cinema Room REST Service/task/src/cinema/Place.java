package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Place {
    private int row;

    private int column;

    private int price;

    @JsonIgnore
    private String token;

    @JsonIgnore
    private boolean booked = false;

    public Place(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.booked = false;
        this.token = UUID.randomUUID().toString();
    }

    public Place() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
