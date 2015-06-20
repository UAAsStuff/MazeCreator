/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.util.Comparator;
/**
 *
 * @author Uriel
 */
public class Comparador implements Comparator<Edge>{

    @Override
    public int compare(Edge t, Edge t1) {
        if(t.distance < t1.distance){
        return -1;
        }
        if(t.distance > t1.distance){
        return 1;
        }
        return 0;
    }
    
    
    
}
