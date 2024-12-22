package pack1;

public class RouteSelectionBackend {
    private String selectedRoute;
    private String selectedDate;
    private String selectedTime;

    public void selectRoute(String route) {
        this.selectedRoute = route;
    }

    public void selectDate(String date) {
        this.selectedDate = date;
    }

    public void selectTime(String time) {
        this.selectedTime = time;
    }

    public boolean isSelectionComplete() {
        return selectedRoute != null && selectedDate != null && selectedTime != null;
    }

    public String cancelOperation() {
        this.selectedRoute = null;
        this.selectedDate = null;
        this.selectedTime = null;
        return "System Close";
    }
}
