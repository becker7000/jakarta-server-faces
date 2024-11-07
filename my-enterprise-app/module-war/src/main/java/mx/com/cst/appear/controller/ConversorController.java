package mx.com.cst.appear.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="conversorController")
@SessionScoped
public class ConversorController implements Serializable {

    private Logger logger = Logger.getLogger(ConversorController.class.getName());
    private double temperatura;
    private String opcion;
    private String resultado;

    @PostConstruct
    public void init(){
        this.temperatura=0;
        this.resultado="Sin resultado";
        logger.log(Level.INFO,"Valores iniciales: {0}",String.format("temp: %.3f y result: %s",temperatura,resultado));
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void hacerConversion(){

        double temp_aux;

        switch (opcion){

            case "gradosCgradosF" -> {
                temp_aux= temperatura*1.8+32;
                setResultado(String.format(" %.3f °C son equivalentes a %.3f °F",temperatura,temp_aux));
            }

            case "gradosFgradosC" -> {
                temp_aux= (temperatura-32)/(1.8);
                setResultado(String.format(" %.3f °F son equivalentes a %.3f °C",temperatura,temp_aux));
            }

            case "gradosKgradosC" -> {
                temp_aux= temperatura-273.15;
                setResultado(String.format(" %.3f °K son equivalentes a %.3f °C",temperatura,temp_aux));
            }

            case "gradosCgradosK" -> {
                temp_aux= temperatura+273.15;
                setResultado(String.format(" %.3f °C son equivalentes a %.3f °K",temperatura,temp_aux));
            }

            case "gradosFgradosK" -> {
                temp_aux= (5/9)*(temperatura-32)+273.15;
                setResultado(String.format(" %.3f °F son equivalentes a %.3f °K",temperatura,temp_aux));
            }

            case "gradosKgradosF" -> {
                temp_aux= 1.8*(temperatura-273.15)+32;
                setResultado(String.format(" %.3f °K son equivalentes a %.3f °F",temperatura,temp_aux));
            }

        }

    }

}
