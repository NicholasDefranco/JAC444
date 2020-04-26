
/**
 * Write a description of class Sequence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.HashMap;

public class Sequence {
    
    private HashMap<Integer, Double> sequence = new HashMap<>();  
    
    private double start; 
    private double specialNumber;
    
    private SequenceType type;
    
    enum SequenceType {
        
        Arithemetic, Geometric
        
    }

    /**
     * Constructor for objects of class Sequence
     */
    public <T, V extends Number> Sequence(SequenceType type, T start, V specialNumber) {
        
        this.type = type;
        this.start = start.doubleValue();
        this.specialNumber = specialNumber;
        
        sequence.put(1, start);
        
    }
    
    public Sequence(SequenceType type, double specialNumber) {
        
        this(type, 0, specialNumber);
        
    }
    
    public Sequence(SequenceType type){
        this(type, 0, 1);
    }

    public double getValue(int termNumber){
    
        return sequence.computeIfAbsent(termNumber, x -> sequence.put(termNumber, calculateSequence(termNumber)));
    
    }
    
    private double calculateSequence(int termNumber){
        
        for(int i = 1; i <= termNumber; i++){
            
            if(!sequence.containsKey(i)){
                sequence.put(i, sequence.get(i - 1) + specialNumber);
            }
            
        }
        
        return sequence.get(termNumber);
       
    }
    
    @Override
    public String toString(){
        return type.toString();
    }
    
    public static void main(String[] args){
        
        Sequence s = new Sequence(SequenceType.Arithemetic, 1, 3);
        
        System.out.println(s.getValue(5));
        System.out.println(s.getValue(4));
        
    }
    
}
