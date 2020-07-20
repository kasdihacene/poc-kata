package com.mlaku.dev.kata.algorithms;

public class SortAlgo {
    public static void mergeSort(int[] array) {
        sorting(array, 0, array.length - 1);
    }

    private static void sorting(int[] array, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;
            sorting(array, begin, middle);
            sorting(array, middle + 1, end);

            merge(array, begin, middle, end);
        }
    }

    private static void merge(int[] array, int begin, int middle, int end) {
        // Find sizes of two subarrays to be merged
        int sizeStArray = middle - begin + 1;
        int sizeNdArray = end - middle;

        /* Create temp arrays */
        int firstPart[] = new int[sizeStArray];
        int secondPart[] = new int[sizeNdArray];

        /*Copy data to temp arrays*/
        for (int i = 0; i < sizeStArray; ++i)
            firstPart[i] = array[begin + i];
        for (int j = 0; j < sizeNdArray; ++j)
            secondPart[j] = array[middle + 1 + j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int indexFirstArray = 0, indexSecondArray = 0;

        // Initial index of merged subarry array
        int k = begin;
        while (indexFirstArray < sizeStArray && indexSecondArray < sizeNdArray) {
            if (firstPart[indexFirstArray] <= secondPart[indexSecondArray]) {
                array[k] = firstPart[indexFirstArray];
                indexFirstArray++;
            } else {
                array[k] = secondPart[indexSecondArray];
                indexSecondArray++;
            }
            k++;
        }

        /* Copy remaining elements of firstPart[] if any */
        while (indexFirstArray < sizeStArray) {
            array[k] = firstPart[indexFirstArray];
            indexFirstArray++;
            k++;
        }

        /* Copy remaining elements of secondPart[] if any */
        while (indexSecondArray < sizeNdArray) {
            array[k] = secondPart[indexSecondArray];
            indexSecondArray++;
            k++;
        }
    }

    public static boolean exists(int[] array, int element) {
        int size = array.length;
        int middle = (array.length / 2);

        if (middle == 1) return element == array[middle];

        if (size > 0) {

            if (element <= array[middle]) {
                if (element == array[middle]) return true;
                array = createCopy(array, 0, middle);
            } else {
                array = createCopy(array, middle, size - 1);
            }
            return exists(array, element);
        }
        return false;
    }

    private static int[] createCopy(int[] array, int begin, int end) {

        int[] mainArray = new int[end - begin + 1];
        for (int i = 0; i < end; i++) {
            mainArray[i] = array[begin];
            begin++;
            if (begin > end) break;
        }
        return mainArray;
    }

    public static int closestToZero(int[] ints) {

        int closestToZero = ints[0];
        int squareCurrent;
        int next;

        for (int i = 0; i < ints.length; i++) {
            squareCurrent = ints[i] * ints[i];
            int squareClosest = closestToZero * closestToZero;

            if (squareCurrent <= squareClosest) {
                next = ints[i];

                // when absolute value => same occurrence
                // take 1 when having (1 and -1 ) in the array
                if (Math.pow(next, 2) == Math.pow(closestToZero, 2)) {
                    if (closestToZero < 0 && next < 0) {
                        closestToZero = next;
                    } else {
                        closestToZero = Math.abs(closestToZero);
                    }
                } else {
                    closestToZero = ints[i];
                }
            }
        }
        return closestToZero;
    }
}
