package com.tallerdelujo;

import com.tallerdelujo.enums.*;
import javax.swing.JOptionPane;

public class App {

    private static ManejoVisuales visuales = new ManejoVisuales();

    public static void main(String[] args) {
        Configuraciones cnf = new Configuraciones();
        int opcionMenu = 0;
        String datoStr;

        do {

            // Seleccion de datos al usuario con modal.
            datoStr = JOptionPane.showInputDialog(null,
                    "Selecciona un ítem:\n\n"
                    + "1- Entidad Cliente\n"
                    + "2- Entidad Vehiculo\n"
                    + "3- Entidad Empleado\n"
                    + "4- Vehiculos atendidos X empleado\n"
                    + "5- SALIR",
                    "MENÚ", JOptionPane.INFORMATION_MESSAGE);

            // Se valida que el dato ingresado por el usuario sea de 1 solo digito y entre 1
            // y 5 con expresiones regulares.
            if (datoStr.matches("^[12345]{1}$")) {
                opcionMenu = Integer.parseInt(datoStr);

                seleccionItem(opcionMenu);
            } else {
                // Mensaje de error en caso de seleccionar un valor de menu incorrecto.
                JOptionPane.showMessageDialog(null, "Valor no valido, sólo seleccionar entre 1 y 5.");
            }

        } while (opcionMenu != 5);
    }

    public static void seleccionItem(int menuItem) {

        if (menuItem < 4) {
            int opcionMenu = 0, dato;
            String datoStr;
            boolean seleccionInvalida = true;

            do {

                // Seleccion de datos al usuario con modal.
                datoStr = JOptionPane.showInputDialog(null,
                        "Selecciona una funcionalidad CRUD:\n\n"
                        + "1- Create\n"
                        + "2- Read\n"
                        + "3- Update\n"
                        + "4- Delete",
                        "MENÚ", JOptionPane.INFORMATION_MESSAGE);

                // Se valida que el dato ingresado por el usuario sea de 1 solo digito y entre 1
                // y 4 con expresiones regulares.
                if (datoStr.matches("^[1234]{1}$")) {
                    dato = Integer.parseInt(datoStr);
                    opcionMenu = dato;
                    seleccionInvalida = false;
                } else {
                    // Mensaje de error en caso de seleccionar un valor de menu incorrecto.
                    JOptionPane.showMessageDialog(null, "Valor no valido, sólo seleccionar entre 1 y 4.");
                }

            } while (seleccionInvalida);

            TipoEntidades entidad = visuales.numAEntidad(menuItem);
            switch (opcionMenu) {
                case 1:
                    visuales.seleccionCrud(TipoCrud.CREATE,entidad);
                    break;

                case 2:
                    visuales.seleccionCrud(TipoCrud.SELECT,entidad);
                    break;

                case 3:
                    visuales.seleccionCrud(TipoCrud.UPDATE,entidad);
                    break;

                case 4:
                    visuales.seleccionCrud(TipoCrud.DELETE,entidad);
                    break;
            }
        } else {
            System.out.println("Por implementar.");
        }
    }



    

}
