package my.mapkn3.Orders.model;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements PrettyEntity {
    private Long id;
    private Long position;
    private Product product;
    private Long count;
    private Order order;

    public OrderDetail() {}

    public OrderDetail(Long position, Product product, Long count, Order order) {
        this(0L, position, product, count, order);
    }

    public OrderDetail(Long id, Long position, Product product, Long count, Order order) {
        this.id = id;
        this.position = position;
        this.product = product;
        this.count = count;
        this.order = order;
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
    @Column(name = "position", nullable = false)
    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_serial_number", referencedColumnName = "serial_number")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
