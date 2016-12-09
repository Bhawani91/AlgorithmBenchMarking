import java.util.Scanner;

public class Interface {
	private Scanner reader;
	private int[] array;
	private int[] dupArray;
	private int SizeOfArray;
	int Complexity;
	int SortingAlgorithm;
	
	public Interface(Scanner reader) {
		this.reader = reader;
	}
	
	public void start() {
		askForArraySize();
		askForComplexity();
		fillArray();
		dupArray = new int[SizeOfArray];
		Calculator.initDupArray(array, dupArray);
		askForSortingAlgo();
		
	}
	
	public void askForArraySize() {
		while(true) {
			try {
				System.out.println("Enter the size of the array: ");
				SizeOfArray = Integer.parseInt(reader.nextLine());
				if (SizeOfArray > Integer.MAX_VALUE || SizeOfArray == 0 || SizeOfArray < 0) {
					throw new NumberFormatException();
				}
				break;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Provide a smaller non-zero(or a valid) integer value please :)");
			}
		}
		
	}
	
	public void askForComplexity() {
		while(true) {
			try {
				System.out.println("Choose complexity:");
				System.out.println("\t1. Best Case");
				System.out.println("\t2. Average Case");
				System.out.println("\t3. Worst Case");
				Complexity = Integer.parseInt(reader.nextLine());
				if (Complexity > 3 || Complexity == 0 || Complexity < 0) {
					throw new NumberFormatException();
				}
				break;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid Choice--Select From 1, 2 and 3");
			}
		}
		
	}
	
	public void fillArray() {
		while(true) {
			try {
				if (Complexity == 1) {
					array = Calculator.getNaturalNumbersArray(SizeOfArray);
					System.out.println("Size of Array is " + SizeOfArray );
					System.out.println();
					break;
				} else if (Complexity == 2) {
					array = Calculator.getRandomArray(SizeOfArray);
					System.out.println("Size of Array is " + SizeOfArray);
					System.out.println();
					break;
				} else if (Complexity == 3) {
					array = Calculator.getReverseArray(SizeOfArray);
					System.out.println("Size of Array is " +  SizeOfArray );
					System.out.println();
					break;
				} 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Sorry an array for the given size cannot be created. Please start over and select a smaller size!");
			}
		}
		
	}
	
	public void askForSortingAlgo() {
		while(true) {
			try {
				System.out.println("Choose sorting algorithm: ");
				System.out.println("\t1. Bubble Sort");
				System.out.println("\t2. Quick Sort");
				System.out.println("\t3. Insertion Sort");
				System.out.println("\t4. Selection Sort");
				System.out.println("\t5. Merge Sort");
				System.out.println("\t6. Benchmark All");
				System.out.println("\t7. Start Over");
				System.out.println("\t8. Exit");
				SortingAlgorithm = Integer.parseInt(reader.nextLine());
				
				if(SortingAlgorithm == 1) {
					Calculator.initDupArray(array, dupArray);
					Sorting.BubbleSort(array);
					System.out.println();
				} else if (SortingAlgorithm == 2) {
					Calculator.initDupArray(array, dupArray);
					Sorting.QuickSort(array);
					System.out.println();
				} else if (SortingAlgorithm == 3) {
					Calculator.initDupArray(array, dupArray);
					Sorting.InsertionSort(array);
					System.out.println();
				} else if (SortingAlgorithm == 4) {
					Calculator.initDupArray(array, dupArray);
					Sorting.SelectionSort(array);
					System.out.println();
				} else if (SortingAlgorithm == 5) {
					Calculator.initDupArray(array, dupArray);
					Sorting.mergeSortHelper(array);
					System.out.println();
				} else if (SortingAlgorithm == 6) {
					Calculator.initDupArray(array, dupArray);
					Sorting.BubbleSort(array);
					Calculator.initDupArray(array, dupArray);
					Sorting.QuickSort(array);
					Calculator.initDupArray(array, dupArray);
					Sorting.InsertionSort(array);
					Calculator.initDupArray(array, dupArray);
					Sorting.SelectionSort(array);
					Calculator.initDupArray(array, dupArray);
					Sorting.mergeSortHelper(array);
					System.out.println();
				} else if (SortingAlgorithm == 7) {
					restart();
				} else if (SortingAlgorithm == 8) {
					System.out.println("Mission Accomplished");
					System.exit(0);
				} else {
					System.out.println("Choose the number from 1 to 8");
					System.out.println();
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid choice -- select number from 1 to 8");
			}
		}
		
	}
	
	public void initArray() {
		for (int i = 0; i < array.length - 1 ; i++) {
			array[i] = 0;
		}
	}
	
	public void restart() {
		SizeOfArray = 0;
		Complexity = 0;
		SortingAlgorithm = 0;
		start();
	}

}
