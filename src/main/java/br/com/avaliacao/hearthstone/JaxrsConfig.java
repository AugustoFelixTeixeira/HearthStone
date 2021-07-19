/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.avaliacao.hearthstone;

import br.com.avaliacao.hearthstone.carta.CartaResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author b2ml
 */
@Component
public class JaxrsConfig extends ResourceConfig {

    public JaxrsConfig() {
        register(CartaResource.class);
    }
}
