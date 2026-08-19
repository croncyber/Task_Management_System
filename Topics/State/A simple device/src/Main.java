import java.util.Scanner;

class Device {

    public void switchOn() {

    }

    public void switchOff() {

    }
}

// do not change the code below
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Device device = new Device();
        while (scanner.hasNext()) {
            if ("on".equals(scanner.next())) {
                device.switchOn();
            } else {
                device.switchOff();
            }
        }
    }
}