public class Demo3 {
    public static void main(String[] args) {
        int x = getMax(17 , 42);
        int y = getMax(69 , 12);

        System.out.println(x + y);
    }

    private static int getMax(int first, int second) {
        if (first > second){
            return first;
        }
        return second;
    }


}
