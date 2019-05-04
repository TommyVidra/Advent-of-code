import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Day2 {

    public static void main (String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int twice = 0, three = 0;
        LinkedList<String> lines = new LinkedList<>();
        LinkedList<Character> chars = new LinkedList<>();

        try {
            while (!(line = br.readLine()).equals("end")) {

                lines.add(line);
                for (int i = 0; i < line.length(); ++i) {
                    chars.add(line.charAt(i));
                }
            }
        }
        catch (IOException e){

            System.out.println("Error");
        }
        finally {

            for(int i = 0; i < lines.size(); ++i){
                for(int j = i + 1; j < lines.size(); ++j){
                    int distance = 0, c = 0;
                    for(int k = 0; k < lines.get(i).length(); ++k){
                        if(lines.get(i).charAt(k) != lines.get(j).charAt(k)){
                            ++distance;
                            c = k;
                        }
                    }
                    if(distance == 1){
                        String s3 = lines.get(i).replace(Character.toString(lines.get(i).charAt(c)), "");
                        System.out.println("Common letters: " + s3);
                    }
                }
            }
            for(String s : lines){
                StringBuilder sb = new StringBuilder(s);
                String s1 = sb.toString();
                System.out.println("Krecem");
                boolean isTwo = false, isThree = false, done = false;
                for(int i = 0; i < s1.length(); ++i){
                    System.out.println(s1);
                    int rep = 1;

                    for (int j = i + 1; j < s1.length(); ++j){
                        if(s1.charAt(i) == 'X' || done){
                            System.out.println("doing nothing");
                        }
                        else if(s1.charAt(i) == s1.charAt(j)){
                            ++rep;
                            System.out.println("found an repeated char " + s1.charAt(i));
                            sb.setCharAt(j, 'X');
                        }
                    }
                    if(rep == 2 && !isTwo) {
                        ++twice;
                        isTwo = true;
                    }
                    else if(rep == 3 && !isThree){
                        ++three;
                        isThree = true;
                    }

                    sb.setCharAt(i, 'X');
                    s1 = sb.toString();
                }
            }

            System.out.println("Number of twos is: " + twice + " Number of threes is: " + three + "\nChecksum is: " + three*twice);
        }
    }
}
