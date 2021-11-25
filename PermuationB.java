//Box Level Permutation
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int k = sc.nextInt();
     PrintPermutationBoxLevel(0,n,k,0,"",new boolean[k]);
     List<List<Integer>> res = new ArrayList<>();
     GetPermutationBoxLevel(0,n,k,0,new ArrayList<Integer>(),res,new boolean[k]);
     System.out.println(res);
    }
    
    public static void PrintPermutationBoxLevel(int cntn,int n,int k,int cnti,String asf,boolean[] itemplaced){
          if(cntn == n){
            if(cnti == k){
                System.out.println(asf);}
                return;
            }
            
        for(int i=0;i<k;i++){
            if(itemplaced[i]==false){
                itemplaced[i]= true;
                PrintPermutationBoxLevel(cntn+1,n,k,cnti+1,asf+(i+1),itemplaced);
                itemplaced[i]=false;
            }
        }
        PrintPermutationBoxLevel(cntn+1,n,k,cnti,asf+"0",itemplaced);
    }
    
    public static void GetPermutationBoxLevel(int cntn,int n,int k,int cnti,List<Integer> L1,List<List<Integer>> L2,boolean[] itemplaced){
    
            if(cnti == k){
                L2.add(new ArrayList<>(L1));
                return;
            }
    
        
        //System.out.println(L1);
        for(int i=0;i<k;i++){
            if(itemplaced[i] == false){
                itemplaced[i]=true;
                L1.add(i+1);
                GetPermutationBoxLevel(cntn+1,n,k,cnti+1,L1,L2,itemplaced);
                L1.remove(L1.size()-1);
                itemplaced[i]=false;
            }
        }
        //GetPermutationBoxLevel(cntn+1,n,k,cnti+1,L1,L2,itemplaced);
        }
    }

