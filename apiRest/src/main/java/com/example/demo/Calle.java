package com.example.demo;

import java.util.ArrayList;

public class Calle {
    private String altura_fin_derecha;
    private String altura_fin_izquierda;
    private String altura_inicio_derecha;
    private String altura_inicio_izquierda;
    private String categoria;
    private String departamento_id;
    private String departamento_nombre;
    private String fuente;
    private String id;
    private String localidad_censal_id;
    private String localidad_censal_nombre;
    private String nombre;
    private String provincia_id;
    private String provincia_nombre;

    public Calle(String[] data){
        this.altura_fin_derecha = data[0];
        this.altura_fin_izquierda = data[1];
        this.altura_inicio_derecha = data[2];
        this.altura_inicio_izquierda = data[3];
        this.categoria = data[4];
        this.departamento_id = data[5];
        this.departamento_nombre = data[6];
        this.fuente = data[7];
        this.id = data[8];
        this.localidad_censal_id = data[9];
        this.localidad_censal_nombre = data[10];
        this.nombre = data[11];
        this.provincia_id = data[12];
        this.provincia_nombre = data[13];
    }

}
