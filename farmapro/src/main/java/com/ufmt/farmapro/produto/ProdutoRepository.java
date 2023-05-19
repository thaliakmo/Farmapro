package com.ufmt.farmapro.produto;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ProdutoRepository 
    extends JpaRepositoryImplementation<Produto, Integer> {
 
}