import java.util.ArrayList;
import java.util.Arrays;

class OccurenceList{
    public ArrayList<Integer> list = new ArrayList<>();

    public void addOccurenceEntry(OccurenceEntry entry){
        this.list.add(entry.number);
        this.list.add(entry.counter);
    }

    public int[] toArray() {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

class OccurenceEntry{
    public int number;
    public int counter;

    public OccurenceEntry(int number){
        this.number = number;
        this.counter = 1;
    }

    public void increaseCounter(){
        this.counter++;
    }
}

public class U1{

    // Don't put null values in, or else you'll get a Null-Pointer Exception, duh
    public static int[] encode(int [] data){
        if (data.length == 0)
            return new int[]{};

        var encodedList = new OccurenceList();
        OccurenceEntry occurence = null;

        for(var number: data){
            if(occurence == null){
                occurence = new OccurenceEntry(number);
                continue;
            }

            if (number == occurence.number){
                occurence.increaseCounter();
            }
            else{
                encodedList.addOccurenceEntry(occurence);
                occurence = new OccurenceEntry(number);
            }
        }

        encodedList.addOccurenceEntry(occurence);   

        return encodedList.toArray();
    }

    public static void main(String [] args){
        var testcases = new int[][]{
            null,
            {},
            {2},
            {2,2},
            {2,2,2},
            {2,2,2,7},
            {2,2,2,7,2},
        };
        for(var testcase: testcases){
            System.out.println(Arrays.toString(U1.encode(testcase)));
        }
    }
}