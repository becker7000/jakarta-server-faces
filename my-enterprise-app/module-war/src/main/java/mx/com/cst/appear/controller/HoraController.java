package mx.com.cst.appear.controller;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value="horaController")
@ViewScoped
public class HoraController implements Serializable {

    private static final Logger logger =
            Logger.getLogger(HoraController.class.getName());

    private String hora;

    @PostConstruct
    public void init(){
        logger.log(Level.INFO,"Iniciando hora controller");
        hora = new GregorianCalendar().getTime().toString();
    }

    public String getHora() {
        return new GregorianCalendar().getTime().toString();
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
