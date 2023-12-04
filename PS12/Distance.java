import java.util.*;
import java.io.*;

public class Distance {
    public static void main(String[] args) {        
        
        int n = 1000000;
       
        
        Graphl graph = new Graphl(n);
        
        File file = new File("C:/Git/Data_Structures_and_Algorithms/PS12/web.txt");
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextInt()) {
                int src = scan.nextInt();

                int dst = scan.nextInt();
    
                // if(from.size() == 0){  
                   
                //     from.add(src);
                //     to.add(dst);
                //     graph.Mark[current] = src;
                //     graph.setEdge(current, dst, 1);
                //     //continue;
                // }
                // else if(src == from.get(from.size()-1)){
                    
                //     from.add(src);
                //     to.add(dst);
                //     graph.setEdge(current, dst, 1);
                // }
                // else{
                //     ++current;
                //     from.add(src);
                //     to.add(dst);
                //     graph.setEdge(current, dst, 1);
                //     graph.Mark[current] = src;
                    
                //}
                //if(src == 29387)
                   // System.out.println("here");
                graph.setEdge(src, dst, 1);

                
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        
        //System.out.println(Arrays.toString(graph.Mark));

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

    static int BFS(Graphl graph, int s, int target){
        // initalize visited, queue arrays
        // 

        ArrayList<Integer> visited = new ArrayList<>();

        
        int d = 0;
        
        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(s);

        Iterable<Integer> neighbors = new ArrayList<>();
        

        while(!Q.isEmpty()){
            int num = Q.size();
            
            //System.out.println("num: " + num);
            while(num > 0){
                num--;
                //System.out.println("Q size: " + Q.size());
                int v = Q.poll();
                
                if (visited.contains(v)){
                    continue;    
                }
                if(v == target){
                    return d;
                }
                
                visited.add(v);
                
                
                //int indexOfV = getIndex(graph, graph.n(), v);
               // graph.setEdge(v, 10, 1);
                neighbors = graph.neighbors(v);
                //System.out.println(neighbors);
                
                // put each neighbor into queue 
                for(Integer neighbor: neighbors){
                    Q.add(neighbor);
                }
                
            } 

            d++;
        }

        //System.out.println(visited);
        return -1;
    }    
}
