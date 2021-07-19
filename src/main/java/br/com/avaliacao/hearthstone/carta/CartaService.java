/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.hearthstone.carta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author b2ml
 */
@Service
public class CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    //Retorna todas as cartas
    public void getAll() {
        cartaRepository.findAll();
    }

    //Retorna uma determinada carta
    public void save(CartaEntity carta) {
        cartaRepository.save(carta);
    }
}
