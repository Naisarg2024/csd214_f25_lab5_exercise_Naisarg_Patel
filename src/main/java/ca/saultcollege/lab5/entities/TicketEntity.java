package ca.saultcollege.lab5.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TICKET")
public class TicketEntity extends ProductEntity {

    @Column
    private String eventName;

    @Column
    private String venue;

    public TicketEntity() {
        super();
    }

    public TicketEntity(String name, double price, String eventName, String venue) {
        super(name, price);
        this.eventName = eventName;
        this.venue = venue;
    }

    public String getEventName() { return eventName; }

    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getVenue() { return venue; }

    public void setVenue(String venue) { this.venue = venue; }

    @Override
    public String toString() {
        return "Ticket{" +
                super.toString() +
                ", eventName='" + eventName + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}
