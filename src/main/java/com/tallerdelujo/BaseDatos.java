package com.tallerdelujo;

import com.tallerdelujo.entidades.Cliente;
import com.tallerdelujo.entidades.Empleado;
import com.tallerdelujo.enums.*;
import com.tallerdelujo.entidades.Vehiculo;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseDatos {

    private Properties config;

    public BaseDatos() {
        config = new Configuraciones().config;
    }

    // VEHICULOS
    public ArrayList<Vehiculo> obtenerTodosVehiculos() {
        return obtenerVehiculos(-1);
    }

    public ArrayList<Vehiculo> obtenerVehiculo(int idMatricula) {
        return obtenerVehiculos(idMatricula);
    }

    private ArrayList<Vehiculo> obtenerVehiculos(int idMatricula) {
        String filtro = idMatricula > 0 ? " where id_matricula=" + idMatricula : "";
        return (ArrayList<Vehiculo>) ejecutarSelectQuery(TipoCrud.SELECT, TipoEntidades.VEHICULO, filtro);
    }

    public ArrayList<Vehiculo> actualizarVehiculo(int idMatricula, String marca, int modelo, long chasis) {
        ArrayList<Vehiculo> actual = obtenerVehiculo(idMatricula);
        if (actual == null || actual.size() < 1) {
            return null;
        }

        String filtro = "set marca='" + marca + "', ";
        filtro += " modelo=" + modelo + ", ";
        filtro += " chasis=" + chasis;
        filtro += " where id_matricula=" + idMatricula;
        boolean ejecuto = (boolean) ejecutarSelectQuery(TipoCrud.UPDATE, TipoEntidades.VEHICULO, filtro);

        if (ejecuto) {
            return obtenerVehiculo(idMatricula);
        }

        return null;
    }

    public ArrayList<Vehiculo> crearVehiculo(int idMatricula, String marca, int modelo, long chasis) {
        ArrayList<Vehiculo> actual = obtenerVehiculo(idMatricula);
        if (actual.size() > 0) {
            return null;
        }

        String filtro = "(id_matricula,marca,modelo,chasis) values(" + idMatricula + ',';
        filtro += "'" + marca + "', ";
        filtro += "" + modelo + ", ";
        filtro += chasis + ")";
        boolean ejecuto = (boolean) ejecutarSelectQuery(TipoCrud.CREATE, TipoEntidades.VEHICULO, filtro);

        if (ejecuto) {
            return obtenerVehiculo(idMatricula);
        }

        return null;
    }

    public boolean borrarVehiculo(int idMatricula) {
        ArrayList<Vehiculo> actual = obtenerVehiculo(idMatricula);
        if (actual == null || actual.size() < 1) {
            return false;
        }

        String filtro = " where id_matricula=" + idMatricula;
        return (boolean) ejecutarSelectQuery(TipoCrud.DELETE, TipoEntidades.VEHICULO, filtro);
    }

    // CLIENTES
    public ArrayList<Cliente> obtenerTodosClientes() {
        return obtenerClientes(-1);
    }

    public ArrayList<Cliente> obtenerCliente(int id) {
        return obtenerClientes(id);
    }

    private ArrayList<Cliente> obtenerClientes(int id) {
        String filtro = id > 0 ? " where id_cliente=" + id : "";
        return (ArrayList<Cliente>) ejecutarSelectQuery(TipoCrud.SELECT, TipoEntidades.CLIENTE, filtro);
    }

    public ArrayList<Cliente> actualizarCliente(int cliente, String nombre, String apellido, String tipoPago, int telefono) {
        ArrayList<Cliente> actual = obtenerCliente(cliente);
        if (actual == null || actual.size() < 1) {
            return null;
        }

        String filtro = "set nombre='" + nombre + "',";
        filtro += " apellido='" + apellido + "', ";
        filtro += " tipo_pago='" + tipoPago + "', ";
        filtro += " telefono=" + telefono;
        filtro += " where id_cliente=" + cliente + ";";
        boolean ejecuto = (boolean) ejecutarSelectQuery(TipoCrud.UPDATE, TipoEntidades.CLIENTE, filtro);

        if (ejecuto) {
            return obtenerCliente(cliente);
        }

        return null;
    }

    public ArrayList<Cliente> crearCliente(int cliente, String nombre, String apellido, String tipoPago, int telefono) {
        ArrayList<Cliente> actual = obtenerCliente(cliente);
        if (actual.size() > 0) {
            return null;
        }

        String filtro = "(id_cliente,nombre,apellido,tipo_pago,telefono) values(" + cliente + ",";
        filtro += "'" + nombre + ",";
        filtro += "'" + apellido + "', ";
        filtro += "'" + tipoPago + "', ";
        filtro += "" + telefono + ")";

        boolean ejecuto = (boolean) ejecutarSelectQuery(TipoCrud.CREATE, TipoEntidades.CLIENTE, filtro);

        if (ejecuto) {
            return obtenerCliente(cliente);
        }

        return null;
    }

    public boolean borrarCliente(int idCliente) {
        ArrayList<Cliente> actual = obtenerCliente(idCliente);
        if (actual == null || actual.size() < 1) {
            return false;
        }

        String filtro = " where id_cliente=" + idCliente;
        return (boolean) ejecutarSelectQuery(TipoCrud.DELETE, TipoEntidades.CLIENTE, filtro);
    }

    // EMPLEADOS
    public ArrayList<Empleado> obtenerTodosEmpleados() {
        return obtenerEmpleados(-1);
    }

    public ArrayList<Empleado> obtenerEmpleado(int id) {
        return obtenerEmpleados(id);
    }

    private ArrayList<Empleado> obtenerEmpleados(int id) {
        String filtro = id > 0 ? " where id_empleado=" + id : "";
        return (ArrayList<Empleado>) ejecutarSelectQuery(TipoCrud.SELECT, TipoEntidades.EMPLEADO, filtro);
    }

    public ArrayList<Empleado> actualizarEmpleado(int idEmpleado, String nombre, String apellido, String cargo, String direccion, int telefono) {
        ArrayList<Empleado> actual = obtenerEmpleado(idEmpleado);
        if (actual == null || actual.size() < 1) {
            return null;
        }

        String filtro = "set nombre='" + nombre + "',";
        filtro += " apellido='" + apellido + "', ";
        filtro += " cargo='" + cargo + "', ";
        filtro += " direccion='" + direccion + "', ";
        filtro += " telefono=" + telefono;
        filtro += " where id_empleado=" + idEmpleado;
        boolean ejecuto = (boolean) ejecutarSelectQuery(TipoCrud.UPDATE, TipoEntidades.EMPLEADO, filtro);

        if (ejecuto) {
            return obtenerEmpleado(idEmpleado);
        }

        return null;
    }

    public ArrayList<Empleado> crearEmpleado(int idEmpleado, String nombre, String apellido, String cargo, String direccion, int telefono) {
        ArrayList<Empleado> actual = obtenerEmpleado(idEmpleado);
        if (actual.size() > 0) {
            return null;
        }

        String filtro = "(id_empleado,nombre,apellido,cargo,direccion,telefono) values(";
        filtro += idEmpleado + ",";
        filtro += "'" + nombre + "',";
        filtro += "'" + apellido + "', ";
        filtro += "'" + cargo + "', ";
        filtro += "'" + direccion + "', ";
        filtro += telefono + ")";
        boolean ejecuto = (boolean) ejecutarSelectQuery(TipoCrud.CREATE, TipoEntidades.EMPLEADO, filtro);

        if (ejecuto) {
            return obtenerEmpleado(idEmpleado);
        }

        return null;
    }

    public boolean borrarEmpleado(int idEmpleado) {
        ArrayList<Empleado> actual = obtenerEmpleado(idEmpleado);
        if (actual == null || actual.size() < 1) {
            return false;
        }

        String filtro = " where id_empleado=" + idEmpleado;
        return (boolean) ejecutarSelectQuery(TipoCrud.DELETE, TipoEntidades.EMPLEADO, filtro);
    }

    private Object ejecutarSelectQuery(TipoCrud crud, TipoEntidades entidad, String filtro) {
        System.out.println("Conectando a BD...");
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("urlbd"),
                config.getProperty("usuariobd"),
                config.getProperty("passbd"))) {
            Statement s = connection.createStatement();
            String query = "";

            switch (crud) {
                case SELECT:
                    query = "select * from ";
                    break;

                case DELETE:
                    query = "delete from ";
                    break;

                case UPDATE:
                    query = "update ";
                    break;

                case CREATE:
                    query = "insert into ";
                    break;
            }

            switch (entidad) {
                case VEHICULO:
                    query += "vehiculo ";
                    break;

                case EMPLEADO:
                    query += "empleado ";
                    break;

                case CLIENTE:
                    query += "cliente ";
                    break;
            }

            System.out.println(query + filtro);

            if (crud == TipoCrud.UPDATE || crud == TipoCrud.DELETE || crud == TipoCrud.CREATE) {
                boolean resU = s.execute(query);
                s.close();
                connection.close();
                return true;
            }

            ResultSet r = s.executeQuery(query + filtro);

            switch (entidad) {
                case VEHICULO:
                    ArrayList<Vehiculo> resultadoVehiculo = new ArrayList<Vehiculo>();
                    while (r.next()) {
                        resultadoVehiculo.add(new Vehiculo(
                                (int) r.getObject("id_matricula"),
                                (String) r.getObject("marca"),
                                (int) r.getObject("modelo"),
                                (long) r.getObject("chasis")
                        ));
                    }

                    r.close();
                    s.close();
                    connection.close();
                    return resultadoVehiculo;

                case EMPLEADO:
                    ArrayList<Empleado> resultadoEmpleado = new ArrayList<Empleado>();
                    while (r.next()) {
                        resultadoEmpleado.add(new Empleado(
                                (int) r.getObject("id_empleado"),
                                (String) r.getObject("nombre"),
                                (String) r.getObject("apellido"),
                                (String) r.getObject("cargo"),
                                (String) r.getObject("direccion"),
                                (int) r.getObject("telefono")
                        ));
                    }

                    r.close();
                    s.close();
                    connection.close();
                    return resultadoEmpleado;

                case CLIENTE:
                    ArrayList<Cliente> resultadoCliente = new ArrayList<Cliente>();
                    while (r.next()) {
                        resultadoCliente.add(new Cliente(
                                (int) r.getObject("id_cliente"),
                                (String) r.getObject("nombre"),
                                (String) r.getObject("apellido"),
                                (String) r.getObject("tipo_pago"),
                                (int) r.getObject("telefono")
                        ));
                    }

                    r.close();
                    s.close();
                    connection.close();
                    return resultadoCliente;
            }

            return null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
