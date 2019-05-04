import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Day1 {


    public static void main (String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Integer sumFrequency = 0, duplicate = null;
        LinkedList<Integer> frequencys = new LinkedList<>();
        LinkedList<String> patern = new LinkedList<>();
        LinkedList<Integer> runs = new LinkedList<>();

        try {
            while (!(line = br.readLine()).equals("end")) {

                sumFrequency += Integer.parseInt(line);
                frequencys.add(sumFrequency);
                patern.add(line);
            }
        }
        catch (IOException e){
            System.out.println("Error");
        }

        finally {
            System.out.println("Starting sum calculator");
            Integer sum = sumFrequency;
            boolean isFound = false;

            System.out.println("Starting process to find duplicate freq");
            while (!isFound){
                for(String s : patern) {

                    sum += Integer.parseInt(s);
                    if (frequencys.contains(sum)) {
                        isFound = true;
                        duplicate = sum;
                        break;
                    }
                    frequencys.add(sum);
                }
            }

            System.out.println("First duplicate frequency is: " + duplicate + "\nResult frequency is: " + sumFrequency);
        }
    }
}
