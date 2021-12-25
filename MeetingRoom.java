import java.util.*;
class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start=start;
        this.end=end;
    }
}

public class MyClass {
    public static class Comp implements Comparator<Interval>{
        public int compare(Interval obj1 , Interval obj2){
            return obj1.start - obj2.start;
        }
    }
    public static void main(String args[]) {
     ArrayList<Interval> AL = new ArrayList<>();
     AL.add(new Interval(5,8));
     AL.add(new Interval(9,15));
     AL.add(new Interval(15,20));
     System.out.println(canAttend(AL));
    }
    
    public static boolean canAttend(ArrayList<Interval> AL){
         Collections.sort(AL,new Comp());
         boolean flag = false;
         int prevend =0;
         for(int i=0;i<AL.size();i++){
             if(prevend > AL.get(i).start){
                 return false;
             }
             else{
              prevend = AL.get(i).end;   
             }
         }
         return true;
         
    }
}
