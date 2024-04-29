package br.com.fiap.financaspro.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.financaspro.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    Page<Movimentacao> findByCategoriaNome(String categoria, Pageable pageable);

    @Query("SELECT m FROM Movimentacao m WHERE MONTH(m.data) = ?1") 
    Page<Movimentacao> findByMes(Integer mes, Pageable pageable);
    
    @Query("SELECT m FROM Movimentacao m WHERE MONTH(m.data) = :mes AND m.categoria.nome = :categoria") 
    Page<Movimentacao> findByCategoriaNomeAndMes( @Param("categoria") String categoria, @Param("mes") Integer mes, Pageable pageable);

    Movimentacao findFirstByOrderByValor();

    
}
