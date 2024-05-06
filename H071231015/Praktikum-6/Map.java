class Object{
    int x;
    int y;

    public Object(int x, int y) {
        this.x = x;
        this.y = y;  
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}


class Walk{
    int w;
    int a;
    int s;
    int d;
    int total;
    
    public int getTotal() {
        return total;
    }

    public int getW() {
        return w;
    }

    public int getA() {
        return a;
    }

    public int getS() {
        return s;
    }

    public int getD() {
        return d;
    }

    public Walk(int w, int a, int s, int d, int total) {
        this.w = w;
        this.a = a;
        this.s = s;
        this.d = d;
        this.total = total;
    }
}


public class Map{
    private static final int lebar = 50;
    private static final int tinggi = 20;

    public static int getLebar() {
        return lebar;
    }

    public static int getTinggi() {
        return tinggi;
    }

    

    private static void printBoard(char[][] board) {
        for (int y = 0; y < (tinggi-1); y++) {
            if (y == 0) {
                System.out.printf("%s\n", "=".repeat(lebar));
            }
            else if (y == (tinggi-2)) {
                System.out.printf("%s\n", "=".repeat(lebar));
                break;
            }
            for (int x = 0; x < lebar; x++) {
                if (x == 0 || x ==1 || x == (lebar-1) || x == (lebar-2)) {
                    System.out.print("|");
                }
                else{
                    System.out.print(board[y][x]);
                }
                
            }
            System.out.println();
        }
    }

    private static void moveUp(Object object) {
        if (object.y > 0) {
            object.y--;
        }
    }

    private static void moveDown(Object object) {
        if (object.y < tinggi - 3) {
            object.y++;
        }
    }

    private static void moveLeft(Object object) {
        if (object.x > 2) {
            object.x--;
        }
    }

    private static void moveRight(Object object) {
        if (object.x < lebar - 3) {
            object.x++;
        }
    }

    private static void updateBoard(char[][] board, Object object) {
        for (int y = 0; y < tinggi; y++) {
            for (int x = 0; x < lebar; x++) {
                if (y == object.y && x == object.x) {
                    board[y][x] = '#';
                } else {
                    board[y][x] = ' ';
                }
            }
        }
    }

    public static void printMap(Parent object) {
        int countW = 0;
        int countA = 0;
        int countS = 0;
        int countD = 0;
        int countTotal = 0;
        char[][] board = new char[tinggi][lebar];
        board[object.getPosition().y][object.getPosition().x] = '#';
        for (int y = 0; y < tinggi; y++) {
            for (int x = 0; x < lebar; x++) {
                board[y][x] = ' ';
            }
        }
        while (true) {
            printBoard(board);
            System.out.println("Ketik w/a/s/d keys untuk bergerak (Ketik 'kembali' untuk kembali)");
            String input = Main.inputUserKosong("= ").toLowerCase();
            if (input.equals("kembali")) {
                object.setPosition(object.getPosition());
                object.getWalk().w += countW; 
                object.getWalk().a += countA; 
                object.getWalk().s += countS;
                object.getWalk().d += countD;
                countTotal = countW + countA + countS + countD;
                object.getWalk().total += countTotal;
                break;
            }
            switch (input) {
                case "w":
                    moveUp(object.getPosition());
                    countW++;
                    break;
                case "a":
                    moveLeft(object.getPosition());
                    countA++;
                    break;
                case "s":
                    moveDown(object.getPosition());
                    countS++;
                    break;
                case "d":
                    moveRight(object.getPosition());
                    countD++;
                    break;
            }
            updateBoard(board, object.getPosition());
        }
    }
}