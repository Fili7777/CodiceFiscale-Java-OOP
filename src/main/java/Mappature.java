import java.util.HashMap;

public class Mappature {
    public static final HashMap<Character, Integer> mappaDispari = new HashMap<>();
    public static final HashMap<Character, Integer> mappaPari = new HashMap<>();
    public static final HashMap<Integer, Character> mappaResto = new HashMap<>();

    static {
        // Mappatura dei caratteri dispari
        mappaDispari.put('0', 1);
        mappaDispari.put('1', 0);
        mappaDispari.put('2', 5);
        mappaDispari.put('3', 7);
        mappaDispari.put('4', 9);
        mappaDispari.put('5', 13);
        mappaDispari.put('6', 15);
        mappaDispari.put('7', 17);
        mappaDispari.put('8', 19);
        mappaDispari.put('9', 21);
        mappaDispari.put('A', 1);
        mappaDispari.put('B', 0);
        mappaDispari.put('C', 5);
        mappaDispari.put('D', 7);
        mappaDispari.put('E', 9);
        mappaDispari.put('F', 13);
        mappaDispari.put('G', 15);
        mappaDispari.put('H', 17);
        mappaDispari.put('I', 19);
        mappaDispari.put('J', 21);
        mappaDispari.put('K', 2);
        mappaDispari.put('L', 4);
        mappaDispari.put('M', 18);
        mappaDispari.put('N', 20);
        mappaDispari.put('O', 14);
        mappaDispari.put('P', 3);
        mappaDispari.put('Q', 6);
        mappaDispari.put('R', 8);
        mappaDispari.put('S', 12);
        mappaDispari.put('T', 14);
        mappaDispari.put('U', 16);
        mappaDispari.put('V', 10);
        mappaDispari.put('W', 22);
        mappaDispari.put('X', 25);
        mappaDispari.put('Y', 24);
        mappaDispari.put('Z', 23);

        // Mappatura dei caratteri pari
        mappaPari.put('0', 0);
        mappaPari.put('1', 1);
        mappaPari.put('2', 2);
        mappaPari.put('3', 3);
        mappaPari.put('4', 4);
        mappaPari.put('5', 5);
        mappaPari.put('6', 6);
        mappaPari.put('7', 7);
        mappaPari.put('8', 8);
        mappaPari.put('9', 9);
        mappaPari.put('A', 0);
        mappaPari.put('B', 1);
        mappaPari.put('C', 2);
        mappaPari.put('D', 3);
        mappaPari.put('E', 4);
        mappaPari.put('F', 5);
        mappaPari.put('G', 6);
        mappaPari.put('H', 7);
        mappaPari.put('I', 8);
        mappaPari.put('J', 9);
        mappaPari.put('K', 10);
        mappaPari.put('L', 11);
        mappaPari.put('M', 12);
        mappaPari.put('N', 13);
        mappaPari.put('O', 14);
        mappaPari.put('P', 15);
        mappaPari.put('Q', 16);
        mappaPari.put('R', 17);
        mappaPari.put('S', 18);
        mappaPari.put('T', 19);
        mappaPari.put('U', 20);
        mappaPari.put('V', 21);
        mappaPari.put('W', 22);
        mappaPari.put('X', 23);
        mappaPari.put('Y', 24);
        mappaPari.put('Z', 25);

        // Mappatura dei resti
        mappaResto.put(0, 'A');
        mappaResto.put(1, 'B');
        mappaResto.put(2, 'C');
        mappaResto.put(3, 'D');
        mappaResto.put(4, 'E');
        mappaResto.put(5, 'F');
        mappaResto.put(6, 'G');
        mappaResto.put(7, 'H');
        mappaResto.put(8, 'I');
        mappaResto.put(9, 'J');
        mappaResto.put(10, 'K');
        mappaResto.put(11, 'L');
        mappaResto.put(12, 'M');
        mappaResto.put(13, 'N');
        mappaResto.put(14, 'O');
        mappaResto.put(15, 'P');
        mappaResto.put(16, 'Q');
        mappaResto.put(17, 'R');
        mappaResto.put(18, 'S');
        mappaResto.put(19, 'T');
        mappaResto.put(20, 'U');
        mappaResto.put(21, 'V');
        mappaResto.put(22, 'W');
        mappaResto.put(23, 'X');
        mappaResto.put(24, 'Y');
        mappaResto.put(25, 'Z');
    }
}

