package mx.com.cst.appear.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "echoController")
@RequestScoped
public class EchoController {

    private static final Logger logger =
            Logger.getLogger(EchoController.class.getName());

    private String texto;

    public String envio(){

        logger.log(Level.INFO,"Enviando petición");

        return null;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

