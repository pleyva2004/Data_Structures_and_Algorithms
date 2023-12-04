import java.util.*;
import java.io.*;

public class Distance {
    public static void main(String[] args) {        
        ArrayList<Integer> from = new ArrayList<>();
        ArrayList<Integer> to = new ArrayList<>();
        
        int n = 739454;
        int current = 0;
        
        Graphl graph = new Graphl(n);
        
        File file = new File("D:/Git/Data_Structures_and_Algorithms/PS12/testing.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()) {
                int src = scan.nextInt();
                int dst = scan.nextInt();
    
                if(from.size() == 0){  
                   
                    from.add(src);
                    to.add(dst);
                    graph.Mark[current] = src;
                    graph.setEdge(current, dst, 1);
                    //continue;
                }
                else if(src == from.get(from.size()-1)){
                    
                    from.add(src);
                    to.add(dst);
                    graph.setEdge(current, dst, 1);
                }
                else{
                    ++current;
                    from.add(src);
                    to.add(dst);
                    graph.setEdge(current, dst, 1);
                    graph.Mark[current] = src;
                    
                }

                
                
                
                
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        //System.out.println(Arrays.toString(graph.Mark));

        Scanner robo = new Scanner(System.in);
            int fromInput = robo.nextInt();
            int toInput = robo.nextInt();

            
            while(fromInput >= 0){
                int distance = 0;
                int fromIndex = getIndex(graph, n, fromInput);


                Iterable<Integer> neighbors = new ArrayList<>();
                neighbors = graph.neighbors(fromIndex);
                //System.out.println(graph.neighbors(fromIndex));
                
                
                
                for(Integer neighbor: neighbors){


                    fromIndex = getIndex(graph, n, neighbor);
                    System.out.println(graph.neighbors(fromIndex));
                }



                fromInput = robo.nextInt();
        //     boolean path = graph.isEdge(fromIndex, toInput);

            
            //BFS(graph, fromIndex);


            // if (graph.isEdge(fromIndex, toInput)){
            //     System.out.println("distance " + String.valueOf(distance));
            //     fromInput = robo.nextInt(); 
            //     toInput = robo.nextInt();        
            // }
            // else
            //     System.out.println(String.valueOf(toInput) + " is unreachable from " + fromInput);
            //     fromInput = robo.nextInt();
            //     toInput = robo.nextInt();
               
                
        }
        
        robo.close();
    }

    static int getIndex(Graphl graph, int n, int fromInput){
        int fromIndex = 0;
        for(int i = 0; i< n; i++){
            if(graph.Mark[i] == fromInput){
                fromIndex = i;
                break;
                }
            }
        
        return fromIndex;
        
    }

    static int BFS(Graph G, int s){
        ArrayList<Integer> visited = new ArrayList<>();
        visited.add(s);
        int d = 0;

        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(s);

        while(!Q.isEmpty()){
            d++;
            int v = Q.poll();

            for (int w = G.first(v); w < G.n(); w = G.next(v, w))
                if (G.getMark(w) == 0) { // Put neighbors on Q
                    G.setMark(w, G.getMark(v) + 1);
                    Q.add(w);
                    visited.add(w);
                }

        }

        System.out.println(visited);
        return d;
    }




    // static int BFS(int d; inttoInputgoal){

    //     if(current = goal)
    //         return
    //     else if(d = -1)
    //         return -1
    //     else if(current.hasNeighbors)
    //         BFS(d++; nextNeightbor, goal)
        
    //     //be called oon every child until   

    // }


}