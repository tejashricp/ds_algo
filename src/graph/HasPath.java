package graph;

import model.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//represent graph
//1. array list of adj node
//2. array list of edges, alternative map



public class HasPath {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("/Users/tejashripathrikar/Documents/ds_algo/data/graph.txt"));
        int vertices = Integer.parseInt(input.nextLine());

        List<Edge>[] graph = buildGraph(vertices, input);

        int src = 0;
        int dest = 6;
        boolean[] visited = new boolean[vertices];
        System.out.println(hasPath(graph, src, dest, visited));
    }

    private static List<Edge>[] buildGraph(int vertices, Scanner input) {
        int edges = Integer.parseInt(input.nextLine());

        List<Edge> graph[] = new ArrayList[vertices];

        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<edges;i++){
            String[] split = input.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);

            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        return graph;
    }

    private static boolean hasPath(List<Edge>[] graph, int src, int dest, boolean[] visited) {
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                boolean hasPath = hasPath(graph, e.nbr, dest, visited);
                if(hasPath)
                    return true;
            }
        }
        return false;
    }
}
