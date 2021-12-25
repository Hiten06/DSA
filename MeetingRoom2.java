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
    public static class CompStart implements Comparator<Interval>{
        public int compare(Interval obj1 , Interval obj2){
            return obj1.start - obj2.start;
        }
    }
    
     public static class CompEnd implements Comparator<Interval>{
        public int compare(Interval obj1 , Interval obj2){
            return obj1.end - obj2.end;
        }
    }
    public static void main(String args[]) {
     ArrayList<Interval> AL = new ArrayList<>();
     AL.add(new Interval(5,8));
     AL.add(new Interval(9,15));
     AL.add(new Interval(15,20));
     System.out.println(MeetRooms(AL));
    }
    static int GlobalC =0;
    public static int MeetRooms(ArrayList<Interval> AL){
         int size = AL.size();
         Collections.sort(AL,new CompStart());
         int[] strt = new int[AL.size()];
         for(int i=0;i<AL.size();i++){
             strt[i]= AL.get(i).start;
         }
         Collections.sort(AL,new CompEnd());
         int[] end = new int[AL.size()];
         for(int i=0;i<AL.size();i++){
             end[i]=AL.get(i).end;
         }
         int ptr1 = 0,ptr2=0;
         int localc = 0;
    
         while(ptr1 < size  && ptr2< size){
             if(strt[ptr1] < end[ptr2]){
                 localc++;
                 GlobalC=Math.max(localc,GlobalC);
                
                 ptr1++;
             }
             else if(strt[ptr1] > end[ptr2]){
                 localc--;
                 GlobalC=Math.max(localc,GlobalC);
                 ptr2++;
             }
             else if(strt[ptr1] == end[ptr2]){
                 ptr2++;
                 localc++;
                 GlobalC=Math.max(localc,GlobalC);
             }
         }
         return GlobalC;
         
    }
}
