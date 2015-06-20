package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Edge> nuevo;
        Scanner reader;
        String path;
        int mazeSize;
        reader = new Scanner(System.in);
        do{
            System.out.println("tamanho del laberinto: ");
            mazeSize = reader.nextInt();
        }while(mazeSize < 2);
        nuevo = MazeTools.makeDistance(mazeSize);
        SpanningTree sp;
        sp = new SpanningTree(nuevo);
        Maze niu = new Maze(mazeSize, sp.lista);
        niu.createPaths();
        System.out.println(niu.toString());
        System.out.println("Escribe el camino del inicio ╬ a la salida »");
        System.out.println("Arriba -> W/w\nAbajo -> S/s\nIzquierda -> A/a\nDerecha -> D/d");
        System.out.println();
        System.out.println();
        reader.nextLine();
        path = reader.nextLine();
        if(MazeTools.belongToAlphabet(path)){
            //System.out.printf(niu.toString());
            System.out.println((niu.pathAutomaton(path)? "Ganaste" : "Perdiste"));
        }else{
            System.out.println("Camino no válido.");
        }
    }

}
