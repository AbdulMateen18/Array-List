public class AList<T> implements ListInterface<T>{
	private T[] list;
	private int count;
	
	public AList(){
		this.count = 0;
		list = (T[]) new Object[25];
	} 

	public AList(int size){
		if(size < 25){
			size = 25;
			this.count = 0;
			list = (T[]) new Object[size];
		}
	}	

	public void add(T item){
		this.list[count] = item;
		count++;
		checkCapacity();
	}
	public void add(int position, T item){
		if(position >=0 && position <= count){
			for (int i = count; i > position ;i-- ) {
				list[i] = list[i - 1];
			}
			list[position] = item;
			checkCapacity();
			count++;
		}
	}

	private void checkCapacity(){
		if(count == this.list.length){
			T[] newList = (T[]) new Object[this.list.length * 2];
			for (int i = 0; i < this.list.length; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}
	}

	public void remove(int position){
		if(position >=0 && position <= count){
			for (int i = position; i < this.count-1; i++) {
				this.list[i] = this.list[i+1];
			}
			count--;
		}
	}
	public T replace(int position, T item){
		T oldValue = null;
		if(position >=0 && position <= count){
			oldValue = this.list[position];
			this.list[position] = item;
		}
		return oldValue;
	}
	public void clear(){
		this.count = 0;
	}
	public boolean isEmpty(){
		return this.count == 0;
	}
	public T getEntry(int position){
		T value = null;
		if(position >=0 && position <= count){
			value = this.list[position];	
		}
		return value;
	}
	public boolean contains(T item){
		for (int i = 0; i < count ; i++) {
			if(this.list[i].equals(item))
				return true;
		}
		return false;
	}
	public int search(T item){
		for (int i = 0; i < count ; i++) {
			if(this.list[i].equals(item))
				return i;
		}
		return -1;	
	}
	public int getLength(){
		return this.count;
	}
	public T[] toArray(){
		T[] arr = (T[]) new Object[this.count];
		for (int i = 0; i < count ; i++) {
			arr[i] = this.getEntry(i);
		}
		return arr;
	}

	public void print(){
		for (int i = 0;i < count ; i++) {
			System.out.print(this.list[i] + " ");
		}
	}
}