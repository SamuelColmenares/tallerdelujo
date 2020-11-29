/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tallerdelujo;

import com.tallerdelujo.entidades.*;
import com.tallerdelujo.enums.TipoCrud;
import com.tallerdelujo.enums.TipoEntidades;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Samu-Pc
 */
public class ManejoVisuales {

    private static BaseDatos base = new BaseDatos();

    public TipoEntidades numAEntidad(int item) {
        switch (item) {
            case 1:
                return TipoEntidades.CLIENTE;

            case 2:
                return TipoEntidades.VEHICULO;

            default:
                return TipoEntidades.EMPLEADO;
        }
    }

    public void seleccionCrud(TipoCrud crud, TipoEntidades entidad) {
        switch (crud) {
            case SELECT:
                String datoStr = JOptionPane.showInputDialog(null,
                        "Escribe el ID para uno solo elemento o vacio para todos.",
                        JOptionPane.INFORMATION_MESSAGE);
                visualizaSelect(datoStr, entidad);
                break;

            case UPDATE:
                String datoStrUpd = JOptionPane.showInputDialog(null,
                        "Escribe el ID a actualizar.",
                        JOptionPane.INFORMATION_MESSAGE);
                visualizaUpdate(datoStrUpd, entidad);
                break;

        }
    }

    private void visualizaSelect(String id, TipoEntidades entidad) {
        switch (entidad) {
            case CLIENTE:
                ArrayList<Cliente> clientes = id.equals("") ? base.obtenerTodosClientes() : base.obtenerCliente(Integer.parseInt(id));

                if (clientes == null || clientes.size() < 1) {
                    JOptionPane.showMessageDialog(null, "No hay clientes registrados.\n");
                } else {
                    String[] columnas = {"ID CLIENTE", "NOMBRE", "APELLIDO", "TIPO PAGO", "TELEFONO"};
                    Object filas[][] = new Object[clientes.size()][5];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i][0] = clientes.get(i).getCliente();
                        filas[i][1] = clientes.get(i).getNombre();
                        filas[i][2] = clientes.get(i).getApellido();
                        filas[i][3] = clientes.get(i).getTipoPago();
                        filas[i][4] = clientes.get(i).getTelefono();
                    }

                    JTable table = new JTable(filas, columnas);
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                break;

            case EMPLEADO:
                ArrayList<Empleado> empleados = id.equals("") ? base.obtenerTodosEmpleados() : base.obtenerEmpleado(Integer.parseInt(id));

                if (empleados == null || empleados.size() < 1) {
                    JOptionPane.showMessageDialog(null, "No hay empleados registrados.\n");
                } else {
                    String[] columnas = {"ID EMPLEADO", "NOMBRE", "APELLIDO", "CARGO", "DIRECCION", "TELEFONO"};
                    Object filas[][] = new Object[empleados.size()][6];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i][0] = empleados.get(i).getIdEmpleado();
                        filas[i][1] = empleados.get(i).getNombre();
                        filas[i][2] = empleados.get(i).getApellido();
                        filas[i][3] = empleados.get(i).getCargo();
                        filas[i][4] = empleados.get(i).getDireccion();
                        filas[i][5] = empleados.get(i).getTelefono();
                    }

                    JTable table = new JTable(filas, columnas);
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                break;

            case VEHICULO:
                ArrayList<Vehiculo> vehiculos = id.equals("") ? base.obtenerTodosVehiculos() : base.obtenerVehiculo(Integer.parseInt(id));

