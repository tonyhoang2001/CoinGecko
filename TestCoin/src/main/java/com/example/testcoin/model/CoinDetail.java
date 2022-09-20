package com.example.testcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coin_detail")
public class CoinDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "coinDetail")
    private Description description;
    @OneToMany(mappedBy = "coinDetail")
    private List<Ticket> tickets;
    @OneToOne(mappedBy = "coinDetail")
    private Coin coin;
}
