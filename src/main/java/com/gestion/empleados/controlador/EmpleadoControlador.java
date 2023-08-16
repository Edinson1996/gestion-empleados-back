package com.gestion.empleados.controlador;

import com.gestion.empleados.modelo.Empleado;

import com.gestion.empleados.servicio.EmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class EmpleadoControlador {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public Iterable<Empleado> listarTodosLosEmpleados() {
        return this.empleadoService.getEmpleado();

    }

    @PostMapping("/empleados")
    //@ResquestBody es para enviar ese objeto en formato json
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return this.empleadoService.newEmpleado(empleado);
    }

    //este metodo sirve para buscar un empleado
    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = this.empleadoService.getIdEmpleado(id);
        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleado) {
        // Aquí puedes setear el ID en el objeto empleado antes de llamar a modifyEmpleado
        empleado.setId(id);
        return this.empleadoService.modifyEmpleado(empleado);
    }


    //este metodo sirve para eliminar un empleado
    @DeleteMapping("/empleados/{id}")
    public boolean deleteEmpleado(@PathVariable Long id) {
        return this.empleadoService.deleteEmpleado(id);
    }

}