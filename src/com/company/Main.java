package com.company;

import java.io.*;
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

            String[] listado = new String[79];

            linea = br.readLine();

            int contador = 0;

            while (linea != null) {

                campos = linea.split(separador);

                listado[contador] = Arrays.toString(campos);
                contador++;

                linea = br.readLine();

            }

            String[] nombresSeleccionados = new String[10];
            for (int i = 0; i <= 9; i++) {
                int valorEntero = (int) Math.floor(Math.random()*(listado.length-0)+1);
                nombresSeleccionados[i] = listado[valorEntero].substring(1, listado[valorEntero].length()-1);
            }

            String[] notasYNombres = new String[10];

            for (int i = 0; i <= 9 ; i++) {
                double valorAleatorio1 = Math.random()*(10-0)+0;
                double valorAleatorio2 = Math.random()*(10-0)+0;
                double valorAleatorio3 = Math.random()*(10-0)+0;
                double valorAleatorio4 = Math.random()*(10-0)+0;
                notasYNombres[i] = nombresSeleccionados[i] + ", " + Math.floor(valorAleatorio1 * 100)/100 + ", " + Math.floor(valorAleatorio2 * 100)/100 + ", " +
                        Math.floor(valorAleatorio3 * 100)/100 + ", " + Math.floor(valorAleatorio4 * 100)/100 + ", " + Math.floor(((Math.floor(valorAleatorio1 * 100)/100 +
                        Math.floor(valorAleatorio2 * 100)/100 + Math.floor(valorAleatorio3 * 100)/100 + Math.floor(valorAleatorio4 * 100)/100)/4)*100)/100;

            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaDelArchivo+"prueba.txt"));
            bw.write("Nombre, Nota1, Nota2, Nota3, Nota4, notaMedia");
            bw.newLine();

            for (int i = 0; i <= 9; i++){
                bw.write(notasYNombres[i]);
                bw.newLine();
            }
            bw.close();
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

