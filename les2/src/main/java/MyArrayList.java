public class MyArrayList<T> implements MyList<T> {

    private static int poolSize = 10;

    private T[] elements;
    private int size = -1;

    public MyArrayList() {
        elements = (T[]) new Object[poolSize];

    }

    public MyArrayList(int poolSize) {
        this.poolSize =poolSize;
    }

    private T[] extendArray() {
        T[] newArray = (T[]) new Object[size + poolSize];
        for(int i = 0; i <elements.length; i++) {
            newArray[i] = elements[i];
        }
        return newArray;
    }

    @Override
    public void add(T t) {
        size++;
        if(size == elements.length) {
            elements = extendArray();
        };
        elements[size] = t;
    }

    @Override
    public T get(int i) {
        checkRange(i);
        return elements[i-1];
    }

    @Override
    public void removeElementByIndex(int index) {
        checkRange(index);
        for(int j = index-1;j< elements.length - 1; j ++) {
            elements[j] = elements[j+1];
        }
        elements[elements.length-1] = null;
        size--;
    }




    @Override
    public void addAfterIndex(int index, T t) {
        if(size == elements.length) {
            elements = extendArray();
        }
        size++;
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = t;
    }

    private void checkRange(int i) {
        if(i > elements.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= size; i++) {
            builder.append(elements[i]);
            if(i<size) {
                builder.append("; ");
            }
        }
        return "MyArrayList{" + builder.toString() + "}" + " size: " + size + " length:" + elements.length ;
    }

    @Override
    public int size() {
        return size;
    }
}
