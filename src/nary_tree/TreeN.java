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

    public void delete(Node r, String data) {
        Node p = r;
        Node ant = p;
        Boolean bandera = true;

        if (p.getData().equals(data) && p.getLink() != null) {
            String father = p.getLink().getData();
            delete(p, father);
            p.setData(father);
        }

        if (p.getLink() != null) {
            p = p.getLink();
        }

        while (p != null && bandera == true) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) { //Eliminar si es una hoja
                    ant.setLink(p.getLink());
                    bandera = false;
                }
            } else {
                delete(p.getLinkList(), data);
                if (p.getLinkList().getLink() == null) {
                    p.setData(p.getLinkList().getData());
                    p.setSw(0);
                    p.setLinkList(null);
                }
            }
            ant = p;
            p = p.getLink();
        }
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

    public void showChilds(Node r, String data) {

    }

//    public void showSiblings(Node r, String data){
//        Node p = r;
//        Boolean bandera = true;
//        while (p != null && bandera == true) {
//            if (p.getSw() == 0) {
//                if (p.getData().equals(data)) {
//                    System.out.print("Los hermanos del dato son: ");
//                    p= p.getLink();
//                    while(p != null){
//                        System.out.println(" "+p.getData());                                                                                                                                                            p=p.getLink();                                         
//                    }
//                    bandera = false;
//                }
//            } else {
//                showSiblings(p.getLinkList(), data);
//            }
//            p = p.getLink();
//        }
//        if (bandera == true) {
//            JOptionPane.showMessageDialog(null, "No se encontró el dato");
//        }
//    }
    
    public void showSiblings(Node r, String data){
        String x = getFather(r, data);
        System.out.println(x);
    }
    
    
    public String getFather(Node r, String data){
        String father="";
        Node p = r;
        Node ant;
        Node antFather = p;
        while (p != null) {            
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                     father = ant.getData();                                           
                }
            } else{
                ant = p;
                getFather(p.getLinkList(), data);
            }
            ant = p;
            p = p.getLink();
        }
    return father;    
    }

    public int showDataLevel(Node r, String data) {
        Node p = r;
        int levelcount = 1;
        Boolean bandera = true;
        while (p != null && bandera == true) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    System.out.print("El nivel del dato es " + levelcount);
                    bandera = false;
                }
            } else {
                levelcount++;
                levelcount = showDataLevel(p.getLinkList(), data);
            }
            p = p.getLink();
        }
        if (bandera == true) {
            JOptionPane.showMessageDialog(null, "No se encontró el dato");
        }
        return levelcount;
    }

    public int showHeight(Node r) {
        Node p = r;
        int heightcount = 1;
        while (p != null) {
            if (p.getSw() == 0) {
                //no tiene que hacer nada
            } else {
                heightcount++;
                heightcount = showHeight(p.getLinkList());
            }
            p = p.getLink();
        }
        JOptionPane.showMessageDialog(null, "La altura del arbol es " + heightcount);
        return heightcount;
    }
}
