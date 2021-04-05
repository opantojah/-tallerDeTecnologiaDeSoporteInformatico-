package com.example.demo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controlador {
    private String ubicacionJson;
    private String ubicacionCsv;

    @Autowired
    private ManejadorDeArchivosCSV archivoCSV;

    public Controlador() {
        this.archivoCSV = new ManejadorDeArchivosCSV();
        this.ubicacionCsv = "src/main/resources/files/calles.csv";
        this.ubicacionJson = "src/main/resources/files/asentamientos.json";
    }

    @GetMapping("/")
    public String index() {
        return "inicio";
    }

    @RequestMapping(value = "/datos/csv",method = RequestMethod.GET)
    public ResponseEntity<Object> enviarDatosCSV(){
        ManejadorDeArchivosCSV data = new ManejadorDeArchivosCSV();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @RequestMapping(value = "/datos/json",method = RequestMethod.GET)
    public ResponseEntity<Object> enviarDatosJson(){
        HashMap<String, Object> dataFormatoParaEnviar = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        ArrayList data;
        try {
            data = mapper.readValue(new File(this.ubicacionJson), ArrayList.class);

            dataFormatoParaEnviar.put("DataAsentamientos", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(dataFormatoParaEnviar,HttpStatus.OK);
    }

}

