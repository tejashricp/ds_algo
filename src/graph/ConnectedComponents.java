package graph;

import model.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedComponents {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/tejashripathrikar/Documents/ds_algo/data/graph.txt"));
        int vertices = Integer.parseInt(in.nextLine());
        List<Edge>[] graph = buildGraph(in, vertices);

        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        for(int i=0;i<vertices;i++) {
            if(visited[i] == false) {
                List<Integer> comp = new ArrayList<>();
                getComponents(graph, i, comp, visited);
                components.add(comp);
            }
        }

        for(List<Integer> comp:components){
            for(Integer i:comp){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void getComponents(List<Edge>[] graph, int src, List<Integer> components, boolean[] visited) {
        components.add(src);

        visited[src] = true;
        for(Edge e:graph[src]){
            if(visited[e.nbr] == false) {
                getComponents(graph, e.nbr, components, visited);
            }
        }

    }

    private static List<Edge>[] buildGraph(Scanner in, int vertices) {
        int edges = Integer.parseInt(in.nextLine());
        List<Edge> graph[] = new ArrayList[vertices];
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
