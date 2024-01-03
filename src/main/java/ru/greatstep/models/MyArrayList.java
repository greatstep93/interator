package ru.greatstep.models;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    private Object[] innerArray = new Object[10];

    public void add(T object) {
        for (int i = 0; i < innerArray.length; i++) {
            if (innerArray[i] == null) {
                innerArray[i] = object;
                break;
            }

            if (i == innerArray.length - 1) {
                innerArray = Arrays.copyOf(innerArray, innerArray.length + 1);
                innerArray[innerArray.length - 1] = object;
                break;
            }
        }
    }

    public int size() {
        int size = 0;
        for (Object o : innerArray) {
            if (o != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public String toString() {

        String resultString = Arrays.toString(innerArray)
                .replaceAll("null, ", "")
                .replaceAll(" null", "");
        if (resultString.endsWith(",]")) {
            return resultString.replace(",]", "]");
        } else {
            return resultString;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < size();
            }

            @Override
            public T next() {
                var result = innerArray[iteratorIndex];
                iteratorIndex++;
                return (T) result;
            }

        };
    }

}
