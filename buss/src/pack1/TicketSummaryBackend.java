package pack1;

import java.util.UUID;

public class TicketSummaryBackend {
    private String ticketId;
    private String ticketDetails;

    public String generateTicketID() {
        this.ticketId = UUID.randomUUID().toString();
        return ticketId;
    }

    public void setTicketDetails(String details) {
        this.ticketDetails = details;
    }

    public String getTicketSummary() {
        return "Ticket ID: " + ticketId + "\nDetails: " + ticketDetails;
    }

    public String cancelOperation() {
        ticketId = null;
        ticketDetails = null;
        return "System Close";
    }
}
