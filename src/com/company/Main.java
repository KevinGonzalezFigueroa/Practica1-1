package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public final static String separador = ",";
    public final static String rutaDelArchivo = "C:\\Users\\Kevin\\Desktop\\";
    public final static String nombreDelArchivo = "Listado de nombres aleatorios.csv";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader((rutaDelArchivo + nombreDelArchivo)));

            String linea = br.readLine();

            String[] campos = linea.split(separador);

            linea = br.readLine();

            while (linea != null) {

                campos = linea.split(separador);

                System.out.println(Arrays.toString(campos));

                linea = br.readLine();

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }

