import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Day3 {

    public static void main(String[] args) {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        LinkedList<String> lines = new LinkedList<>();
        LinkedList<String> ids = new LinkedList<>();
        Integer[][] field = new Integer[1001][1001];
        String[][] overlap = new String[1001][1001];
        HashMap<String, String> l = new HashMap<>();

        for (int i = 0; i < 1001; ++i) {
            for (int i1 = 0; i1 < 1001; ++i1) {
                field[i][i1] = 0;
                overlap[i][i1] = "0";
            }
        }
        try {
            while (!(line = br.readLine()).equals("end")) {
                line = line.replaceAll("#", "");
                line = line.replaceAll("\\s+", "");
                lines.add(line.split("@")[1]);
                ids.add(line.split("@")[0]);
                l.put(line.split("@")[0], line.split("@")[1]);
            }
        } catch (IOException e) {
            System.out.println("Error");
        } finally {
            for (int t = 0; t < lines.size(); ++t) {

                String s = lines.get(t);
                Integer i1 = Integer.parseInt(s.split(":")[0].split(",")[0]);
                Integer i2 = Integer.parseInt(s.split(":")[0].split(",")[1]);
                Integer s1 = Integer.parseInt(s.split(":")[1].split("x")[0]);
                Integer s2 = Integer.parseInt(s.split(":")[1].split("x")[1]);
                for (Integer i = i1, j = 0; j < s1; ++j) {
                    for (Integer k = i2, g = 0; g < s2; ++g) {
                        ++field[i + j][k + g];
                        if (overlap[i + j][k + g].equals("0")) {
                            overlap[i + j][k + g] = ids.get(t);
                        } else {
                            overlap[i + j][k + g] = "X";
                        }
                    }
                }
            }/*
            for (int i = 0; i < 1000; ++i) {
                for (int j = 0; j < 1000; ++j) {
                    System.out.print(overlap[i][j]);
                }
                System.out.println("");
            }*/
            String id = "0";
            for (int i = 0; i < 1000; ++i) {
                for (int j = 0; j < 1000; ++j) {
                    if (!overlap[i][j].equals("0") && !overlap[i][j].equals("X")) {

                        int i1 = Integer.parseInt(l.get(overlap[i][j].toString()).split(":")[0].split(",")[0]);
                        int i2 = Integer.parseInt(l.get(overlap[i][j].toString()).split(":")[0].split(",")[1]);
                        int j1 = Integer.parseInt(l.get(overlap[i][j].toString()).split(":")[1].split("x")[0]);
                        int j2 = Integer.parseInt(l.get(overlap[i][j].toString()).split(":")[1].split("x")[1]);

                        if (i1 == i && i2 == j) {
                            if (ids.contains(overlap[i][j])) {
                                if (blokTester(i, j, j1, j2, overlap, l)){
                                }
                                else {
                                    id = overlap[i][j];
                                    System.out.println("Field id without overlaps is: " + id);
                                }
                            }
                        }
                        ids.remove(overlap[i][j].toString());
                    }
                }
            }
        }
        int size = 0;
        for (Integer[] i : field) {
            for (Integer i1 : i) {
                if (i1 > 1) {
                    ++size;
                }
            }
        }/*
            for(String i : ids) {
                System.out.println(i);
            }*/
        System.out.println("Inches of fabrics that are in more than one clames: " + size);
    }

    public static boolean blokTester(int i, int j, int j1, int j2, String[][] overlap, HashMap<String, String> l) {

        boolean isOverlap = false;
        for (int t = i; t < i + j1 ; ++t) {
            for (int t1 = j; t1 < j + j2 ; ++t1) {
                if (!overlap[i][j].equals(overlap[t][t1])) {
                    isOverlap = true;
                }
                if (isOverlap)
                    break;
            }
            if (isOverlap)
                break;
        }
        return isOverlap;
    }
}

