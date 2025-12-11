package ca.saultcollege.lab5.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PUBLICATION")
public abstract class PublicationEntity extends ProductEntity {

    @Column
    private String publisher;

    public PublicationEntity() {
        super();
    }

    public PublicationEntity(String name, double price, String publisher) {
        super(name, price);
        this.publisher = publisher;
    }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    @Override
    public String toString() {
        return "Publication{" +
                super.toString() +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

