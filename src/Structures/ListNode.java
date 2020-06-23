package Structures;

/**
 * @author Richie
 */

public class ListNode <T> {
    private T data;
    private ListNode link;

    public ListNode(T data, ListNode getLink) {
        this.data = data;
        this.link = getLink;
    }

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode getLink() {
        return link;
    }

    public void setLink(ListNode getLink) {
        this.link = getLink;
    }

    @Override
    public String toString() {
        return data + " --> ";
    }
}
