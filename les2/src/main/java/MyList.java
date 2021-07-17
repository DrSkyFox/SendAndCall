public interface MyList<T> {
    void add(T t);
    void addAfterIndex(int index, T t);
    T get(int i);
    void removeElementByIndex(int index);
    int size();


}
