//Brendan Lauterborn 
//COSC 600 Programming Assignment 2
//Question 2

import java.util.Scanner;
public class josephus_problem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("How many soldiers?-> ");
		int num = s.nextInt();
		s.nextLine();
		String[] soldiers = new String[num];
		System.out.println("Type " + num + " soldiers name: ");
		for(int i = 0; i < num; i++) {
			soldiers[i] = s.nextLine();
		}
		
		System.out.println("Enter the postition-> ");
		int p = s.nextInt();
		
		int[] positions = new int[num];
		for(int i = 0; i < num; i++) {
			positions[i] = i + 1;
		}
		
		int size = num, index = -1, count = 1;
		
		while(size > 1) {
			int steps = 0;
			while(steps < p) {
				index = (index + 1) % num;
				if(soldiers[index] != null) {
					steps++;
				}
			}
			System.out.println(count + ". " + soldiers[index] + " (" + positions[index] + ")");
			soldiers[index] = null;
			size--;
			count++;
		}
		
		for(int i = 0; i < num; i++) {
			if(soldiers[i] != null) {
				System.out.println("The survivor is: " + soldiers[i]+ " (" + positions[i] + ")");
			}
		}
	}

}
