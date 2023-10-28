package com.ifma.transportadora.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.ifma.transportadora.modelo.Frete;
import com.ifma.transportadora.repositorio.FreteRepository;

public class TesteFrete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab04_test");
        EntityManager em = emf.createEntityManager();

        FreteRepository freteRepository = new FreteRepository(em);

        Frete frete = new Frete();
        frete.setDescricao("Entrega rápida");
        frete.setPeso(10.0f);
        frete.setValor(freteRepository.calcularValorFrete(frete)); 

        freteRepository.salvarFrete(frete);

        Frete freteRecuperado = freteRepository.buscarFrete(frete.getCodigoFrete());
        System.out.println("Frete Recuperado: " + freteRecuperado.getDescricao());

        em.close();
        emf.close();
    }
}
