package ca.saultcollege.lab5.entities;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DISCMAG")
public class DiscMagEntity extends MagazineEntity {

    @Column
    private String discType;

    public DiscMagEntity() {
        super();
    }

    public DiscMagEntity(String name, double price, String publisher,
                         int issueNumber, String discType) {
        super(name, price, publisher, issueNumber);
        this.discType = discType;
    }

    public String getDiscType() { return discType; }

    public void setDiscType(String discType) { this.discType = discType; }

    @Override
    public String toString() {
        return "DiscMag{" +
                super.toString() +
                ", discType='" + discType + '\'' +
                '}';
    }
}

