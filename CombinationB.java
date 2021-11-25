//Combination Box Level
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      PrintCombination(0,n,k,0,"");
      List<List<Integer>> res = new ArrayList<>();
      GetCombination(1,n,k,new ArrayList<Integer>(),res);
      System.out.println(res);
    }
    
    public static void PrintCombination(int cntn,int n,int k,int cnti,String asf){
        if(cntn == n){
            if(cnti == k){
                System.out.println(asf);
            }
            return;
        }
        PrintCombination(cntn+1,n,k,cnti+1,asf+(cnti+1));
        PrintCombination(cntn+1,n,k,cnti,asf+0);
    }
    
    public static void GetCombination(int cntn,int n,int k,List<Integer> L1,List<List<Integer>> L2){
            if(L1.size()==k){
                L2.add(new ArrayList<>(L1));
                return;
            }
            
           if(cntn > n){ 
            return;
           }
        
        L1.add(cntn);
        GetCombination(cntn+1,n,k,new ArrayList<>(L1),L2);
        L1.remove(L1.size()-1);
        GetCombination(cntn+1,n,k,new ArrayList<>(L1),L2);
    }
}