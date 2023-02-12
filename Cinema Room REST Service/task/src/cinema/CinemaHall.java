package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class CinemaHall {

    @JsonIgnore
    private String password = "super_secret";

    @JsonProperty("total_columns")
    private int totalColumn = 9;

    @JsonProperty("total_rows")
    private int totalRow = 9;
    @JsonProperty("available_seats")
    private ArrayList<Place> cinemaHall = new ArrayList<>();

    public CinemaHall(ArrayList<Place> cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public CinemaHall(String password, int totalColumn, int totalRow, ArrayList<Place> cinemaHall) {
        this.password = password;
        this.totalColumn = totalColumn;
        this.totalRow = totalRow;
        this.cinemaHall = cinemaHall;
    }

    public CinemaHall() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i < 4)
                    cinemaHall.add(new Place(i + 1, j + 1, 10));
                else
                    cinemaHall.add(new Place(i + 1, j + 1, 8));
            }
        }
    }

    public CinemaHall(int totalColumn, int totalRow, ArrayList<Place> cinemaHall) {
        this.totalColumn = totalColumn;
        this.totalRow = totalRow;
        this.cinemaHall = cinemaHall;
    }

    public String getPassword() {
        return password;
    }

    public int getTotalColumn() {
        return totalColumn;
    }

    public void setTotalColumn(int totalColumn) {
        this.totalColumn = totalColumn;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public ArrayList<Place> getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(ArrayList<Place> cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
}
