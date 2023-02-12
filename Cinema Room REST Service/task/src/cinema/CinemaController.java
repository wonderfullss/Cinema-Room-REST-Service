package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {
    CinemaHall cinema = new CinemaHall();

    @GetMapping(value = "/seats")
    public @ResponseBody CinemaHall getHall() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> postTicket(@RequestBody Place place) {
        if (place.getRow() < 1 || place.getRow() > 9 || place.getColumn() < 1 || place.getColumn() > 9) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        } else {
            for (int i = 0; i < cinema.getCinemaHall().size(); i++) {
                if (cinema.getCinemaHall().get(i).getColumn() == place.getColumn() && cinema.getCinemaHall().get(i).getRow() == place.getRow() && cinema.getCinemaHall().get(i).isBooked())
                    return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
                else if (cinema.getCinemaHall().get(i).getColumn() == place.getColumn() && cinema.getCinemaHall().get(i).getRow() == place.getRow()) {
                    cinema.getCinemaHall().get(i).setBooked(true);
                    return new ResponseEntity<>(new Ticket(cinema.getCinemaHall().get(i).getToken(), cinema.getCinemaHall().get(i)), HttpStatus.OK);
                }
            }
        }
        return null;
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Ticket token) {
        for (int i = 0; i < cinema.getCinemaHall().size(); i++) {
            if (token.getToken().equals(cinema.getCinemaHall().get(i).getToken())) {
                ReturnedTicket temp = new ReturnedTicket(cinema.getCinemaHall().get(i));
                cinema.getCinemaHall().get(i).setToken(UUID.randomUUID().toString());
                cinema.getCinemaHall().get(i).setBooked(false);
                return new ResponseEntity<>(temp, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> returnStats(@RequestParam(required = false) String password) {
        if (password == null) {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        } else if (!password.equals(cinema.getPassword())) {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        } else {
            int number_of_available_seats = 81;
            int current_income = 0;
            int number_of_purchased_tickets = 0;
            for (int i = 0; i < cinema.getCinemaHall().size(); i++) {
                if (cinema.getCinemaHall().get(i).isBooked()) {
                    number_of_available_seats -= 1;
                    current_income += cinema.getCinemaHall().get(i).getPrice();
                    number_of_purchased_tickets += 1;
                }
            }
            return new ResponseEntity<>(new Statistics(number_of_available_seats, current_income, number_of_purchased_tickets), HttpStatus.OK);
        }
    }
}