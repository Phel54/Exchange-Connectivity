package com.kepf.Exchangeconnectivity.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "orders")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String exchange_order_id;

    @ManyToOne
    @JoinColumn( referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String side;

    @Column(nullable = false)
    private String product;

    @Column(columnDefinition = "boolean  default false")
    private Boolean is_valid;

    @Column(columnDefinition = "boolean  default true")
    private Boolean is_pending;

    @Column(columnDefinition = "boolean  default false")
    private Boolean is_success;
    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;





}

