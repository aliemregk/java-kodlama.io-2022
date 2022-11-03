package classes;

public class Main {
    public static void main(String[] args) {

        CustomerManager customerManager;
        CustomerManager customerManager2 = new CustomerManager();

        customerManager = customerManager2;

        customerManager.Add();
        customerManager.Delete();
        customerManager.Update();

        int a = 5;
        int b = 6;
        a = b;
        b = 7;
        System.out.println(a);

        int[] nums1 = new int[] { 1, 2, 3 };
        int[] nums2 = new int[] { 10, 20, 30 };
        nums1 = nums2;
        nums2[0] = 11;
        System.out.println(nums1[0]);
    }
}
