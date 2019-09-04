import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Math;

//Just copied from problem 56
//can do some performance improvements

public class B57_InsertIntervals{

    //second implementation 14ms runtime
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> output = new ArrayList<>();
        int index = 0;

        //add all elements less than newInterval
        while(index < intervals.size() && lessThan(intervals.get(index), newInterval)){
            output.add(intervals.get(index));
            index++;
        }

        //add newInterval
        //no overlap
        if(output.isEmpty() || output.get(output.size() - 1).end < newInterval.start){

            output.add(newInterval);

        //some overlap
        } else {

            output.get(output.size() - 1).end = Math.max(output.get(output.size() - 1).end, newInterval.end);

        }

        //add the rest of the elements
        while(index < intervals.size()){

            //no overlap
            if(output.isEmpty() || output.get(output.size() - 1).end < intervals.get(index).start){

                output.add(intervals.get(index));

            //some overlap
            } else {

                output.get(output.size() - 1).end = Math.max(output.get(output.size() - 1).end, intervals.get(index).end);

            }

            index++;
        }

        return output;
    }

    public static boolean lessThan(Interval iterator, Interval newInterval){
        return iterator.start < newInterval.start ||
                (iterator.start == newInterval.start && iterator.end < newInterval.end);
    }

    //19ms runtime
    //this implementation works but is not optimized
    //it just adds the newInterval to the list and then uses the solution from Problem 56
    //this works since p56 has to sort the results anyway

    /*
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        intervals.add(newInterval);
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
    */

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

    //Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void test(){

        List<Interval> myList = new ArrayList<>();

        myList.add(new Interval(1,2));
        myList.add(new Interval(3,5));
        myList.add(new Interval(6,7));
        myList.add(new Interval(8,10));
        myList.add(new Interval(12,16));

        myList = insert(myList, new Interval(4,8));

        for(Interval iterator : myList){
            System.out.printf("[%d %d] ", iterator.start, iterator.end);
        }
    }
}