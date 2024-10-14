import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int tarrif = 0;
            int sizeOfParkingLot = sc.nextInt();
            int N_Events = sc.nextInt();
            ParkingLot parkingLot = new ParkingLot(sizeOfParkingLot);
            for(int event = 0; event < N_Events; event++) {
                char typeOfEvent = sc.next().charAt(0);
                int carPlate = sc.nextInt();
                switch (typeOfEvent) {
                    case 'C':
                        int carSize = sc.nextInt();
                        int availableLot = parkingLot.getFirstAvailableLot(carSize);
                        if(availableLot != -1) {
                            parkingLot.parkCar(availableLot, carSize, carPlate);
                            tarrif += 10;
                        }
                        break;
                    case 'S':
                        parkingLot.removeCar(carPlate);
                        break;
                }
            }
            System.out.println(tarrif);
        }
        sc.close();
    }
 
}

class ParkingLot {
    final Lot[] lots;

    ParkingLot(int size) {
        this.lots = new Lot[size];
        for(int i = 0; i < size; i++) {
            this.lots[i] = new Lot();
        }
    }

    int getFirstAvailableLot(int carSize) {
        for(int start = 0; start <= lots.length - carSize; start++) {
            int end = start + carSize;
            if(isLotAvailable(start, end)) {
                return start;
            }
        }
        return -1;
    }

    void parkCar(int lotStart, int carSize, int carPlate) {
        for(int i = lotStart; i < lotStart + carSize; i++) {
            lots[i].isEmpty = false;
            lots[i].plate = carPlate;
        }
    }

    void removeCar(int carPlate) {
        for(Lot lot : lots) {
            if(lot.plate == carPlate) {
                lot.plate = 0;
                lot.isEmpty = true;
            }
        }
    }

    private boolean isLotAvailable(int start, int end) {
        boolean isAvailable = true;
        for(int i = start; i < end; i++) {
            if(!lots[i].isEmpty) {
                isAvailable = false;
                break;
            }
        }
        return isAvailable;
    }
}

class Lot {
    boolean isEmpty = true;
    int plate = 0;
}