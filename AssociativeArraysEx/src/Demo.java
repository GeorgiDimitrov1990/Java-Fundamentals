import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static class Stats{
        int a;
        int b;

        public Stats(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
    public static void main(String[] args) {

        Map<String, Stats> map = new HashMap<>();


        map.put("a",new Stats(1,2));
        map.put("b",new Stats(1, 2));
        map.put("c",new Stats(1, 2));


        for (String s : map.keySet()) {
            int a =0;
            int b =0;
            for (Map.Entry<String, Stats> entry : map.entrySet()) {
                 a += entry.getValue().getA();
            }
            for (Map.Entry<String, Stats> entry : map.entrySet()) {
                 b+=entry.getValue().getB();
            }
            double average1 = a/map.size();
            double average2 = b/map.size();
            System.out.println(average1 + " " + average2);



        }


    }


}
