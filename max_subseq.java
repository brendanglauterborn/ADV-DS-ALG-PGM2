//Brendan Lauterborn 
//COSC 600 Programming Assignment 2
//Question 1

import java.util.Random;


public class max_subseq {

	public static int[] generate_array(int size) {
		Random random = new Random();
		int[] nums = new int[size];
		int max = 5000;
		int min = -5000;
		for(int i = 0; i < size; i++) {
			nums[i] = random.nextInt(max - min + 1)+ min;
		}
		return nums;
	}
	
	public static int algorithm1(int[] nums) {
		int max_subseq = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j < nums.length; j++) {
				int sum = 0;
				for(int k = i; k <= j; k++) {
					sum += nums[k];
				}
				if(sum > max_subseq) {
					max_subseq = sum;
				}
			}
		}
		
		return max_subseq;
	}
	
	public static int algorithm2(int[]nums) {
		int max_subseq = 0;
		for(int i = 0; i < nums.length; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max_subseq) {
					max_subseq = sum;
				}
			}
		}
		return max_subseq;
	}
	
	public static int max3(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}
	
	public static int algorithm3(int[] nums, int left, int right) {
		if (left == right) {
			if(nums[left] > 0) {
				return nums[left];
			}
			else {
				return 0;
			}
		}
		int center = (left + right) / 2;
		int max_left_sum = algorithm3(nums,left,center);
		int max_right_sum = algorithm3(nums, center +1, right);
		
		int max_left_border_sum = 0, left_border_sum = 0;
		for(int i = center; i >= left; i--) {
			left_border_sum += nums[i];
			if(left_border_sum > max_left_border_sum) {
				max_left_border_sum = left_border_sum;
			}
		}
		int max_right_border_sum = 0, right_border_sum = 0;
		for(int i = center + 1; i <= right; i++) {
			right_border_sum += nums[i];
			if(right_border_sum > max_right_border_sum) {
				max_right_border_sum = right_border_sum;
				
			}
		}
		return max3(max_left_sum, max_right_sum, max_left_border_sum + max_right_border_sum);
		
	}
	
	public static int algorithm4(int[] nums) {
		int max_subseq = 0, sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > max_subseq) {
				max_subseq = sum;
			}
			else if(sum < 0) {
				sum = 0;
			}
		}
		return max_subseq;
	}
	public static void main(String[] args) {
		
		int nums1[] = generate_array(5000);
		int nums2[] = generate_array(10000);
		int nums3[] = generate_array(50000);
		int nums4[] = generate_array(100000);
		int nums5[] = generate_array(200000);
		
		//Algorithm 1 runtime 
		System.out.print("Algorithm 1: Expected runtime O(n^3)\n");
		
		long start = System.nanoTime();
		algorithm1(nums1);
		long end = System.nanoTime();
		System.out.println("n=5000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm1(nums2);
		end = System.nanoTime();
		System.out.println("n=10000. The actual runtime is " + (end - start)/1e9 + "s" );
		
//		start = System.nanoTime();
//		algorithm1(nums3);
//		end = System.nanoTime();
//		System.out.println("n=50000. The actual runtime is " + (end - start)/1e9 + "s" );
//		
//		start = System.nanoTime();
//		algorithm1(nums4);
//		end = System.nanoTime();
//		System.out.println("n=100000. The actual runtime is " + (end - start)/1e9 + "s" );
//		
//		start = System.nanoTime();
//		algorithm1(nums5);
//		end = System.nanoTime();
//		System.out.println("n=200000. The actual runtime is " + (end - start)/1e9 + "s" );
		System.out.println("n=50000, 100000 and 200000 were terminated due to the runtime.\n" );
		System.out.println();
		
		//Algorithm 2 runtime
		System.out.print("Algorithm2: Expected runtime O(n^2)\n");
		
		start = System.nanoTime();
		algorithm2(nums1);
		end = System.nanoTime();
		System.out.println("n=5000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm2(nums2);
		end = System.nanoTime();
		System.out.println("n=10000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm2(nums3);
		end = System.nanoTime();
		System.out.println("n=50000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm2(nums4);
		end = System.nanoTime();
		System.out.println("n=100000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm2(nums5);
		end = System.nanoTime();
		System.out.println("n=200000. The actual runtime is " + (end - start)/1e9 + "s\n" );
		System.out.println();
		
		//Algorithm 3 runtime
		System.out.print("Algorithm3: Expected runtime O(nlogn)\n");
		
		start = System.nanoTime();
		algorithm3(nums1, 0, nums1.length -1);
		end = System.nanoTime();
		System.out.println("n=5000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm3(nums2, 0, nums2.length -1);
		end = System.nanoTime();
		System.out.println("n=10000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm3(nums3, 0, nums3.length -1);
		end = System.nanoTime();
		System.out.println("n=50000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm3(nums4, 0, nums4.length -1);
		end = System.nanoTime();
		System.out.println("n=100000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm3(nums5, 0, nums5.length -1);
		end = System.nanoTime();
		System.out.println("n=200000. The actual runtime is " + (end - start)/1e9 + "s\n" );
		System.out.println();

		//Algorithm 4 runtime
		System.out.print("Algorithm4: Expected runtime O(n)\n");
		
		start = System.nanoTime();
		algorithm4(nums1);
		end = System.nanoTime();
		System.out.println("n=5000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm4(nums2);
		end = System.nanoTime();
		System.out.println("n=10000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm4(nums3);
		end = System.nanoTime();
		System.out.println("n=50000. The acutal runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm4(nums4);
		end = System.nanoTime();
		System.out.println("n=100000. The actual runtime is " + (end - start)/1e9 + "s" );
		
		start = System.nanoTime();
		algorithm4(nums5);
		end = System.nanoTime();
		System.out.println("n=200000. The actual runtime is " + (end - start)/1e9 + "s" );

	}

}
