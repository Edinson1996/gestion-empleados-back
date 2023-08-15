package com.gestion.empleados.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado {
    @JsonIgnore
    private HibernateProxy hibernateLazyInitializer;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre",length = 60,nullable = false)
    private String nombre;
    @Column(name = "apellido",length = 60,nullable = false)
    private String apellido;
    @Column(name = "email",length = 60,nullable = false,unique = true)
    private String email;

    public Empleado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
