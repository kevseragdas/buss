package pack1;

import java.util.HashSet;

public class SeatSelectionBackend {
    private HashSet<Integer> bookedSeats = new HashSet<>();
    private int selectedSeat;

    public boolean isSeatAvailable(int seatNumber) {
        return !bookedSeats.contains(seatNumber);
    }

    public boolean bookSeat(int seatNumber) {
        if (isSeatAvailable(seatNumber)) {
            bookedSeats.add(seatNumber);
            this.selectedSeat = seatNumber;
            return true;
        }
        return false;
    }

    public String cancelOperation() {
        this.selectedSeat = -1;
        return "System Close";
    }
}
