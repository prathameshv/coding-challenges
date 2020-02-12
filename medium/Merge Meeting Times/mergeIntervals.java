import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Interval {
	
	int begin, end;
	
	Interval(int begin, int end){
		this.begin = begin;
		this.end = end;
	}
	
	public String toString(){
		return "{" + begin + ", " + end + "}";
	}
}

class MergeIntervals{
	
	public static void main(String[] args){
		List<Interval> intervals = Arrays.asList(new Interval(1,5), new Interval(2,3));
		mergeInt(intervals);
	}
	
	public static void mergeInt(List<Interval> intervals){
		//Sort
		Collections.sort(intervals, (a,b) -> a.begin - b.begin);
		
		//empty stack
		Stack<Interval> stack = new Stack<>();
		
		//for each interval
		for(Interval current: intervals){
			
			//push to stack when:
			//1. stack is empty
			//2. top int of stack does not overlap with the curr int
			if(stack.empty() || current.begin > stack.peek().end)
				stack.push(current);
			
			//if top of stack overlaps with current, mergeInt
			//update end of top int with end of current
			
			if(stack.peek().end < current.end){
				stack.peek().end = current.end;
			}
		}
		
		//print all non-overlapping intervals
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
	}
}