import java.util.*;
import java.io.*;

public class Distance {
    public static void main(String[] args) {        
        
        int n = 1000000;
       
        
        Graphl graph = new Graphl(n);
        
        File file = new File("C:\\Coding\\Repositories\\Data_Structures_and_Algorithms\\PS12\\web.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()) {
                int src = scan.nextInt();

                int dst = scan.nextInt();
    
                graph.setEdge(src, dst, 1);

                
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner robo = new Scanner(System.in);

            
            while(true){
                int fromInput = robo.nextInt();
                int toInput = robo.nextInt();
                if(fromInput == -1 || toInput == -1 )
                    break;

                int distance = BFS(graph, fromInput, toInput);

                
                
                if (distance >= 0)
                    System.out.println("distance " + distance);
                else
                    System.out.println(toInput + " is unreachable from " + fromInput);   
            }   

            robo.close();
        }

    static int BFS(Graphl graph, int s, int target){
        // initalize visited, queue arrays

        boolean[] visited = new boolean[1000000];
        int d = 0;
        
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(s);

        Iterable<Integer> neighbors = new ArrayList<>();
        

        while(!Q.isEmpty()){


            int num = Q.size();
            
           
            while(num > 0){
                num--;
                
                int v = Q.poll();
                
                if (visited[v]){
                    continue;    
                }
                if(v == target){
                    return d;
                }
                
                visited[v] = true; 
                
                neighbors = graph.neighbors(v);
            
                // put each neighbor into queue 
                for(Integer neighbor: neighbors){
                    Q.add(neighbor);
                }
                
            } 

            d++;
        }
        return -1;
    }

}
