package homework;

import java.util.*;
import java.io.*;

public class reduce {
  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(new File("reduce.in"));
    
    int n = in.nextInt();
    Cow[] sortedHoriz = new Cow[n];
    
    for (int i = 0; i < n; i++) {
      sortedHoriz[i] = new Cow(in);
    }
    in.close();
    Cow[] sortedVert = Arrays.copyOf(sortedHoriz, n);
    
    Arrays.sort(sortedHoriz, new HComparator());
    Arrays.sort(sortedVert, new VComparator());
    
    // baseline result is the original area
    int result = (sortedHoriz[n-1].x - sortedHoriz[0].x) *
                 (sortedVert[n-1].y  - sortedVert[0].y);
    
    // most extreme 3 cows in each direction could be sold
    List<Cow> extremes = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      extremes.add(sortedHoriz[i]);
      extremes.add(sortedHoriz[n-1-i]);
      extremes.add(sortedVert[i]);
      extremes.add(sortedVert[n-1-i]);
    }
    // what about ties between 3rd and 4th most extreme? removing ANY of the
    //   tied cows without removing ALL of them does not produce any improvement
    //   in field size, so extra cases could be added to detect this and exclude
    //   those cows from the list. However, checking these "useless" cases takes
    //   no worse time than checking a "regular" case, so probably not worth it
    
    // what about cases where a cow is extreme in 2 directions, such as a
    //   cow in the upper left corner? we could exclude the duplicates, but a
    //   full combination loop will find all cases anyway; probably not worth it
    // ex: lowest x values 10, 20, 30
    //     lowest y values 10, 25, 40
    //     the cow at (10, 10) accounts for both "1st places" (others unrelated)
    //   normally combination of [10, 20]+[10] would leave a 25 extreme
    //     in the y direction, but since the 10s are from the same cow,
    //     we can use [10, 20]+[(10,) 25] - this is handled as long as we
    //     try ALL combinations of the 12 extreme cows, which would include
    //     both [10,20]+[25] and [20]+[10,25] naturally, and are able to
    //     take into account the fact that BOTH the cow's coordinates no
    //     longer contribute to the field size after it is sold
    //   it is impossible for this "doubling" to ever give a benefit
    //     from considering a cow outside of the "extreme 12", since no
    //     cow can "cover" 2 of the extremes in any 1 direction (only
    //     different directions). At best you will still only
    //     be selling the 3 most extreme cows in one direction; it's just
    //     that these cows may have additional benefits in other directions.
    
    for (int i = 0; i < extremes.size(); i++) {
      // "sell" cow i
      extremes.get(i).sold = true;
      
      // order of sales is irrelevant so we can say i<j<k, no need
      //   to try other orderings
      for (int j = i+1; j < extremes.size(); j++) {
        extremes.get(j).sold = true;
        
        for (int k = j+1; k < extremes.size(); k++) {
          extremes.get(k).sold = true;
          
          // find new extremes by finding first and last unsold cows
          int p = 0;
          while (sortedHoriz[p].sold) p++;
          int xMin = sortedHoriz[p].x;
          p = n-1;
          while (sortedHoriz[p].sold) p--;
          int xMax = sortedHoriz[p].x;
          
          p = 0;
          while (sortedVert[p].sold) p++;
          int yMin = sortedVert[p].y;
          p = n-1;
          while (sortedVert[p].sold) p--;
          int yMax = sortedVert[p].y;
          
          int area = (xMax-xMin)*(yMax-yMin);
          result = Math.min(result, area);
          
          extremes.get(k).sold = false;
        }
        
        extremes.get(j).sold = false;
      }
      
      // "buy back" cow i so we can try selling a different one
      extremes.get(i).sold = false;
    }
    
    
    PrintWriter out = new PrintWriter(new File("reduce.out"));
    System.out.println(result);
    out.println(result);
    out.close();
  }
  
  
  static class HComparator implements Comparator<Cow> {
    public int compare(Cow a, Cow b) {
      return a.x - b.x;
      // ex: a.x = 5, b.x = 9, a should be sorted before b
      //     5-9 = -4, a negative number
      //     therefore a is considered smaller than b
    }
  }
  
  static class VComparator implements Comparator<Cow> {
    public int compare(Cow a, Cow b) {
      return a.y - b.y;
    }
  }
  
  static class Cow {
    int x, y;
    boolean sold;
    
    Cow(Scanner in) {
      x = in.nextInt();
      y = in.nextInt();
    }
    
    // doesn't need to be Comparable -
    //   there is no "natural ordering"
    
    // alternative: have two Cow classes, each
    //   naturally ordered a different way, make
    //   each one able to "clone" itself into
    //   the other format
  }
}