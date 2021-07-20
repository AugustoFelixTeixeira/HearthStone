/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.hearthstone.carta;

import java.util.List;
import java.util.Optional;
import org.json.JSONObject;
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
    public List<CartaEntity> getAll() {
        return cartaRepository.findAll();
    }

    //Retorna todas as cartas
    public Optional<CartaEntity> getCartaById(int id) {
        return cartaRepository.findById(id);
    }

    //buscar uma carta por nome
    public List<CartaEntity> getCartaByNome(String nome) {
        return cartaRepository.getCartaByNome(nome);
    }

    //buscar carta por tipo
    public List<CartaEntity> getCartaByTipo(CartaEntity.Tipo tipo) {
        return cartaRepository.getCartaByTipo(tipo);
    }

    //buscar carta por classe
    public List<CartaEntity> getCartaByClasse(CartaEntity.Classe classe) {
        return cartaRepository.getCartaByClasse(classe);
    }

    //Retorna uma determinada carta
    public void save(CartaEntity carta) {
        cartaRepository.save(carta);
    }

    //Deletar uma carta
    public void delete(int id) {
        cartaRepository.deleteById(id);
    }

    //metodo de validação de dados da carta
    public JSONObject validarCarta(CartaEntity carta) {
        JSONObject resposta = new JSONObject();
        JSONObject mensagens = new JSONObject();

        if (carta.getNome() == null || carta.getNome().isEmpty()) {
            mensagens.put("nome", "não pode ser nulo ou vazio.");
        }

        if (carta.getDescricao() == null || carta.getDescricao().isEmpty()) {
            mensagens.put("descricao", "não pode ser nulo ou vazio.");
        }

        if (carta.getAtaque() > 10 || carta.getAtaque() < 0) {
            mensagens.put("ataque", "deve estar entre 0 e 10.");
        }

        if (carta.getDefesa() > 10 || carta.getDefesa() < 0) {
            mensagens.put("defesa", "deve estar entre 0 e 10.");
        }

        resposta.put("erro", mensagens);
        return resposta;
    }
}
