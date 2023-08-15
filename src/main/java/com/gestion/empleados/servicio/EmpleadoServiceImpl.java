package com.gestion.empleados.servicio;

import com.gestion.empleados.modelo.Empleado;
import com.gestion.empleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    @Override
    public Empleado newEmpleado(Empleado newEmpleado) {
        return this.empleadoRepositorio.save(newEmpleado);
    }

    @Override
    public Iterable<Empleado> getEmpleado() {
        return this.empleadoRepositorio.findAll();
    }

    @Override

    public Empleado modifyEmpleado(Empleado empleado) {
        Optional<Empleado> empleadoEncontrado = this.empleadoRepositorio.findById(empleado.getId());
        if (empleadoEncontrado.isPresent()) {
            Empleado empleadoExistente = empleadoEncontrado.get();
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setEmail(empleado.getEmail());
            return this.newEmpleado(empleadoExistente);
        }
        return null;
    }


    @Override
    public Boolean deleteEmpleado(Long idEmpleado) {
         this.empleadoRepositorio.deleteById(idEmpleado);
         return true;
    }

    @Override
    public Empleado getIdEmpleado(Long idEmpleado) {
    return  this.empleadoRepositorio.getById(idEmpleado);


    }
}
