package ca.saultcollege.lab5.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("MAGAZINE")
public class MagazineEntity extends PublicationEntity {

    @Column
    private int issueNumber;

    public MagazineEntity() {
        super();
    }

    public MagazineEntity(String name, double price, String publisher, int issueNumber) {
        super(name, price, publisher);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }

    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public String toString() {
        return "Magazine{" +
                super.toString() +
                ", issueNumber=" + issueNumber +
                '}';
    }
}

