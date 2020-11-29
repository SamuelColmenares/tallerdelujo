package com.tallerdelujo;

import java.io.InputStream;
import java.util.Properties;

public class Configuraciones {

    public static Properties config = null;

    public Configuraciones() {
        if (config == null) {
            cargarConfiguraciones();
        }
    }

    private void cargarConfiguraciones() {
        InputStream configInput = null;
        config = new Properties();

        try {
            configInput = ClassLoader.getSystemResourceAsStream("config.properties");
            config.load(configInput);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
