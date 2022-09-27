package nary_tree;

import javax.swing.JOptionPane;

public class TreeN {

    private Node head;

    public TreeN() {

    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void insert(String data) {
        head = new Node(data);
    }

    public void insert(Node r, String father, String data) {
        Node p = r, x, q;

        while (p != null) {
            if (p.getSw() == 0) {
                if (p.getData().equals(father)) {
                    x = new Node(data);
                    if (p == r) {
                        q = p;
                        while (q.getLink() != null) {
                            q = q.getLink();
                        }
                        q.setLink(x);
                    } else {
                        Node cab = new Node(father);
                        cab.setLink(x);
                        p.setSw(1);
                        p.setLinkList(cab);
                    }
                }
            } else {
                insert(p.getLinkList(), father, data);
            }
            p = p.getLink();
        }
    }

    public void show(Node r) {
        Node p = r;

        while (p != null) {
            if (p.getSw() == 0) {
                if (p == r) {
                    System.out.println(p.getData());
                } else {

                    System.out.println(p.getData());
                }
            } else {
                show(p.getLinkList());
            }
            p = p.getLink();
        }
    }

//    public void delete(Node r, String data) {
//        Node p = r;
//        Node ant = null;
//        Boolean bandera = false;
//
//        while (p != null && bandera == false) {
//            if (p.getSw() == 0) {
//                if (p.getData().equals(data)) {
//                    bandera = true;
//                }
//            } else {
//                ant = p;
//                p = p.getLink();
//            }
//        }
//
//        if (bandera = false) {
//            JOptionPane.showMessageDialog(null, "El dato no está");
//        } else {
//            if (p == r) {
//                r.getLink();
//
//            } else {
//                ant.setLink(p.getLink());
//            }
//
//        }
//    }
    public void delete(Node r, String data) {
        Node p = r;
        Node ant = p;
    }

    public String search(Node r, String data) {
        Node p = r;
        String aux = " No se encontró el dato ";
        Boolean bandera = true;

        while (p != null && bandera == true) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    aux = p.getData();
                    bandera = false;
                }
            } else {
                aux = search(p.getLinkList(), data);
            }
            p = p.getLink();
        }
        return aux;
    }

    public void showRoot(Node r) {
        Node p = r;

        while (p != null) {
            if (p.getSw() == 0) {
                if (p == r) {
                    System.out.println(p.getData());
                }
            } else {
                showRoot(p.getLinkList());
            }
            p = p.getLink();
        }
    }

    public int counSheet(Node r) {
        Node p = r;
        int count = 0;
        while (p != null) {
            if (p.getSw() == 0) {
                if (p != r) {
                    count++;
                }
            } else {
                count = counSheet(p.getLinkList());
            }
            p = p.getLink();
        }
        return count;
    }

    public void showSheets(Node r) {
        Node p = r;

        while (p != null) {
            if (p.getSw() == 0) {
                if (p != r) {
                    System.out.println(p.getData());
                }
            } else {
                showSheets(p.getLinkList());
            }
            p = p.getLink();
        }
    }

    public int treeGrade(Node r) {
        Node p = r;
        int count = 0, grade = 0;

        while (p != null) {
            if (p.getSw() == 0) {
                count++;
            } else {
                grade = treeGrade(p.getLinkList());
            }
            p = p.getLink();
            if (count > grade) {
                grade = count;
            }
        }
        return grade;
    }

    public void nodeGrade(Node r, String data) {
        Node p = r;
        Boolean bandera = true;
        int cont = -1;

        while (p != null && bandera == true) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    while (p != null) {
                        cont = cont + 1;
                        p = p.getLink();
                    }
                    bandera = false;
                    JOptionPane.showMessageDialog(null, "El grado del dato es: " + cont);
                }
            } else {
                nodeGrade(p.getLinkList(), data);
            }
            p = p.getLink();
        }
        if (bandera == true) {
            JOptionPane.showMessageDialog(null, "No se encontró el dato");
        }

    }

}
