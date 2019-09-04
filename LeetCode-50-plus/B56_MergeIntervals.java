import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math;

public class B56_MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {

        intervals.sort(new IntervalComparator());

        List<Interval> output = new ArrayList<>();
        
        for(Interval intervalIt : intervals){

            //no overlap
            if(output.isEmpty() || output.get(output.size() - 1).end < intervalIt.start){

                output.add(intervalIt);

            //some overlap
            } else {

                output.get(output.size() - 1).end = Math.max(output.get(output.size() - 1).end, intervalIt.end);

            }
        }

        return output;
    }

    //Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static class IntervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2){
            if (o1.start != o2.start){
                return o1.start - o2.start;
            } else if (o1.end != o2.end){
                return o1.end - o2.end;
            } else {
                return 0;
            }
        }
    }

    public static void test(){
        List<Interval> myList = new ArrayList<>();
        
        myList.add(new Interval(2,6));
        myList.add(new Interval(8,10));
        myList.add(new Interval(15,18));
        myList.add(new Interval(1,3));

        /*
        Test sort method
        myList.add(new Interval(1,4));
        myList.add(new Interval(4,6));
        myList.add(new Interval(2,3));
        myList.sort(myComparator);
        IntervalComparator myComparator = new IntervalComparator();
        */

        myList = merge(myList);
    
        for(Interval iterator : myList){
            System.out.printf("[%d %d] ", iterator.start, iterator.end);
        }
    }
}