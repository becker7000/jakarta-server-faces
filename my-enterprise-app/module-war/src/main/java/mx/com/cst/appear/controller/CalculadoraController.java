package mx.com.cst.appear.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="calculadoraController")
// @RequestScoped // Crea un objeto del ManagedBean con cada petición (Primero probar con esta anotación)
@SessionScoped // Se crea un objeto del ManagedBean por todas las peticiones de una sesión
public class CalculadoraController implements Serializable { // con SessionScope se debe seríalizar

    // Traza en el servidor (despues de crear calcularResultado)
    // Sirven para debugear
    private static final Logger logger =
            Logger.getLogger(CalculadoraController.class.getName());

    private double x;
    private double y;
    private double resultado;
    private String operacion;
    private List<SelectItem> listaOperaciones;

    @PostConstruct
    public void init(){
        x = 0.0;
        y = 0.0;
        resultado = 0.0;
        operacion = "";
        llenarLista(); // Hasta despues de crear el método
        // Fijamos la severidad de mensaje (informativo)
        logger.log(Level.INFO,"Inicio de atributos concluido...");
    }

    // Crear hasta despues de probar elemento por elemento
    public void llenarLista(){
        listaOperaciones = new ArrayList<>();
        listaOperaciones.add(new SelectItem("Suma"));
        listaOperaciones.add(new SelectItem("Resta"));
        listaOperaciones.add(new SelectItem("Multiplica"));
        listaOperaciones.add(new SelectItem("Divide"));
    }

    public void calcularResultado(){
        switch (operacion){
            case "Suma" -> setResultado(x+y);
            case "Resta" -> setResultado(x-y);
            case "Multiplica" -> setResultado(x*y);
            case "Divide" -> {
                if(y!=0.0){
                    setResultado(x/y);
                }else{
                    logger.log(
                            Level.INFO,
                            "No se puede dividir por cero"
                    ); // Usamos interpolación para enviar un valor al mensaje del logger

                    // Creamos un mensaje para mostrar en la vista de la calculadora
                    FacesMessage mensajeErrorDiv = new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "No se puede dividir por cero",
                            "El divisor no puede ser cero"
                    );

                    // Obtenemos la instancia actual que está invocando a este Managed bean
                    // El primer parametro asocia un id, el segundo el mensaje
                    FacesContext.getCurrentInstance().addMessage(null,  mensajeErrorDiv);

                }
            }
        }

        if(!(operacion.equals("Divide") && y==0)){
            FacesMessage mensajeExito = new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Operación realiza correctamente",
                    "Operación realiza correctamente"
            );
            FacesContext.getCurrentInstance().addMessage(null,  mensajeExito);
        }

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public List<SelectItem> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(List<SelectItem> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }
}
