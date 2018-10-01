package my.mapkn3.Orders.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order implements PrettyEntity {
    private Long id;
    private String customerName;
    private String customerAddress;
    private Long totalAmountOfOrder;
    private Date creationDate;

    public Order() {}

    public Order(String customerName, String customerAddress, Long totalAmountOfOrder, Date creationDate) {
        this(0L, customerName, customerAddress, totalAmountOfOrder, creationDate);
    }

    public Order(Long id, String customerName, String customerAddress, Long totalAmountOfOrder, Date creationDate) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.totalAmountOfOrder = totalAmountOfOrder;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_name", nullable = false)
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_address", nullable = false)
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "total_amount_of_order", nullable = false)
    public Long getTotalAmountOfOrder() {
        return totalAmountOfOrder;
    }

    public void setTotalAmountOfOrder(Long totalAmountOfOrder) {
        this.totalAmountOfOrder = totalAmountOfOrder;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Order {id=" + this.id +
                ", customerName=" + this.customerName +
                ", customerAddress=" + this.customerAddress +
                ", totalAmountOfOrder=" + this.totalAmountOfOrder +
                ", creationDate=" + this.creationDate +
                "}";
    }
}
