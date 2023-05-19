package com.ufmt.farmapro.estoque;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EstoqueRepository 
    extends JpaRepositoryImplementation<Estoque, Integer> {
 
}