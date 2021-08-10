import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E9 {
    static class Car {
        String model;
        List<Engine> engines = new ArrayList<>();
        List<Cargo> cargos = new ArrayList<>();
        List<Tires> tires = new ArrayList<>();

        public Car(String model, List<Engine> engines, List<Cargo> cargos, List<Tires> tires) {
            this.model = model;
            this.engines = engines;
            this.cargos = cargos;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }

        public List<Engine> getEngines() {
            return engines;
        }

        public List<Cargo> getCargos() {
            return cargos;
        }

        public List<Tires> getTires() {
            return tires;
        }
    }

    static class Engine {
        int engineSpeed;
        int enginePower;

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }

    static class Cargo {
        int cargoWeight;
        String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public int getCargoWeight() {
            return cargoWeight;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

    static class Tires {
        double tire1Pressure;
        int tire1Age;

        double tire2Pressure;
        int tire2Age;

        double tire3Pressure;
        int tire3Age;

        double tire4Pressure;
        int tire4Age;

        public Tires(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age, double tire3Pressure, int tire3Age, double tire4Pressure, int tire4Age) {
            this.tire1Pressure = tire1Pressure;
            this.tire1Age = tire1Age;
            this.tire2Pressure = tire2Pressure;
            this.tire2Age = tire2Age;
            this.tire3Pressure = tire3Pressure;
            this.tire3Age = tire3Age;
            this.tire4Pressure = tire4Pressure;
            this.tire4Age = tire4Age;
        }

        public double getTire1Pressure() {
            return tire1Pressure;
        }

        public double getTire2Pressure() {
            return tire2Pressure;
        }

        public double getTire3Pressure() {
            return tire3Pressure;
        }

        public double getTire4Pressure() {
            return tire4Pressure;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            List<Engine> engines = new ArrayList<>();
            engines.add(engine);

            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            List<Cargo> cargos = new ArrayList<>();
            cargos.add(cargo);

            Tires tires = new Tires(Double.parseDouble(input[5]), Integer.parseInt(input[6])
                    , Double.parseDouble(input[7]), Integer.parseInt(input[8])
                    , Double.parseDouble(input[9]), Integer.parseInt(input[10])
                    , Double.parseDouble(input[11]), Integer.parseInt(input[12]));
            List<Tires> tiresList = new ArrayList<>();
            tiresList.add(tires);

            Car car = new Car(input[0], engines, cargos, tiresList);
            carList.add(car);


            /*ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4*/
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")){
            for (int i = 0; i < carList.size() ; i++) {
                if (carList.get(i).getCargos().get(0).getCargoType().equals("fragile")){
                    if (carList.get(i).getTires().get(0).getTire1Pressure() < 1
                     || carList.get(i).getTires().get(0).getTire2Pressure() <1
                    || carList.get(i).getTires().get(0).getTire3Pressure()<1
                    || carList.get(i).getTires().get(0).getTire4Pressure()< 1){
                        System.out.println(carList.get(i).getModel());
                    }
                }
            }
        } else if (command.equals("flamable")){
            for (int i = 0; i < carList.size() ; i++) {
                if (carList.get(i).getEngines().get(0).getEnginePower() > 250){
                    System.out.println(carList.get(i).getModel());
                }
            }
        }
    }
}
