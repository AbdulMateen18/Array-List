public interface ListInterface<T>{
	void add(T item);
	void add(int position, T item);
	void remove(int position);
	T replace(int position, T item);
	void clear();
	boolean isEmpty();
	T getEntry(int position);
	boolean contains(T item);
	int search(T item);
	int getLength();
	T[] toArray();
	void print();
}