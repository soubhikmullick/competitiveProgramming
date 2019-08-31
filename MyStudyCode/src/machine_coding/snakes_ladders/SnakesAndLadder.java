package machine_coding.snakes_ladders;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SnakesAndLadder {
    private static final Util util = new Util();

    public static void main(String[] args) {
        Player p1 = new Player("Joy");
        Player p2 = new Player("Sri");

        Board board = new Board(100);
        setupBoardParams(board);

        boolean flag = true;
        while(p1.getPosition() <= 100 && p2.getPosition() <= 100) {
            if(flag) {
                int val = p1.getPosition()+util.getRand();
                val = util.checkIfLadderExists(val, board.getLadders(), board.getSnakes());
                val = util.checkIfSnakesExists(val, board.getLadders(), board.getSnakes());
                p1.setPosition(val);
                System.out.println("p1: "+p1.getPosition());
                flag = false;
            } else {
                int val = p2.getPosition()+util.getRand();
                val = util.checkIfLadderExists(val, board.getLadders(), board.getSnakes());
                val = util.checkIfSnakesExists(val, board.getLadders(), board.getSnakes());
                p2.setPosition(val);
                System.out.println("p2: "+p2.getPosition());
                flag = true;
            }
        }
    }

    private static void setupBoardParams(Board board) {
        BoardAdminOperations boardAdminOperations = new BoardAdminOperations();
        boardAdminOperations.updateSnakesPosition(99,37, board.getSnakes(), board.getLadders());
        boardAdminOperations.updateSnakesPosition(43,22, board.getSnakes(), board.getLadders());
        boardAdminOperations.updateSnakesPosition(74,11, board.getSnakes(), board.getLadders());

        boardAdminOperations.updateLaddersPosition(4,45, board.getLadders(), board.getSnakes());
        boardAdminOperations.updateLaddersPosition(32,84, board.getLadders(), board.getSnakes());
        boardAdminOperations.updateLaddersPosition(23,74, board.getLadders(), board.getSnakes());
    }
}

class Player{
    private String userName;
    private int position;

    Player(String userName) {
        this.userName = userName;
        this.position = 1;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

class Board {


    private int[] spaces;

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;

    public int[] getSpaces() {
        return spaces;
    }

    Board() {
        spaces = new int[100];
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }

    Board(int spaces) {
        this.spaces = new int[spaces];
        snakes = new HashMap<>();
        ladders = new HashMap<>();
    }
}

class BoardAdminOperations {

    private static final Logger LOGGER = Logger.getLogger(BoardAdminOperations.class.getName());

    BoardAdminOperations() {
    }

    public void updateSnakesPosition(int from, int to, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        if(from>to && !ladders.containsValue(from)) {
            snakes.put(from, to);
        } else {
            LOGGER.log(Level.SEVERE, "Error updating snakes position: from = "+from+" :: to = "+to);
            System.out.println("Error updating snakes position, retry with different from & to value");
        }
    }

    public void updateLaddersPosition(int from, int to, Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        if(from<to && !snakes.containsValue(from)) {
            ladders.put(from, to);
        } else {
            LOGGER.log(Level.SEVERE, "Error updating snakes position: from = "+from+" :: to = "+to);
            System.out.println("Error updating snakes position, retry with different from & to value");
        }
    }
}

class Util {
    public  int getRand() {
        Random random = new Random();
        int val = random.nextInt(7);
        return val==0?1:val;
    }

    public int checkIfLadderExists(int pos, Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        int position = pos;
        if(ladders.containsKey(pos)) {
            System.out.println("Ladder exists from "+pos+" to "+ladders.get(pos));
            if(snakes.containsKey(ladders.get(pos))) {
                System.out.println("Snake exists from "+pos+" to "+ snakes.get(ladders.get(pos)));
                position = snakes.get(ladders.get(pos));
            }
            else position = ladders.get(pos);
        }
        return position;
    }

    public int checkIfSnakesExists(int pos,  Map<Integer, Integer> ladders, Map<Integer, Integer> snakes) {
        int position = pos;
        if(snakes.containsKey(pos)) {
            System.out.println("Snake exists from "+pos+" to "+snakes.get(pos));
            if(ladders.containsKey(snakes.get(pos))) {
                System.out.println("Snake exists from "+pos+" to "+ ladders.get(snakes.get(pos)));
                position = ladders.get(snakes.get(pos));
            }
            else position = snakes.get(pos);
        }
        return position;
    }
}