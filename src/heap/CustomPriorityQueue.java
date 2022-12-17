package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomPriorityQueue {
    List<Integer> list = new ArrayList<>();

    public void add(int num){
        list.add(num);
        upHeapify();
    }

    private void upHeapify() {
        int k = list.size() - 1;

        while (k > 0){
            int parent = (k-1)/2;
            if(list.get(k) < list.get(parent)){
                swap(k, parent);
                k = parent;
            }
            else
                return;
        }
    }

    private void swap(int k, int parent) {
        int temp = list.get(k);
        list.add(k, list.get(parent));
        list.add(parent, temp);
    }

    public int remove(){
        int result = Integer.MAX_VALUE;
        if (list.size() == 0)
            return result;

        if (list.size() == 1) {
            result = list.get(0);
            list.remove(0);
            return result;
        }

        result = list.get(0);
        int size = list.size();
        list.add(0, list.get(size-1));
        list.remove(size-1);

        downHeapify();
        return result;
    }

    private void downHeapify() {
        int i = 0;
        int size = list.size();

        do {
            int left = (2 * i) +1;
            int right = left  + 1;

            int min = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;
            if(right < size -1){
                if(left < right){
                   min = list.get(left);
                   index = left;
                } else {
                    min = list.get(right);
                    index = right;
                }
            } else if(left < size-1){
                min = list.get(left);
                index = left;
            }

            if(min < list.get(i)){
                swap(index,i);
                i = index;
            }else {
                return;
            }

        } while (i < size);

    }

    public int peek(){
        if(list.size() == 0) {
            return Integer.MAX_VALUE;
        }

        return list.get(0);
    }
}
