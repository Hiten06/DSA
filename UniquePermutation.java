//Unique permutation using box level
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      HashMap<Character,Integer> hm = new HashMap<>();
      for(int i=0;i<s.length();i++){
          if(hm.containsKey(s.charAt(i))){
              hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
          }
          else{
              hm.put(s.charAt(i),1);
          }
      }
      UniquePermute(hm,0,s.length()-1,"");
    }
    public static void UniquePermute(HashMap<Character,Integer> hm , int cntn,int len,String asf){
        if(cntn > len){
            System.out.println(asf);
            return;
        }
        for(Character ch : hm.keySet()){
            if(hm.get(ch) > 0){
                hm.put(ch,hm.get(ch)-1);
                UniquePermute(hm,cntn+1,len,asf+ch);
                hm.put(ch,hm.get(ch)+1);
            }
        }

    }
}