/*
 * Lab11 starter code; description in Lab11.pdf.
 */

import java.util.LinkedList;
import java.util.Random;
import java.util.Arrays;


public class RandomGraph {

public static void main(String[] args) {

    int n = 30; // number of vertices
    double p = 0.08;  // probability that an edge is present
    long seed = 971; // pseudo-random number generator seed
    Random rng = new Random(seed);
    Graphm graph = new Graphm(n);  // use the adjacency matrix implementation
 
    // create a random graph; each edge present with probability p
    for(int i=0;i<n;++i){
        graph.setMark(i, 0);
        for(int j=i+1;j<n;++j){
            double u = rng.nextDouble();
            if(u < p){
               graph.setEdge(i,j,1);
               graph.setEdge(j,i,1);
      System.out.println("setedge "+i+", "+j);
            }
        }
    }

    System.out.println("Adjacency matrix:");
    for(int i=0;i<n;++i){
        for(int j=0;j<n;++j){
            if(graph.isEdge(i,j))
               System.out.print("1 ");
            else
               System.out.print("0 ");
        }
        System.out.println();
    }


    partOne(graph);

    String[][] distances = new String[n][n];


    for(int i = 0; i < n; i++){
      resest(graph);
      //System.out.println(Arrays.toString(graph.Mark));

      BFS(graph, i);
      //System.out.println(Arrays.toString(graph.Mark));
      for(int j = 0; j < n; j ++){
          if(graph.Mark[j] == 0)
            distances[i][j] = "x";
          else
            distances[i][j] = String.valueOf(graph.Mark[j] - 1);
      }
    }

    for(String[] row : distances){
      for(String col: row){
        System.out.print(col+ " ");
      }
      System.out.println();
    }



    

  }


  /** Depth first search */
  static void DFS(Graph G, int v) {
    PreVisit(G, v); // Take appropriate action
    G.setMark(v, 1);
    for (int w = G.first(v); w < G.n(); w = G.next(v, w))
      if (G.getMark(w) == 0)
        DFS(G, w);
    PostVisit(G, v); // Take appropriate action
  }

  /** Breadth first (queue-based) search */
  static void BFS(Graph G, int start) {
    LinkedList<Integer> Q = new LinkedList<Integer>();
    Q.addLast(start);
    G.setMark(start, 1);
    int d = 0;
    while (Q.size() > 0) { // Process each vertex on Q
      ++d;
      int v = Q.removeFirst();
      PreVisit(G, v); // Take appropriate action
      for (int w = G.first(v); w < G.n(); w = G.next(v, w))
        if (G.getMark(w) == 0) { // Put neighbors on Q
          G.setMark(w, G.getMark(v) + 1);
          Q.addLast(w);
        }
      PostVisit(G, v); // Take appropriate action
    }
  }

  static void PreVisit(Graph G, int v) {
    //System.out.println("");
  }

  static void PostVisit(Graph G, int v) {
    //System.out.println("");
  }

  static void partOne(Graphm graph){
    BFS(graph, 0);

    for(int i = 0; i < graph.Mark.length; i++){
      if( graph.Mark[i] == 0)
        BFS(graph, i);
    }
    
    int count = 0;
    for(int m : graph.Mark){
      if(m == 1)
        count++;
    }
    System.out.println("Number of connected components: " + count);

  }

  static void resest(Graphm graph){
    for(int i = 0; i < graph.n(); i ++){
      graph.Mark[i] = 0;
    }
  }
}
