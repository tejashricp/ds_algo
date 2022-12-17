package model;

public class Edge {
    public int wt;
    public int src;
    public int nbr;

    public Edge(int v1, int v2,int wt) {
        this.wt = wt;
        this.src = v1;
        this.nbr = v2;
    }

    public Edge(int v1, int v2) {
        this.wt = wt;
        this.src = v1;
        this.nbr = v2;
    }
}