package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        private int curIndex = -1;
        private int listSize = Solution.this.size();

        @Override
        public boolean hasNext() {
            return Solution.this.size() > 0;
        }

        @Override
        public T next() {
            if (listSize != Solution.this.size()) {
                throw new ConcurrentModificationException();
            }
            curIndex++;
            if (curIndex >= Solution.this.size()) {
                curIndex = 0;
            }
            return Solution.this.get(curIndex);
        }

        @Override
        public void remove() {
            if (curIndex >= 0 && curIndex < Solution.this.size()) {
                Solution.this.remove(curIndex);
                curIndex--;
                listSize--;
            }
        }
    }
}
