public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        if (isLeapYear(1990)) {
            System.out.println("is");
        } else {
            System.out.println("is not");
        }
    }
}
