package mx.com.cst.appear.controller;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.*;

@RequestScoped
@Named(value="automovilController")
public class AutomovilController {

    // Atributos con validaciones usando anotaciones de Bean Validation
    @NotEmpty(message = "La marca es obligatoria")
    //@Size(min = 2, max = 50, message = "La marca debe tener entre 2 y 50 caracteres")
    private String marca;

    @NotEmpty(message = "El modelo es obligatorio")
    private String modelo;

    @Min(value = 1990, message = "El año debe ser mayor o igual a 1990")
    @Max(value = 2025, message = "El año debe ser menor o igual a 2025")
    private int anio;

    @Size(min = 3, max = 30, message = "El color debe tener entre 3 y 30 caracteres")
    private String color;

    @Pattern(regexp = "^[0-9]{10}$",message = "El teléfono debe tener 10 dígitos")
    private String telefono;

    @Pattern(
            regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "El correo electrónico no es válido")
    private String email;

    // Métodos Getter y Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Acción para guardar el automóvil
    public String guardarAuto() {
        // Lógica de guardar el automóvil, aquí solo simula un mensaje de éxito
        System.out.printf(
                """
                    
                    Datos del automovil:
                    Marca: %s
                    Modelo: %s
                    Anio: %d
                    Color: %s
                    Telefono del propietario: %s
                    Email del propietario: %s
                """,marca,modelo,anio,color,telefono,email
        );
        return "EXITO"; // Puede redirigir a otra página si es necesario
    }
}

