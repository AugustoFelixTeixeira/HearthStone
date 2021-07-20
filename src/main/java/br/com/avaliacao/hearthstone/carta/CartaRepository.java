/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.hearthstone.carta;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b2ml
 */
@Repository
public interface CartaRepository extends JpaRepository<CartaEntity, Integer> {

    @Query(value = "SELECT * FROM CARTA_ENTITY WHERE id = ?1 and nome = COALESCE(:?2)", nativeQuery = true)
    public List<CartaEntity> findCartas(int id, String nome);

    @Query(value = "SELECT * FROM CARTA_ENTITY WHERE nome ILIKE %:nome%", nativeQuery = true)
    public List<CartaEntity> getCartaByNome(@Param("nome") String nome);

    public List<CartaEntity> getCartaByTipo(CartaEntity.Tipo tipo);

    public List<CartaEntity> getCartaByClasse(CartaEntity.Classe classe);

}
