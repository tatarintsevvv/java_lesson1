package ru.geekbrains;

public class Link<T> {
    private T link;
    private Link<T> next;

    public Link(T link) { this.link = link;}

    public  Link<T> getNext() {return this.next;}

    public void setNext(Link<T> next) {this.next = next;}

    public T getValue() {return link;};
}

class SimpleLinkedList<T> {
    private Link<T> first;

    public SimpleLinkedList() {first = null;}

    public boolean isEmpty() { return (first == null);}

    public boolean add(T link, int position) {
        if(position < 0)
            return  false;
        if(link == null)
            return false;
        Link<T> temp = new Link<>(link);

        int i = 0;
        if(position == 0) {
            temp.setNext(this.first);
            this.first = temp;
            return true;
        }
        Link<T> elem = this.first;
        Link <T> prev = null;
        while(i < position) {
            ++i;
            prev = elem;
            elem = elem.getNext();
            if(elem == null) {
                break;
            }
        }
        if(i == position) {
            prev.setNext(temp);
            temp.setNext(elem);
            return true;
        }
        return false;
    }

    public void remove(T link) {
        Link<T> elem = this.first;
        // проверяю первый элемент на совпадение, делаю пока первый элемент равен со смещением первого элемента
        while(elem != null) {
            if(this.first == null)
                return;
            if (elem.getValue().equals(link)) {
                this.first = elem.getNext();
            } else
                break;
        }
        if(this.first == null)
            return;
        // проходим циклом по всем элементам и если значение совпадает, удаляем
        Link<T> prev = elem;
        while(elem.getNext() != null) {
            elem = elem.getNext();
            if(elem.getValue().equals(link)) {
                prev.setNext(elem.getNext());
            }
        }
    }

    public Link<T> remove(int position) {
        Link<T> res = null;
        if((position < 0) || (this.first == null))
            return null;
        int i = 0;
        Link<T> elem = this.first;
        do {
            // если найден искомый индекс
            if(i == position) {
                res = elem;
                if(i == 0) {
                    this.first = elem.getNext();
                }
                break;
            }
            i++;
        } while(elem.getNext() != null);
        return res;
    }

    public void set(T link, int position) {
        int i = 0;
        Link<T> elem = this.first;
        Link <T> prev = null;

        if(i < 0)
            return;

        while(i < position) {
            if(elem == null)
                break;
            ++i;
            prev = elem;
            elem = elem.getNext();
        }
        if((i == position) && (elem != null)) {
            Link<T> temp = elem;
            elem = new Link<T>(link);
            prev.setNext(elem);
            elem.setNext(elem.getNext());
        }
    }

    public T get(int position) {
        T res = null;
        Link<T> elem = this.first;
        int i = 0;
        while(i < position) {
            if(elem == null)
                break;
            ++i;
            elem = elem.getNext();
        }
        if((i == position) && (elem != null)){
            res = elem.getValue();
        }
        return res;
    }
}