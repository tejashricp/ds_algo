package graph;

import model.Edge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MultipleGraphPathProblem {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/Users/tejashripathrikar/Documents/ds_algo/data/graph.txt"));
        int vertices = Integer.parseInt(in.nextLine());

        List<Edge>[] graph = buildGraph(in, vertices);

        int src = 0;
        int dest = 6;
        int k = 3;
        int criteria = 40;
        boolean[] visited = new boolean[vertices];
        multiSolver(graph, src, dest, visited, k, criteria, 0);

        System.out.println("smallest "+smallest);
        System.out.println("largest "+largest);
        System.out.println("3rd largest "+minHeap.peek());
    }

    static int smallest = Integer.MAX_VALUE;
    static int largest = Integer.MIN_VALUE;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static void multiSolver(List<Edge>[] graph, int src, int dest, boolean[] visited, int k, int criteria, int wsf) {
        if(src == dest){
            System.out.println(wsf + " ");
            if(wsf < smallest){
                smallest = wsf;
            }
            if(wsf > largest){
                largest = wsf;
            }

            if(minHeap.size() < k){
                minHeap.add(wsf);
            }
            else if(minHeap.peek() < wsf){
                minHeap.remove();
                minHeap.add(wsf);
            }
        }


        visited[src] = true;
        for(Edge e:graph[src]){
            if(visited[e.nbr] == false){
                multiSolver(graph, e.nbr, dest, visited, k, criteria, wsf+e.wt);
            }
        }
        visited[src] = false;
    }

    private static List<Edge>[] buildGraph(Scanner in, int vertices) {
        List<Edge>[] graph = new ArrayList[vertices];
        int edges = Integer.parseInt(in.nextLine());

        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0;i<edges;i++){
            String[] split = in.nextLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);
            int wt = Integer.parseInt(split[2]);

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }
        return graph;
    }

}
