public class Main {

  public static void main(String[] args) {
      int[] array = {66, 22, 33, 11, 44};
      
      mergeSort(array);
      
      for (int num : array) {
          System.out.print(num);
      }
  }

  public static void mergeSort(int[] array) {
      if (array.length <= 1) {
          return;
      }

      int mid = array.length / 2;

      int[] left = new int[mid];
      int[] right = new int[array.length - mid];

      for (int i = 0; i < mid; i++) {
          left[i] = array[i];
      }
      for (int i = mid; i < array.length; i++) {
          right[i - mid] = array[i];
      }

      mergeSort(left);
      mergeSort(right);

      merge(array, left, right);
  }

  public static void merge(int[] array, int[] left, int[] right) {
      int l = 0, r = 0, counter = 0;

      while (l < left.length && r < right.length) {
          if (left[l] <= right[r]) {
              array[counter++] = left[l++];
          } else {
              array[counter++] = right[r++];
          }
      }

      while (l < left.length) {
          array[counter++] = left[l++];
      }

      while (r < right.length) {
          array[counter++] = right[r++];
      }
  }
}
