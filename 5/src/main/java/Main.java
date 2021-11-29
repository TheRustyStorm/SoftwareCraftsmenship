public class Main {

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{9,1,5,6,10,23,55,44};
        SelectionSort<Integer> s = new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        s.sort(ints);
        for(var e: ints){
            System.out.println(e);
        }
    }
}
