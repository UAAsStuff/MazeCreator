/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.util.*;

/**
 *
 * @author Uriel
 */
public class SpanningTree {

    private PriorityQueue<Edge> queue;
    public ArrayList<Edge> lista;
    private ArrayList<Edge> listan;//listan es la lista de los nodos que todavia no estan conectados
    private ArrayList<Node> vec;

    public SpanningTree(ArrayList<Edge> lista) {
        Comparator<Edge> com = new Comparador();
        queue = new PriorityQueue<Edge>(112, com);
        for (Edge n : lista) {
            queue.add(n);
        }
        Method(queue);

    }

    public void Method(PriorityQueue<Edge> queue) {
        Edge n;
        lista = new ArrayList<Edge>();
        vec = new ArrayList<Node>();
        listan = new ArrayList<Edge>();

        n = queue.poll();
        lista.add(n);
        vec.add(new Node(n.x1,n.y1));
        vec.add(new Node(n.x2,n.y2));

        while (!queue.isEmpty()) {
            n = queue.poll();

            if (searching_node(new Node(n.x1, n.y1)) && searching_node(new Node(n.x2, n.y2))) {
                continue;
            } else if (searching_node(new Node(n.x1, n.y1)) || searching_node(new Node(n.x2, n.y2))) {
                lista.add(n);
                if (searching_node(new Node(n.x1, n.y1))) {
                    vec.add(new Node(n.x2, n.y2));
                } else {
                    vec.add(new Node(n.x1, n.y1));
                }

            } else {
                listan.add(n);
                continue;
            }
            if (!listan.isEmpty()) {
                ArrayList<Edge> auxArr;
                auxArr = new ArrayList<Edge>();
                for (Edge e : listan) {
                    if (searching_node(new Node(e.x1, e.y1)) || searching_node(new Node(e.x2, e.y2))) {
                        lista.add(e);
                        auxArr.add(e);
                        if (searching_node(new Node(e.x1, e.y1))) {
                            vec.add(new Node(e.x2, e.y2));
                        } else {
                            vec.add(new Node(e.x1, e.y1));
                        }
                    }
                }
                for(Edge e : auxArr){
                    listan.remove(e);
                }
                
            }
        }
    }

    private Boolean searching_node(Node n) {

        for (Node aux : vec) {
            if (n.x == aux.x && n.y == aux.y) {
                return true;
            }
        }

        return false;
    }

}
