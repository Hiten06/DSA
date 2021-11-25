//On Item Level
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      printPermutationItem(0,n,k,"",new boolean[n]);
      List<List<Integer>> res = new ArrayList<>();
      getPermutationItem(0,n,k,new ArrayList<Integer>(),res,new boolean[n]);
      System.out.println(res);
    }
    
    public static void printPermutationItem(int cnti,int n,int k,String asf,boolean[] boxes){
        if(cnti == k){
                    System.out.println(asf);
                     return;
            }
            
        for(int i=0;i<n;i++){
            if(boxes[i]==false){
                boxes[i]=true;
                printPermutationItem(cnti+1,n,k,asf+(i+1),boxes);
                boxes[i]=false;
            }
        }
       
    }
    
    public static void getPermutationItem(int cnti,int n,int k,List<Integer> L1,List<List<Integer>> L2,boolean[] boxes){
        if(cnti == k){
            L2.add(new ArrayList<>(L1));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(boxes[i] ==false){
                boxes[i]=true;
                L1.add(i+1);
                getPermutationItem(cnti+1,n,k,L1,L2,boxes);
                L1.remove(L1.size()-1);
                boxes[i]=false;
            }
        }
    }
}