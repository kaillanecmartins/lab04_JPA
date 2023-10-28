package com.ifma.transportadora.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Frete {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoFrete;
    
    @ManyToOne
    @JoinColumn(name = "codigo_cidade")
    private Cidade cidadeDestino;
    
    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;
    
    private String descricao;
    private Float peso;
    private Float valor;
}
