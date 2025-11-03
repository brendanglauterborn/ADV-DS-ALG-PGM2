//Brendan Lauterborn 
//COSC 600 Programming Assignment 2
//Question 3

import java.util.Random;
import java.util.Stack;

public class long_seq {
	
	
	public static int[][] generate_array(int size) {
		Random random = new Random();
		int[][] nums = new int[size][size];
		int max = 1000;
		int min = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				nums[i][j] = random.nextInt(max - min + 1)+ min;
			}

		}
		return nums;
	}
	
	static Stack<String> path = new Stack<>();
	static Stack<String> long_path = new Stack<>();
	
	public static int dfs(int[][] nums, int row, int column, int current ) {
//		Stack<String> path = new Stack<>();
//		Stack<String> long_path = new Stack<>();
		
		if(row < 0 || column < 0 || row >= nums.length || column >= nums[0].length ) return 0;
		if(nums[row][column] <= current) return 0;
		
		current = nums[row][column];
		
		path.push(current +" (" + row + "," + column + ")");
		
		int max_len = 1;
		int start_size = path.size();
		
		max_len = Math.max(max_len,1 + dfs(nums, row - 1, column, current));
		max_len = Math.max(max_len,1 + dfs(nums, row + 1, column , current));
		max_len = Math.max(max_len,1 + dfs(nums, row, column - 1, current));
		max_len = Math.max(max_len,1 + dfs(nums, row, column + 1, current));
		max_len = Math.max(max_len,1 + dfs(nums, row - 1, column - 1, current));
		max_len = Math.max(max_len,1 + dfs(nums, row -1, column + 1, current));
		max_len = Math.max(max_len,1 + dfs(nums, row + 1, column - 1, current));
		max_len = Math.max(max_len,1 + dfs(nums, row + 1, column + 1, current));
		
		if(path.size() > long_path.size()) {
			long_path = (Stack<String>) path.clone();
		}
		path.pop();
		return max_len;

		
	}
	
	public static void main(String[] args) {
		int size = 15;
		int max_path = 0;
		int[][] nums = generate_array(size);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				max_path = Math.max(max_path, dfs(nums, i, j, -1));
			}
		}
		for(String s : long_path) {
			System.out.println(s);
		}
	
		System.out.print("The max path is length: " + max_path);
		
		

		
		
	}

}
