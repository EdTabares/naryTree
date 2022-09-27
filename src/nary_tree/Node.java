package nary_tree;

public class Node {

    private int sw;
    private String data;
    private Node linkList, link;

    public Node(String data) {
        this.data = data;
        this.sw = 0;
        linkList = null;
        link = null;
    }
    
//    public Node(int sw, String data, Node linkList, Node link) {
//        this.data = data;
//        this.sw = 0;
//        linkList = null;
//        link = null;
//    }

    public Node() {

    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLinkList() {
        return linkList;
    }

    public void setLinkList(Node linkList) {
        this.linkList = linkList;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }

}