                if (vehiculos == null || vehiculos.size() < 1) {
                    JOptionPane.showMessageDialog(null, "No hay vehiculos registrados.\n");
                } else {
                    String[] columnas = {"ID MATRICULA", "MARCA", "MODELO", "CHASIS"};
                    Object filas[][] = new Object[vehiculos.size()][4];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i][0] = vehiculos.get(i).getIdMatricula();
                        filas[i][1] = vehiculos.get(i).getMarca();
                        filas[i][2] = vehiculos.get(i).getModelo();
                        filas[i][3] = vehiculos.get(i).getChasis();
                    }

                    JTable table = new JTable(filas, columnas);
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                break;
        }
    }

    private void visualizaUpdate(String id, TipoEntidades entidad) {
        if (id.isBlank()) {
            JOptionPane.showMessageDialog(null, "id Invalido.\n");
            return;
        }

        switch (entidad) {
            case CLIENTE:
                JTextField nombreClField = new JTextField(5);
                JTextField apellidoClField = new JTextField(5);
                JTextField tipoPagoClField = new JTextField(5);
                JTextField telefonoField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Nombre:"));
                myPanel.add(nombreClField);
                myPanel.add(Box.createHorizontalStrut(15));
                myPanel.add(new JLabel("Apellido:"));
                myPanel.add(apellidoClField);
                myPanel.add(Box.createHorizontalStrut(15));
                myPanel.add(new JLabel("Tipo Pago:"));
                myPanel.add(tipoPagoClField);
                myPanel.add(Box.createHorizontalStrut(15));
                myPanel.add(new JLabel("Telefono:"));
                myPanel.add(telefonoField);

                int resultadoMod = JOptionPane.showConfirmDialog(null, myPanel,
                        "Ingresa los datos de cliente a actualizar", JOptionPane.OK_CANCEL_OPTION);
                if (resultadoMod == JOptionPane.OK_OPTION) {
                    ArrayList<Cliente> clientes = base.actualizarCliente(
                            Integer.parseInt(id),
                            nombreClField.getText(),
                            apellidoClField.getText(),
                            tipoPagoClField.getText(),
                            Integer.parseInt(telefonoField.getText()));

                    if (clientes == null || clientes.size() < 1) {
                        JOptionPane.showMessageDialog(null, "Hubo un error al actualizar. No existe el ID.\n");
                    } else {
                        String[] columnas = {"ID CLIENTE", "NOMBRE", "APELLIDO", "TIPO PAGO", "TELEFONO"};
                        Object filas[][] = new Object[clientes.size()][5];
                        for (int i = 0; i < filas.length; i++) {
                            filas[i][0] = clientes.get(i).getCliente();
                            filas[i][1] = clientes.get(i).getNombre();
                            filas[i][2] = clientes.get(i).getApellido();
                            filas[i][3] = clientes.get(i).getTipoPago();
                            filas[i][4] = clientes.get(i).getTelefono();
                        }

                        JTable table = new JTable(filas, columnas);
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al actualizar desde el panel.\n");
                }
                break;

            case EMPLEADO:
                JTextField nombreEmField = new JTextField(5);
                JTextField apellidoEmField = new JTextField(5);
                JTextField cargoEmField = new JTextField(5);
                JTextField direccionEmField = new JTextField(5);
                JTextField telefonoEmField = new JTextField(5);

                JPanel myPanelEm = new JPanel();
                myPanelEm.add(new JLabel("Nombre:"));
                myPanelEm.add(nombreEmField);
                myPanelEm.add(Box.createHorizontalStrut(15));
                myPanelEm.add(new JLabel("Apellido:"));
                myPanelEm.add(apellidoEmField);
                myPanelEm.add(Box.createHorizontalStrut(15));
                myPanelEm.add(new JLabel("Cargo:"));
                myPanelEm.add(cargoEmField);
                myPanelEm.add(Box.createHorizontalStrut(15));
                myPanelEm.add(new JLabel("Direccion:"));
                myPanelEm.add(direccionEmField);
                myPanelEm.add(Box.createHorizontalStrut(15));
                myPanelEm.add(new JLabel("Telefono:"));
                myPanelEm.add(telefonoEmField);

                int resultadoEm = JOptionPane.showConfirmDialog(null, myPanelEm,
                        "Ingresa los datos de empleado a actualizar", JOptionPane.OK_CANCEL_OPTION);

                if (resultadoEm == JOptionPane.OK_OPTION) {
                    ArrayList<Empleado> empleados = base.actualizarEmpleado(
                            Integer.parseInt(id),
                            nombreEmField.getText(),
                            apellidoEmField.getText(),
                            cargoEmField.getText(),
                            direccionEmField.getText(),
                            Integer.parseInt(telefonoEmField.getText()));

                    if (empleados == null || empleados.size() < 1) {
                        JOptionPane.showMessageDialog(null, "Hay un error actualizando clientes. No existe el ID.\n");
                    } else {
                        String[] columnas = {"ID EMPLEADO", "NOMBRE", "APELLIDO", "CARGO", "DIRECCION", "TELEFONO"};
                        Object filas[][] = new Object[empleados.size()][6];
                        for (int i = 0; i < filas.length; i++) {
                            filas[i][0] = empleados.get(i).getIdEmpleado();
                            filas[i][1] = empleados.get(i).getNombre();
                            filas[i][2] = empleados.get(i).getApellido();
                            filas[i][3] = empleados.get(i).getCargo();
                            filas[i][4] = empleados.get(i).getDireccion();
                            filas[i][5] = empleados.get(i).getTelefono();
                        }

                        JTable table = new JTable(filas, columnas);
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al actualizar desde el panel.\n");
                }
                break;

            case VEHICULO:
                JTextField marcaVeField = new JTextField(5);
                JTextField modeloVeField = new JTextField(5);
                JTextField chasisVeField = new JTextField(5);

                JPanel myPanelVe = new JPanel();
                myPanelVe.add(new JLabel("Marca:"));
                myPanelVe.add(marcaVeField);
                myPanelVe.add(Box.createHorizontalStrut(15));
                myPanelVe.add(new JLabel("Modelo:"));
                myPanelVe.add(modeloVeField);
                myPanelVe.add(Box.createHorizontalStrut(15));
                myPanelVe.add(new JLabel("Chasis:"));
                myPanelVe.add(chasisVeField);

                int resultadoVe = JOptionPane.showConfirmDialog(null, myPanelVe,
                        "Ingresa los datos de empleado a actualizar", JOptionPane.OK_CANCEL_OPTION);

                if (resultadoVe == JOptionPane.OK_OPTION) {
                    ArrayList<Vehiculo> vehiculos = base.actualizarVehiculo(
                            Integer.parseInt(id),
                            marcaVeField.getText(),
                            Integer.parseInt(modeloVeField.getText()),
                            Long.parseLong(chasisVeField.getText()));

                    if (vehiculos == null || vehiculos.size() < 1) {
                        JOptionPane.showMessageDialog(null, "No hay vehiculos registrados.\n");
                    } else {
                        String[] columnas = {"ID MATRICULA", "MARCA", "MODELO", "CHASIS"};
                        Object filas[][] = new Object[vehiculos.size()][4];
                        for (int i = 0; i < filas.length; i++) {
                            filas[i][0] = vehiculos.get(i).getIdMatricula();
                            filas[i][1] = vehiculos.get(i).getMarca();
                            filas[i][2] = vehiculos.get(i).getModelo();
                            filas[i][3] = vehiculos.get(i).getChasis();
                        }

                        JTable table = new JTable(filas, columnas);
                        JOptionPane.showMessageDialog(null, new JScrollPane(table));
                    }
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al actualizar desde el panel.\n");
                }
        }
    }

}
