package com.company;


import java.util.ArrayList;

public class Maze {
    private int size;
    private ArrayList<Edge> list;
    private int[][] maze;

    public Maze(int n, ArrayList<Edge> list){
        this.list = list;
        this.size = n;
        //La matriz se inicializa en 0s
        this.maze = new int[2*n+1][2*n+1];
    }

    public void createPaths(){
        for(Edge n : list){
            this.maze[n.x1][n.y1] = 1;
            this.maze[n.x2][n.y2] = 1;
            this.maze[n.x1 + (n.x2-n.x1)/2][n.y1 + (n.y2-n.y1)/2] = 1;
        }
        this.maze[0][1] = 3;
        this.maze[2*size-1][2*size] = 4;
    }

    public boolean pathAutomaton(String s){
        char[] path = s.toLowerCase().toCharArray();
        Coordinate xy;
        xy = new Coordinate(1,0);
        for(char c : path){
            switch (c){
                case 'w':
                    if(xy.y-1 >= 0 ){
                        if(this.maze[xy.y-1][xy.x] == 1 || this.maze[xy.y-1][xy.x] == 2)
                           xy.y -= 1;
                        if(this.maze[xy.y][xy.x] == 1)
                            this.maze[xy.y][xy.x] = 2;
                    }
                    break;
                case 's':
                    if(this.maze[xy.y+1][xy.x] == 1 || this.maze[xy.y+1][xy.x] == 2)
                    {
                        xy.y += 1;
                        if(this.maze[xy.y][xy.x] == 1)
                            this.maze[xy.y][xy.x] = 2;
                    }

                    break;
                case 'a':
                    if(this.maze[xy.y][xy.x-1] == 1 || this.maze[xy.y][xy.x-1] == 2)
                    {
                        xy.x -= 1;
                        if(this.maze[xy.y][xy.x] == 1)
                            this.maze[xy.y][xy.x] = 2;
                    }

                    break;
                case 'd':
                    if(xy.x+1 < 2*size+1) {
                        if (this.maze[xy.y][xy.x + 1] == 1 || this.maze[xy.y][xy.x + 1] == 4)
                        {
                            xy.x += 1;
                            if(this.maze[xy.y][xy.x] == 1)
                                this.maze[xy.y][xy.x] = 2;
                        }

                    }
                    break;
            }
        }
        return (this.maze[xy.y][xy.x] == 4? true : false);
    }

    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < 2*size+1; i++){
            for(int j = 0; j < 2*size+1; j++){
                if(this.maze[i][j] == 0)
                    s += "█";           //Pared
                else if(this.maze[i][j] == 1)
                    s += "░";           //Camino
                else if(this.maze[i][j] == 3)
                    s += "╬";            //Personaje
                else if(this.maze[i][j] == 2)
                    s += "≡";
                else
                    s += "»";             //Salida
            }
            s += "\n";
        }
        return s;
    }

    private class Coordinate{
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }
}
