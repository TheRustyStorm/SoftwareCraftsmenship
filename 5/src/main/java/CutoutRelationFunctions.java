public class CutoutRelationFunctions {
    public static RelationFunction<Integer> intRelationFunction = (p1, p2) -> {return p1 <= p2;} ;
    public static RelationFunction<String> stringRelationFunction = (p1, p2) -> {return p1.compareTo(p2) < 0;} ;
}
