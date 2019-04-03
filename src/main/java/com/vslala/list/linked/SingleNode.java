package com.vslala.list.linked;

import java.util.Objects;

public class SingleNode<T> {
    Object data;
    SingleNode next;

    public SingleNode() {
    }

    public SingleNode(Object data, SingleNode next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleNode<?> that = (SingleNode<?>) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, next);
    }
}
