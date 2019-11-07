import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.stream.Stream;

public class MyCollection<T> implements Collection<T> {
    private T[] collectionArray;
    private int size;

    private static final int CAPACITY = 10;

    /*AT
        В данном случае есть смысл уменьшить начальную вместимость,
        так как в большинстве задач элементов будет на порядок меньше,
        а память уже выделена.
    */
    //UPD МТ Поправлено по указаниям преподавателя
    public MyCollection(T[] bufArray) {
        if (bufArray.length == 0) {
            this.collectionArray = (T[]) new Object[CAPACITY];
        } else {
            this.collectionArray = bufArray;
        }
        size = 0;
    }

    /*AT
        В данном случае выводится вместимость массива,
        а по задумке метода - должно возвращаться количество элементов,
        в данном случае size
    */
    //UPD МТ Поправлено по указаниям преподавателя
    @Override
    public int size() {
        return size;
    }

    /*AT
        При такой проверке будут не учитываться помещённые
        внутрь объекты со значением null. Метод будет работать
        некорректно. Достаточно проверить size == 0
    */
    //UPD МТ Поправлено по указаниям преподавателя
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*AT
        Желательно использовать стрим. Да и компактнее код будет
        без потери читабельности.
    */
    @Override
    public boolean contains(Object bufObject) {
        for (T n : this.collectionArray) {
            if (n == bufObject) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        Stream<T> temp = Arrays.stream(collectionArray).limit(size);
        return temp.iterator();
    }

    @Override
    public Object[] toArray() {
        /*AT
            Здесь необходимо возвращать копию массива,
            иначе, при дальнейших изменениях, будет меняться
            наш массив.
         */
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
            for (i = 0; i < size; i++) {
                newCollectionArray[i] = collectionArray[i];
            }
            newCollectionArray[size] = object;
            collectionArray = (T[]) newCollectionArray;
        }
        size++;
        return true;
    }

    /*AT
        Можно получать индекс элемента
        int index = Arrays.asList(collectionArray).indexOf(object);
        А дальше сдвигать элементы массива с помощью System.arraycopy
    */
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
    public boolean addAll(Collection <? extends T> collection) {
        /*AT
        Достаточно для каждого элемента collection применить метод add()
         */
        if (this.collectionArray.length + collection.size() >= this.size) {
            for (T o : collection) {
                this.collectionArray[this.collectionArray.length] = o;
            }
            return true;
        }
        return false;
    }

    /*AT
        При большом количестве элементов меньше
        нагружать память будет создание нового экземпляра массива
    */
    @Override
    public void clear() {
        Arrays.fill(this.collectionArray, null);
    }

    /*AT
        Более эффективно превратить массив в стрим и
        отфильтровать значения, принадлежащие collection
    */
    @Override
    public boolean retainAll(Collection collection) {
        boolean another = false;
        for (int i = 0; i < collectionArray.length; i++) {
            if (!collection.contains((collectionArray[i]))) {
                collectionArray[i] = null;
                another = true;
            }
        }
        return another;
    }

    /*AT
       Аналогично retainAll, но отфильтровать элементы
       не принадлежащие collection
    */
    @Override
    public boolean removeAll(Collection collection) {
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
    public boolean containsAll(Collection collection) {
        /*АТ
        Лучше переписать на стрим
         */
        for (int i = 0; i < collectionArray.length; i++) {
            if (!collection.contains((collectionArray[i]))) {
                return false;
            }
        }
        return true;
    }

    /*
    Здесь лучше использовать дженерики
    public <T1> T1[] toArray(T1[] objects) {
     */
    @Override
    public Object[] toArray(Object[] objects) {
        if (objects.length >= size) {
            for (int i = 0, j = 0; i < collectionArray.length; i++) {
                /*AT
                При такой проверке теряем объекты со значением null.
                 */
                if (collectionArray[i] != null) {
                    objects[j++] = collectionArray[i];
                }
            }
            return objects;
        }
        return objects;
    }
}
