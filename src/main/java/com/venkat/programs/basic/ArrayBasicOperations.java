package com.venkat.programs.basic;

public class ArrayBasicOperations {

    // 1) Copy all elements of one array into another array
    public static int[] copyArray(int[] array) {
        int[] copiedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copiedArray[i] = array[i];
        }
        return copiedArray;
    }

    // 2) Find the frequency of each element in the array
    public static void findFrequency(int[] array) {
        int[] fr = new int[array.length];
        int visited = -1; // Marker for visited elements

        // Loop to calculate the frequency of each element
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                    // Mark this element as visited
                    fr[j] = visited;
                }
            }
            // Store frequency of the element if it's not visited
            if (fr[i] != visited) {
                fr[i] = count;
            }
        }
        System.out.println("---------------------------------------");
        System.out.println(" Element | Frequency");
        System.out.println("---------------------------------------");
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] != visited) {
                System.out.println("    " + array[i] + "    |    " + fr[i]);
            }
        }
        System.out.println("----------------------------------------");
    }

    // 3) Left rotate the elements of an array
    public static void leftRotate(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int first = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = first;
        }
        printArray(array);
    }

    // 4) Print the duplicate elements of an array
    public static void printDuplicateElements(int[] array) {
        boolean[] visited = new boolean[array.length];  // To track visited elements

        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j] && !visited[j]) {
                        System.out.print(array[i] + " ");
                        visited[j] = true;  // Mark as visited
                    }
                }
            }
        }
        System.out.println();
    }


    // 5) Print the elements of an array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 6) Print the elements of an array in reverse order
    public static void printReverse(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 7) Print the elements of an array present on even position
    public static void printEvenPosition(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 8) Print the elements of an array present on odd position
    public static void printOddPosition(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 9) Print the largest element in an array
    public static int findLargestElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // 10) Print the smallest element in an array
    public static int findSmallestElement(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 11) Print the number of elements present in an array
    public static int countElements(int[] array) {
        return array.length;
    }

    // 12) Print the sum of all the items of the array
    public static int sumOfElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    // 13) Right rotate the elements of an array
    public static void rightRotate(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int last = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = last;
        }
        printArray(array);
    }

    // 14) Sort the elements of an array in ascending order
    public static void sortAscending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        printArray(array);
    }

    // 15) Sort the elements of an array in descending order
    public static void sortDescending(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        printArray(array);
    }

    // 16) Find 3rd largest number in an array
    public static int findThirdLargest(int[] array) {
        sortAscending(array);
        return array[array.length - 3];
    }

    // 17) Find 2nd largest number in an array
    public static int findSecondLargest(int[] array) {
        sortAscending(array);
        return array[array.length - 2];
    }

    // 18) Find largest number in an array
    public static int findLargest(int[] array) {
        return findLargestElement(array);
    }

    // 19) Find 2nd smallest number in an array
    public static int findSecondSmallest(int[] array) {
        sortAscending(array);
        return array[1];
    }

    // 20) Find smallest number in an array
    public static int findSmallest(int[] array) {
        return findSmallestElement(array);
    }

    // 21) Remove duplicate elements in an array
    public static int[] removeDuplicates(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == temp[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[index++] = array[i];
            }
        }
        int[] result = new int[index];
        System.arraycopy(temp, 0, result, 0, index);
        return result;
    }

    // 22) Print odd and even numbers from an array
    public static void printOddAndEvenNumbers(int[] array) {
        System.out.print("Even Numbers: ");
        for (int num : array) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Odd Numbers: ");
        for (int num : array) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 9, 1, 5, 6, 7, 2, 5, 3};

        System.out.println("Original Array: ");
        printArray(array);
        System.out.println("Copied Array: ");
        printArray(copyArray(array));

        System.out.println("Frequency of Elements: ");
        findFrequency(array);

        System.out.println("Left Rotated Array: ");
        leftRotate(array, 2);

        System.out.println("Right Rotated Array: ");
        rightRotate(array, 2);

        System.out.println("Duplicate Elements: ");
        printDuplicateElements(array);

        System.out.println("Largest Element: " + findLargestElement(array));
        System.out.println("Smallest Element: " + findSmallestElement(array));
        System.out.println("Sum of Elements: " + sumOfElements(array));

        System.out.println("Array in Ascending Order: ");
        sortAscending(array);

        System.out.println("Array in Descending Order: ");
        sortDescending(array);

        System.out.println("Third Largest Element: " + findThirdLargest(array));
        System.out.println("Second Largest Element: " + findSecondLargest(array));
        System.out.println("Second Smallest Element: " + findSecondSmallest(array));

        System.out.println("Array Without Duplicates: ");
        printArray(removeDuplicates(array));

        System.out.println("Odd and Even Numbers: ");
        printOddAndEvenNumbers(array);
    }
}
