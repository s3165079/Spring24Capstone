// Genre.java
// 2/19/2024
// L. Nguyen and W. Money
// POJO class to define Accommodation entity


package edu.fscj.cen3024c.gamepup.entity;


import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accommodation")
public class Accommodation {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "acc_id", nullable = false)
    private int accId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "accommodation")
    private Set<GameAccommodation> gameAccommodations;

    @Column(name = "acc_type", nullable = false)
    private String accType;

    @Column(name = "acc_desc", nullable = false)
    private String accDesc;

    public Accommodation() {
    }

    public Accommodation(String accType, String accDesc) {
        this.accType = accType;
        this.accDesc = accDesc;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccDesc() {
        return accDesc;
    }

    public void setAccDesc(String accDesc) {
        this.accDesc = accDesc;
    }

    public void addGameAccommodation(GameAccommodation gameAcc) {
        gameAccommodations.add(gameAcc);
        gameAcc.setAccommodation(this);
    }

    public void removeGameAccommodation(GameAccommodation gameAcc) {
        gameAccommodations.remove(gameAcc);
        gameAcc.setAccommodation(null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accId, accType, accDesc);
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "accId=" + accId +
                ", accType='" + accType + '\'' +
                ", accDesc='" + accDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return accId == that.accId &&
                Objects.equals(accType, that.accType) &&
                Objects.equals(accDesc, that.accDesc);
    }
}
