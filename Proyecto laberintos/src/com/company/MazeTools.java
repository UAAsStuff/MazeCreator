package com.company;

import java.util.ArrayList;
import java.util.Random;

public class MazeTools {
    /**
     * Crea las aristas que unen a todos los vértices del laberinto
     * @param n
     */
    public static ArrayList<Edge> makeDistance(int n){
        ArrayList<Edge> list;
        Random rd;
        rd = new Random();
        list = new ArrayList<Edge>();
        for(int i = 1; i <= 2*n-1; i+=2){
            for(int j = 1; j <= 2*n-1; j+=2){
                if(i+2 <= 2*n-1)
                    //Genera las distancias entre los nodos de manera aleatoria.
                    list.add(new Edge(i,i+2,j,j,1 + Math.abs(rd.nextInt((int)System.currentTimeMillis())%1001)));
                if(j+2 <= 2*n-1)
                    list.add(new Edge(i,i,j,j+2, 1 + Math.abs(rd.nextInt((int)System.currentTimeMillis())%1001)));
            }
        }
        return list;
    }

    /**
     * Con ayuda de un autómata valida si la cadena de texto cumple con el lenguaje de las direcciones del laberinto.
     * @param s
     * @return
     */
    public static boolean belongToAlphabet(String s){
        ArrayList<GraphNode> automaton;
        char[] path;
        path = s.toCharArray();
        GraphNode here;
        //Creamos el autómata
        automaton = new ArrayList<GraphNode>();
        automaton.add(new GraphNode(false));
        automaton.add(new GraphNode(true));
        automaton.add(new GraphNode(false));
        here = automaton.get(0);

        for(char c : path){
            if(here == automaton.get(0)){
                switch(c){
                    case 'a':
                    case 'A':
                    case 'w':
                    case 'W':
                    case 's':
                    case 'S':
                    case 'd':
                    case 'D':
                        here = automaton.get(1);
                        break;
                    default:
                        here = automaton.get(2);
                }
            }else if(here == automaton.get(1)){
                switch(c){
                    case 'a':
                    case 'A':
                    case 'w':
                    case 'W':
                    case 's':
                    case 'S':
                    case 'd':
                    case 'D':
                        continue;
                    default:
                        here = automaton.get(2);
                }
            }else{
                continue;
            }
        }
        return here.terminal;
    }

    private static class GraphNode{
        public GraphNode(boolean b){
            this.terminal = b;
        }
        boolean terminal;
    }
}
