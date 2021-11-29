import java.util.Optional;

class RomanNumber{
    private final int minimumRomanNumber = 1;
    private final int maximumRomanNumber = 3999;
    
    private Optional<String> stringRepresentation = Optional.empty();
    private Optional<Integer> intRepresentation = Optional.empty();

    String[] romanNumberStrings = {"I","IV","V","IX","X","XL","L","LC","C","CD","D","DM","M"};
    int[]    romanNumberValues  = { 1,  4,   5,  9,   10, 40,  50, 90,  100,400, 500,900, 1000};

    public String toString(){
        return this.intRepresentation.get() + " \t" + this.stringRepresentation.get();
    }
    
    public String stringRepresentationUnwrapped(){
        return this.stringRepresentation.get();
    }
    
    public int intRepresentationUnwrapped(){
        return this.intRepresentation.get();
    }

    public RomanNumber(int number){
        var maybeRomanString = intToRomanString(number);
        if(maybeRomanString.isPresent()){
            this.stringRepresentation = maybeRomanString;
            this.intRepresentation = Optional.of(number);
        }
    }

    public RomanNumber(String romanString){
        var maybeRomanInt = romanStringToInt(romanString);
        if(maybeRomanInt.isPresent()){
            this.intRepresentation = maybeRomanInt;
            this.stringRepresentation = Optional.of(romanString);
        }
    }
    
    private boolean isInRomanNumberRange(int number) {
        return number >= minimumRomanNumber && number <= maximumRomanNumber;
    }

    private Optional<String> intToRomanString(int number){
        if(!isInRomanNumberRange(number)){
            return Optional.empty();
        }
        var builder = new StringBuilder(); 
        
        for(int index = romanNumberValues.length - 1; index >= 0;){
            if (number >= romanNumberValues[index]){
                builder.append(romanNumberStrings[index]);
                number -= romanNumberValues[index];
            } else{
                index--;
            }
        }
        return Optional.of(builder.toString());
    }

    private Optional<Integer> romanStringToInt(String romanString) {
        var currentRomanValue = 0;
        while(romanString.length() > 0) {
            var highestIndex = highestRomanStringPrefixIndex(romanString);
            currentRomanValue += romanNumberValues[highestIndex];
            romanString = removeRomanPrefixFromRomanString(romanString, highestIndex);
        }
        if(isInRomanNumberRange(currentRomanValue)){
            return Optional.of(currentRomanValue);
        } else{
            return Optional.empty();
        }
    }
    
    private int highestRomanStringPrefixIndex(String romanString) {
        var highestIndex = 0;
        for(int i = 0; i < romanNumberStrings.length; i++){
            if (romanString.startsWith(romanNumberStrings[i])){
                highestIndex = i;
            }
        }
        return highestIndex;
    }
    
    private String removeRomanPrefixFromRomanString(String romanString, int substringIndex) {
        return romanString.substring(romanNumberStrings[substringIndex].length());
    }
    
}

public class Roman{
    public static void main(String[] args) {
        for(int x = 1; x <= 3999; x++){
            RomanNumber r = new RomanNumber(x);
            RomanNumber r1 = new RomanNumber(r.stringRepresentationUnwrapped());
            System.out.println(r);
        }
    }
}