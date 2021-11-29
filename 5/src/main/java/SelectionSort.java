public class SelectionSort<T> implements SortingAlgorithm<T>{

    private record SortEntry<T>(int index, T element){ }

    private RelationFunction<T> relationFunction;

    public SelectionSort(RelationFunction<T> relationFunction){
        this.relationFunction = relationFunction;
    }

    private boolean elementsAtIndicesAreNotEqual(T[] elements, int index1, int index2){
        return !(elements[index1].equals(elements[index2]));
    }

    private void swapElementsIfContentNotEqual(T[] elements, int oldIndex, int newIndex){
        if(elementsAtIndicesAreNotEqual(elements, oldIndex, newIndex)) {
            var temp = elements[oldIndex];
            elements[oldIndex] = elements[newIndex];
            elements[newIndex] = temp;
        }
    }

    private boolean notInOrderAccordingToRelationFunction(SortEntry<T> t1, SortEntry<T> t2){
        return !(this.relationFunction.compare(t1.element, t2.element));
    }

    private int indexOfSmallestElementStartingWith(T[] elements, int startIndex){
        var currentMinimum = new SortEntry<T>(startIndex, elements[startIndex]);
        for(int index = currentMinimum.index; index < elements.length; index++){
            var maybeNewMinimum = new SortEntry<T>(index, elements[index]);
            if (notInOrderAccordingToRelationFunction(currentMinimum, maybeNewMinimum)) {
                currentMinimum = maybeNewMinimum;
            }
        }
        return currentMinimum.index;
    }

    @Override
    public void sort(T[] elements){
        for(int i = 0; i < elements.length; i++) {
            var indexOfSmallestElement = indexOfSmallestElementStartingWith(elements, i);
            if(indexOfSmallestElement > i ) {
                swapElementsIfContentNotEqual(elements, i, indexOfSmallestElement);
            }
        }
    }
}
