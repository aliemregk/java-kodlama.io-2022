package hw3;

public class Main {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;
        num1 = num2;
        num2 = 100;

        System.out.println(num1);

        int[] nums1 = new int[] { 1, 2, 3 };
        int[] nums2 = new int[] { 10, 20, 30 };

        nums1 = nums2;
        nums2[0] = 1000;
        System.out.println(nums1);
    }
}
