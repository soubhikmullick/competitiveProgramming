package others;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> hm = new HashMap<>();
        File file = new File("resources/text");
        Scanner in = new Scanner(file);
        String st = in.nextLine();
        hm.put(st.split(" ")[0], st.split(" ")[1]);
        List<Stations> stations = new ArrayList<>();
        while (in.hasNext()) {
            String[] stringArray = in.nextLine().split(" ");
            stations.add(new Stations(stringArray[0], stringArray[1], Integer.parseInt(stringArray[2])));
        }
        System.out.println(stations);
    }
}

class Stations {
    private String from;
    private String to;
    private int cost;

    public Stations(String from, String to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}