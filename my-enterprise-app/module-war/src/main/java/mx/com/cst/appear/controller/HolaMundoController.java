package mx.com.cst.appear.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.Map;

@Named(value="holaMundoController") // Checar clean code
@RequestScoped
public class HolaMundoController {

    private String mensaje;
    private String saludo;

    // Marca un método de inicialización
    @PostConstruct // Se ejecuta inmediatamente después de crear el objeto
    public void init(){
        mensaje="Hola mundo desde un ManageBean";
    }

    public void crearSaludo(){
        Map<String,String> parametros = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        saludo = "Bievenido "+parametros.get("nombre");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
