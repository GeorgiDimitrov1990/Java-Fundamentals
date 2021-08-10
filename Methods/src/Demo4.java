public class Demo4 {
    public static void main(String[] args) {
        int sum = getSum(69, 42);
        System.out.println(sum);

    }
    static int getSum(int... numbers){
        int sum = 0;
        for (int i = 0; i <numbers.length ; i++) {
            sum += numbers[i];
        }

        return sum;
    }
    static void printSum(int... numbers){
        System.out.println(getSum(numbers));
    }
}
