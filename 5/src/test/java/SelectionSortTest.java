import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SelectionSortTest {

    @Test
    void biggerSet(){
        Integer[] ints = new Integer[]{22,9,1,5,6,10,23,55,44};
        SelectionSort<Integer> s = new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        s.sort(ints);
        assertEquals(1, ints[0]);
        assertEquals(5, ints[1]);
        assertEquals(6, ints[2]);
        assertEquals(9, ints[3]);
        assertEquals(10, ints[4]);
        assertEquals(22, ints[5]);
        assertEquals(23, ints[6]);
        assertEquals(44, ints[7]);
        assertEquals(55, ints[8]);
    }

    @Test
    void swappingTwoValuesWithoutSorting(){
        Integer[] randomSet = new Integer[]{3,4,6,1};
        var sortAlgorithm =  new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        var temp = randomSet[0];
        randomSet[0] = randomSet[1] ;
        randomSet[1] = temp;
        assertEquals(randomSet[0], 4);
        assertEquals(randomSet[1], 3);
    }

    @Test
    void sortCallIgnoresEqualElements(){
        var st1 = new String("Bbc");
        var st2 = new String("Bbc");
        String[] randomSet = new String[]{"A",st1,st2,"C","D"};
        var hash1 = randomSet[1].hashCode();
        var hash2 = randomSet[2].hashCode();
        var sortAlgorithm =  new SelectionSort<>(CutoutRelationFunctions.stringRelationFunction);
        sortAlgorithm.sort(randomSet);
        assertEquals(randomSet[1].hashCode(),hash1);
        assertEquals(randomSet[2].hashCode(),hash2);
    }

    @Test
    void sortedSetRemainsUnchanged(){
        Integer[] ints = new Integer[]{1,2,3,4,5};
        SelectionSort<Integer> s = new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        s.sort(ints);
        assertEquals(1, ints[0]);
        assertEquals(2, ints[1]);
        assertEquals(3, ints[2]);
        assertEquals(4, ints[3]);
        assertEquals(5, ints[4]);
    }

    @Test
    void setOf4(){
        Integer[] ints = new Integer[]{22,9,1,5};
        SelectionSort<Integer> s = new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        s.sort(ints);
        assertEquals(1, ints[0]);
        assertEquals(5, ints[1]);
        assertEquals(9, ints[2]);
        assertEquals(22,ints[3]);
    }

    @Test
    void sortedArrayDoesntChange(){
        Integer[] ints = new Integer[]{1,2,3,4};
        SelectionSort<Integer> s = new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        s.sort(ints);
        assertEquals(1,ints[0]);
        assertEquals(2, ints[1]);
        assertEquals(3, ints[2]);
        assertEquals(4, ints[3]);
    }

    @Test
    void setOf3(){
        Integer[] ints = new Integer[]{22,9,1};
        SelectionSort<Integer> s = new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        s.sort(ints);
        assertEquals(1, ints[0]);
        assertEquals(9, ints[1]);
        assertEquals(22, ints[2]);
    }

    @Test
    void returnSetAfterSorting(){
        Integer[] ints = new Integer[]{3,4,6,1};
        var sortAlgorithm =  new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        sortAlgorithm.sort(ints);
        assertEquals(1, ints[0]);
        assertEquals(3, ints[1]);
        assertEquals(4, ints[2]);
        assertEquals(6, ints[3]);
    }

    @Test
    void returnSetBeforeSorting(){
        var ints = new Integer[]{3,4,6,1};
        var sortAlgorithm =  new SelectionSort<>(CutoutRelationFunctions.intRelationFunction);
        assertEquals(3, ints[0]);
        assertEquals(4, ints[1]);
        assertEquals(6, ints[2]);
        assertEquals(1, ints[3]);
    }


    @Test
    void relationFunctionStringShouldBeTrue(){
        RelationFunction<String> stringRelationFunction = CutoutRelationFunctions.stringRelationFunction;
        assertTrue(stringRelationFunction.compare("Anna","Baba"));
    }

    @Test
    void relationFunctionStringShouldBeFalse(){
        RelationFunction<String> stringRelationFunction = CutoutRelationFunctions.stringRelationFunction;
        assertFalse(stringRelationFunction.compare("Baba","Annna"));
    }

    @Test
    void relationFunctionShouldBeTrue(){
        RelationFunction<Integer> intRelationFunction = CutoutRelationFunctions.intRelationFunction;
        assertTrue(intRelationFunction.compare(2,3));
    }

    @Test
    void relationFunctionShouldBeFalse(){
        RelationFunction<Integer> intRelationFunction = CutoutRelationFunctions.intRelationFunction;
        assertFalse(intRelationFunction.compare(3,2));
    }

}
