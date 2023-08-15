package com.gestion.empleados.servicio;

import com.gestion.empleados.modelo.Empleado;



public interface EmpleadoService {

    Empleado newEmpleado(Empleado newEmpleado);
    Iterable<Empleado> getEmpleado();

    Empleado modifyEmpleado(Empleado empleado);

    Boolean deleteEmpleado(Long idEmpleado);

    Empleado getIdEmpleado(Long idEmpleado);


}
