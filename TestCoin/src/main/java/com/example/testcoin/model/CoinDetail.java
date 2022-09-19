package com.example.testcoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    private String id;
    private Description description;
//    private List<Ticket> tickets;
    @OneToOne(mappedBy = "coinDetail")
    private Coin coin;
}
