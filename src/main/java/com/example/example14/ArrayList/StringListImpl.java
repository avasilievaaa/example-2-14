package com.example.example14.ArrayList;

import com.example.example14.Exception.ItemNotFoundException;

import java.util.Objects;

public class StringListImpl implements StringList {

    private String[] array = new String[10];
    private int size = 0;

    @Override
    public String add(String item) {
        if (size >= array.length) {
            String[] extended = new String[array.length * 2];
            System.arraycopy(array, 0, extended, 0, array.length);
            array = extended;
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(item);
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        String old = get(index);
        array[index] = item;
        return old;
    }

    @Override
    public String remove(String item) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                a = i;
                break;
            }
        }
        if (a != -1) {
            remove(a);
        } else {
            throw new ItemNotFoundException();
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String element = get(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean contains(String item) {
        boolean exist = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        boolean result = true;
        if (this.size != otherList.size()) {
            result = false;
        } else {
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(otherList.get(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        for (String s : array) {
            if (s != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        array = new String[13];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[this.size];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = this.get(i);
        }
        return newArray;
    }
}