package com.api.produto.model;


import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUTO")
@Data
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal quantidade;

    @NotNull
    private BigDecimal valor;

}
