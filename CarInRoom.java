import java.util.Scanner;

public class CarInRoom {
    static Scanner sc = new Scanner(System.in);
    static String room [];
    public static void main(String[] args) {
        createRoom();
        setCar();
        moveCar();
    }

    private static void moveCar() {
        while (true) {
            for (int i = 0; i < room.length; i++) {
                System.out.println(room[i]);
            }
            System.out.println("Enter your move (A for left, S for down, D for right, W for up).");
            char move = sc.next().charAt(0);
            switch (move) {
                case 'A':
                    moveLeft();
                    break;

                case 'W':
                    moveUp();
                    break;

                case 'D':
                    moveRight();
                    break;

                case 'S':
                    moveDown();
                    break;

                    default:
                    System.out.println("You entered fail move");
                        break;
            }
        }
    }

    private static void moveDown() {
        int row = 0;
        int positionInRow = 0;
        for(int i = 0; i < room.length; i++){
            String s = room[i];
            for(int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'O'){
                    StringBuilder sb = new StringBuilder(s);
                    row = i;
                    positionInRow = j;
                    sb.setCharAt(j, ' ');
                    s = sb.toString();
                    room[i] = s;
                }
            }
        }
        if(row + 1 == room.length - 1){
            System.out.println("You have crashed");
            System.exit(0);
        } else {
            String s = room[row + 1];
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(positionInRow, 'O');
            s = sb.toString();
            room[row + 1] = s;
        }
    }

    private static void moveRight() {
        int row = 0;
        int positionInRow = 0;
        for(int i = 0; i < room.length; i++){
            String s = room[i];
            for(int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'O'){
                    StringBuilder sb = new StringBuilder(s);
                    row = i;
                    positionInRow = j;
                    sb.setCharAt(j, ' ');
                    s = sb.toString();
                    room[i] = s;
                }
            }
        }
        String s = room[row];
        if(s.charAt(positionInRow + 1) == '*'){
            System.out.println("You have crashed");
            System.exit(0);
        } else {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(positionInRow+1, 'O');
            s = sb.toString();
            room[row] = s;
        }
    }

    private static void moveUp() {
        int row = 0;
        int positionInRow = 0;
        for(int i = 0; i < room.length; i++){
            String s = room[i];
            for(int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'O'){
                    StringBuilder sb = new StringBuilder(s);
                    row = i;
                    positionInRow = j;
                    sb.setCharAt(j, ' ');
                    s = sb.toString();
                    room[i] = s;
                }
            }
        }
        String s = room[row - 1];
        if(row - 1 == 0){
            System.out.println("You have crashed");
            System.exit(0);
        } else {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(positionInRow, 'O');
            s = sb.toString();
            room[row - 1] = s;
         }
    }

    private static void moveLeft() {
        int row = 0;
        int positionInRow = 0;
        for(int i = 0; i < room.length; i++){
            String s = room[i];
            for(int j = 0; j < s.length(); j++){
                if (s.charAt(j) == 'O'){
                    StringBuilder sb = new StringBuilder(s);
                    row = i;
                    positionInRow = j;
                    sb.setCharAt(j, ' ');
                    s = sb.toString();
                    room[i] = s;
                }
            }
        }
        String s = room[row];
        if(s.charAt(positionInRow - 1) == '*'){
            System.out.println("You have crashed");
            System.exit(0);
        } else {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(positionInRow-1, 'O');
            s = sb.toString();
            room[row] = s;
        }
    }

    private static void setCar() {
        String s = room[1];
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(1, 'O');
        s = sb.toString();
        room[1] = s;
    }

    private static void createRoom() {
        System.out.println("Enter the length for the room");
        int length = sc.nextInt();
        System.out.println("Enter the width for the room");
        int width = sc.nextInt();
        room = new String[width];

        for (int i = 0; i < room.length; i++) {
            String s = "";
            if (i == 0 || i == width - 1) {
                StringBuilder sb = new StringBuilder();
                for (int a = 0; a < length; a++) {
                    sb.append("*");
                    s = sb.toString();
                    room[i] = s;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < length; j++) {
                    if (j == 0 || j == length - 1) {
                        sb.append("*");
                        s = sb.toString();
                    } else {
                        sb.append(" ");
                        s = sb.toString();
                    }
                    room[i] = s;
                }
            }
        }
    }
}
