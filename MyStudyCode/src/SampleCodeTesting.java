import java.util.*;
import java.util.stream.Collectors;

/*

Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.

In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:

In Bakery department: From 8 to 10,
In Checkout department: From 10 to 12
In Diary department: From 14 to 19
Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts.
This will be exposed to the colleague in different UI and help them plan their day accordingly.

His shift timings in this case are 8 to 12 and 14 to 19.

api -> inputs : {{8,10}, {10,12}, {14,19}}
output : {{8,12}, {14,19}}
 */

public class SampleCodeTesting {
  public static void main(String[] args) {
//setup

    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(10,12));
    intervals.add(new Interval(12,19));
    intervals.add(new Interval(8,10));
    intervals = merge(intervals);
    for(Interval interval : intervals) {
      System.out.println(interval.from+" : "+interval.to);
    }
  }

  static class Interval {
    private int from;
    private int to;

    public Interval(int from, int to) {
      this.from = from;
      this.to = to;
    }

    int getFrom() {
      return from;
    }

    void setFrom(final int from) {
      this.from = from;
    }

    int getTo() {
      return to;
    }

    void setTo(final int to) {
      this.to = to;
    }
  }

  private static List<Interval> sortIntervalsBasedOnFromAtoB(List<Interval> input) {
    if(input.isEmpty()) {
      return new ArrayList<>(); // or throw exemption
    }
    input.sort(Comparator.comparingInt(Interval::getFrom));
    return input;
  }

  public static List<Interval> merge(List<Interval> intervals) {
    // Validation skipped of input : satisfying assumptions
    sortIntervalsBasedOnFromAtoB(intervals);

    int start = intervals.get(0).getFrom();
    int end = intervals.get(0).getTo();

    List<Interval> ans = new ArrayList<>();
    for(Interval interval : intervals) {
      if(interval.from <= end) {
        end = Math.max(end, interval.to);
      } else {
        ans.add(new Interval(start, end));
        start = interval.from;
        end = interval.to;
      }
    }
    ans.add(new Interval(start, end));
    return ans;
  }

}


/*
api -> inputs : {{8,10}, {10,12}, {14,19}}
output : {{8,12}, {14,19}}
 */