package graph;

import model.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindPath {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/tejashripathrikar/Documents/ds_algo/data/graph.txt"));
        int vertices = Integer.parseInt(in.nextLine());

        List<Edge>[] graph = buildGraph(vertices, in);

        int src = 0;
        int dest = 6;
        boolean[] visited = new boolean[vertices];
        printAllPaths(graph, src, dest, visited, ""+src);
    }

    private static void printAllPaths(List<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if(src == dest){
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        for(Edge e:graph[src]){
            if(visited[e.nbr] == false){
                printAllPaths(graph, e.nbr, dest, visited, psf + e.nbr);
            }
        }

        visited[src] = false;
    }

    private static List<Edge>[] buildGraph(int vertices, Scanner in) {
        List<Edge>[] graph = new ArrayList[vertices];
        int edges = Integer.parseInt(in.nextLine());

        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<edges;i++){
            String[] split = in.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        return graph;
    }


}
