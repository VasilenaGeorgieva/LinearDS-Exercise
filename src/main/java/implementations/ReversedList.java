package implementations;

import java.util.Iterator;

public class ReversedList<E> implements interfaces.ReversedList {
    private  final int Def_Capacity = 2;
    private int _size;

    private Object[] internArr;

    public ReversedList()
    {
        this.internArr = new Object[Def_Capacity];
        this._size = 0;
    }

    @Override
    public void add(Object element) {
        CheckCapacity();
        this.internArr[this._size] = element;
        this._size++;
    }

    @Override
    public int size() {
        return this._size;
    }

    @Override
    public int capacity() {
        return this.internArr.length;
    }

    @Override
    public Object get(int index) {
        if (this._size <=0 || !(IsValidIndex(index))){
            return null;
        }

        int realIndex = GetRealIndex(index);
        return GetAt(realIndex);
    }

    @Override
    public Object removeAt(int index) {
        if(!(IsValidIndex(index)) || this._size <= 0)
        {
            throw new IllegalArgumentException();
        }
        int realIndex = index;
        E element = GetAt(realIndex);
        RemoveElement(realIndex);
        return element;
    }

    @Override
    public Iterator iterator() {
        return new Iterator()  {
            private int current = _size -1;
            @Override
            public boolean hasNext() {
                return current>=0;
            }

            @Override
            public E next() {
                return GetAt(current--);
            }
        };
    }

    private void CheckCapacity() {
        if (capacity() == this._size) {
            GrowInnerArray();
        }
    }

    private E GetAt(int realIndex){
        return (E)this.internArr[realIndex];
    }

    private int GetRealIndex(int index){
        return ((this._size -1)-index);
    }

    private void GrowInnerArray(){
        Object[] temp = new Object[(capacity()*2)];
        for (int i = 0; i < this._size; i++) {
            temp[i] = this.internArr[i];
        }
        this.internArr = temp;
    }

    private boolean IsValidIndex(int index){
        if(index >= this._size || index < 0){
            return false;
        }
        return true;
    }

    private void RemoveElement(int realIndex){

        for (int i = realIndex; i < this._size; i++) {
            this.internArr[i] = this.internArr[i+1];
        }
        this.internArr[_size -1] = null;
        this._size--;
    }
}
