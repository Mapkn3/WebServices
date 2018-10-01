package my.mapkn3.Orders.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product implements PrettyEntity {
    private String serialNumber;
    private String name;
    private String description;
    private Date serialProductionDate;

    public Product() {}

    public Product(String serialNumber, String name, String description, Date serialProductionDate) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.description = description;
        this.serialProductionDate = serialProductionDate;
    }

    @Id
    @Column(name = "serial_number", unique = true, nullable = false)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "serial_production_date", nullable = false)
    public Date getSerialProductionDate() {
        return serialProductionDate;
    }

    public void setSerialProductionDate(Date serialProductionDate) {
        this.serialProductionDate = serialProductionDate;
    }
}
