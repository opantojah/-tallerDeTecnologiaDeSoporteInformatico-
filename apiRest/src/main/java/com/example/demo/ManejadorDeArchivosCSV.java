package com.example.demo;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Service
public class ManejadorDeArchivosCSV {

    private String ubicacionArchivo;
    private char separador;

    public ManejadorDeArchivosCSV() {
        this.ubicacionArchivo = "src/main/resources/files/calles.csv";
    }

    public FileReader obtenerArchivo(){
        FileReader reader = null;
        try {
            reader = new FileReader(ubicacionArchivo);
        } catch (FileNotFoundException e) {
            String mensaje = "Archivo no encontrado, verifique el nombre y/o la ubicaión del mismo";
            System.out.println(mensaje);
            e.printStackTrace();
        }
        return reader;
    }

    public HashMap<String, Object> obtenerDataConFormatoDeEnvio(){
        CSVReader reader = new CSVReaderBuilder(this.obtenerArchivo()).build();

        Iterator<String[]> i = reader.iterator();

        ArrayList<Calle> calles = new ArrayList<>();

        HashMap<String, Object> dataFormateada = new HashMap<>();

        while (i.hasNext()){
            String[] fila = i.next();

            Calle calle = new Calle(fila);

            calles.add(calle);
        }

        dataFormateada.put("Data", calles);
        return dataFormateada;
    }

}
