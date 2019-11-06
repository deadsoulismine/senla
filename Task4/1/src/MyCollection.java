import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntFunction;

public class MyCollection<T> implements Collection<T> {
    private T[] collectionArray;
    private int size;

    public MyCollection() {
        collectionArray = (T[]) new Object[1500000];
        size = 0;
    }

    public MyCollection(T[] collectionArray) {
        this.collectionArray = collectionArray;
        size = 0;
    }

    @Override
    public int size() {
        return this.collectionArray.length;
    }

    @Override
    public boolean isEmpty() {
        for (T n : this.collectionArray) {
            if (n != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (T n : this.collectionArray) {
            if (n == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.stream(collectionArray).iterator();
    }

    @Override
    public Object[] toArray() {
        return collectionArray;
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return new Object[0];
    }

    @Override
    public boolean add(T object) {
        if (size < collectionArray.length) {
            collectionArray[size++] = object;
        } else {
            int updatedLength = (int) Math.round(collectionArray.length * 1.5 + 1);
            Object[] newCollectionArray = new Object[updatedLength];

            int i = 0;
            for (i = 0; i < collectionArray.length; i++) {
                newCollectionArray[i] = collectionArray[i];
            }
            newCollectionArray[i] = object;

            collectionArray = (T[]) newCollectionArray;
        }
        return true;
    }

    @Override
    public boolean remove(Object object) {
        Object[] myArray = new Object[this.collectionArray.length];
        int j = 0;
        for (int i = 0; i < this.collectionArray.length; i++) {
            if (this.collectionArray[i] != object) {
                myArray[j] = this.collectionArray[i];
                j++;
            }
        }
        this.collectionArray = (T[]) myArray;
        return true;
    }

    @Override
    public boolean addAll(java.util.Collection <? extends T> collection) {
        if (this.collectionArray.length + collection.size() >= this.size) {
            for (T o : collection) {
                this.collectionArray[this.collectionArray.length] = o;
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(this.collectionArray, null);
    }

    @Override
    public boolean retainAll(java.util.Collection collection) {
        boolean another = false;
        for (int i = 0; i < collectionArray.length; i++) {
            if (!collection.contains((collectionArray[i]))) {
                collectionArray[i] = null;
                another = true;
            }
        }
        return another;
    }

    @Override
    public boolean removeAll(java.util.Collection collection) {
        boolean another = false;
        for (int i = 0; i < collectionArray.length; i++) {
            if (collection.contains((collectionArray[i]))) {
                collectionArray[i] = null;
                another = true;
            }
        }
        return another;
    }

    @Override
    public boolean containsAll(java.util.Collection collection) {
        for (int i = 0; i < collectionArray.length; i++) {
            if (collection.contains((collectionArray[i]))) {
                collectionArray[i] = null;
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length >= size) {
            for (int i = 0, j = 0; i < collectionArray.length; i++) {
                if (collectionArray[i] != null) {
                    objects[j++] = collectionArray[i];
                }
            }
            return objects;
        }
        return objects;
    }
}
