package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root = new Entry<>("0");

    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        void checkChildren() {
            availableToAddLeftChildren = leftChild == null;
            availableToAddRightChildren = rightChild == null;
        }

        boolean isAvailableToAddChildren() {
            return  availableToAddLeftChildren || availableToAddRightChildren;
        }

        public boolean remove(String s) {
            if (elementName.equals(s)) {
                if (parent != null) {
                    if (parent.leftChild != null && parent.leftChild == this) {
                        parent.leftChild = null;
                        //availableToAddLeftChildren = false;
                        parent = null;
                        return true;
                    }
                    if (parent.rightChild != null && parent.rightChild == this) {
                        parent.rightChild = null;
                        //availableToAddRightChildren = false;
                        parent = null;
                        return true;
                    }
                }
            }
            if (leftChild != null && leftChild.remove(s)) return  true;
            if (rightChild != null && rightChild.remove(s)) return  true;
            return false;
        }

        public int size() {
            int count = 1;
            if (leftChild != null) {
                count += leftChild.size();
            }
            if (rightChild != null) {
                count += rightChild.size();
            }
            return count;
        }

        public String getParent(String s) {
            if ( (leftChild != null && leftChild.elementName.equals(s)) || (rightChild != null && rightChild.elementName.equals(s)) ) {
                return elementName;
            }
            String res = null;
            if (leftChild != null) {
                res = leftChild.getParent(s);
                if (res != null) {
                    return  res;
                }
            }
            if (rightChild != null) {
                res = rightChild.getParent(s);
                if (res != null) {
                    return  res;
                }
            }
            return null;
        }
    }


    @Override
    public boolean add(String s) {
        if (root == null) {
            root = new Entry<String>(s);
            root.parent = null;
            return true;
        }
        else {

            Queue<Entry<String>> queue = new LinkedList<Entry<String>>();
            queue.add(root);
            Entry entryToAdd = new Entry(s);

            while (!queue.isEmpty()) {
                Entry current = queue.poll();
                current.checkChildren();

                if (current.availableToAddLeftChildren) {
                    current.leftChild = entryToAdd;
                    current.leftChild.parent = current;
                    return true;
                } else if (current.availableToAddRightChildren) {
                    current.rightChild = entryToAdd;
                    current.rightChild.parent = current;
                    return true;
                } else {
                    queue.add(current.leftChild);
                    queue.add(current.rightChild);
                }

            }
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        if (root == null) {
            return false;
        }
        boolean isRootRemove = root.elementName.equals(s);
        boolean result = root.remove(s);
        if (isRootRemove) root = null;
        return result;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        else {
            return root.size()-1;
        }
    }

    public String getParent(String s) {
        if (root == null) {
            return null;
        }
        else {
            return root.getParent(s);
        }
    }
}
