package fr.epita.assistants.myset;
import java.util.*;

public class GenericSet <T extends Comparable<T>>{
    private List<T> base_;

    public GenericSet(){
        base_ = new ArrayList<>();

    }
    public void insert(T i){
        if(!has(i)) {
            base_.add(i);
            Collections.sort(base_);
        }
    }
    public void remove(T i){
         base_.remove(i);
    }
    public boolean has(T i){
        return base_.contains(i);
    }
    public boolean isEmpty(){
        return base_.isEmpty();
    }
    public T max(){
        return base_.get(base_.size()-1);
    }
    public T min(){
        return base_.get(0);
    }
    public int size(){
        return base_.size();
    }

    public static <T extends Comparable<T>> GenericSet<T> intersection(GenericSet<T> a, GenericSet<T> b){
        GenericSet<T> result = new GenericSet<>();
        for(T elem : a.base_){
            if(b.has(elem)){
                result.insert(elem);
            }
        }
        return result;
    }

    public static <T extends Comparable<T>> GenericSet<T> union(GenericSet<T> a, GenericSet<T> b){
        GenericSet<T> result = new GenericSet<>();
        for(T elem : a.base_) result.insert(elem);
        for(T elem : b.base_) result.insert(elem);
        return result;
    }

}