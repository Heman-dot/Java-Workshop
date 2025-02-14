package fr.epita.assistants.myset;
import java.util.*;

public class IntegerSet {
    private List<Integer> base_;

    public IntegerSet() {
        base_ = new ArrayList<>();

    }

    public void insert(Integer i) {
        if (!has(i)) {
            base_.add(i);
            Collections.sort(base_);
        }
    }

    public void remove(Integer i) {
        base_.remove(i);
    }

    public boolean has(Integer i) {
        return base_.contains(i);
    }

    public boolean isEmpty() {
        return base_.isEmpty();
    }

    public Integer max() {
        return base_.get(base_.size() - 1);
    }

    public Integer min() {
        return base_.get(0);
    }

    public int size() {
        return base_.size();
    }

    public static IntegerSet intersection(IntegerSet a, IntegerSet b){
        IntegerSet result = new IntegerSet();
        for(Integer num : a.base_){
            if(b.has(num)){
                result.insert(num);
            }
        }
        return result;
    }

    public static  IntegerSet union(IntegerSet a, IntegerSet b){
        IntegerSet result = new IntegerSet();
        for(Integer elem : a.base_) result.insert(elem);
        for(Integer elem : b.base_) result.insert(elem);
        return result;
    }
}