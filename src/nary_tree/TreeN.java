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

    public int counSheet(Node r, int count) {
        Node p = r;
        while (p != null) {
            if (p.getSw() == 0) {
                if (p != r) {
                    count++;
                }
            } else {
                count = counSheet(p.getLinkList(), count);
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

    public int treeGrade(Node r, int grade) {
        Node p = r;
        int count = 0;
        grade++;

        while (p != null) {
            if (p.getSw() == 0) {
                count++;
            } else {
                grade = treeGrade(p.getLinkList(), grade);
            }
            p = p.getLink();
            if (count > grade) {
                grade = count;
            }
        }
        return grade;
    }

    public void nodeGrade(Node r, String data, boolean bandera) { //9
        Node p = r;
        // Boolean bandera = true;
        int cont = 0;

        while (p != null && bandera == true) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    if (r != p) {
                        JOptionPane.showMessageDialog(null, "El grado del dato es: 0\n");
                    } else {
                        r = r.getLink();
                        while (r != null) {
                            cont = cont + 1;
                            r = r.getLink();
                        }
                        bandera = false;
                        JOptionPane.showMessageDialog(null, "El grado del dato es: " + cont + "\n");
                    }
                }
            } else {
                nodeGrade(p.getLinkList(), data, bandera);
            }
            p = p.getLink();
        }
    }

    public void showChilds(Node r, String data) {
        Node p = r;
        while (p != null) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    System.out.print("Los hijos del dato dado son: \n");
                    r = r.getLink();
                    while (r != null) {
                        System.out.print(" " + r.getData());
                        r = r.getLink();
                    }
                }
            } else {
                showChilds(p.getLinkList(), data);
            }
            p = p.getLink();
        }
    }

    public boolean showSiblings(Node r, String data) {
        boolean flag = false;
        if (head.getData().equals(data)) {
            System.out.println("La cabeza no tiene hermanos \n");
        } else {

            Node p = r;
            while (p != null) {
                if (p.getSw() == 0) {
                    flag = false;
                    if (p.getData().equals(data) && p != r && flag == false) {
                        System.out.print("Los hermanos del dato son: \n");
                        r = r.getLink();
                        while (r != null) {
                            if (!r.getData().equals(data)) {
                                System.out.print(" " + r.getData() + "\n");
                            }
                            r = r.getLink();
                        }                        
                    } else {                        
                            flag = true;                                               
                    }
                } else {
                    flag = showSiblings(p.getLinkList(), data);
                    if (flag == true && p.getLinkList().getData().equals(data)) {
                        System.out.print("Los hermanos del dato son: \n");
                        r = r.getLink();
                        while (r != null) {
                            if (!r.getData().equals(data)) {
                                System.out.print(" " + r.getData() + "\n");
                            }
                            r = r.getLink();
                        }
                    }
                }
                p = p.getLink();
            }
        }
        return flag;
    }

    public String getFather(Node r, Node antFather, String data) {
        String father = "";
        Node p = r;
        Node ant = new Node();
        //antFather = p;
        boolean flag = false;
        while (p != null && flag == false) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    father = antFather.getData();
                    flag = true;
                }
            } else {
                father = getFather(p.getLinkList(), p, data);
            }
            ant = p;
            p = p.getLink();
        }
        return father;
    }

    public int showDataLevel(Node r, String data, int levelcount) {
        Node p = r;
        levelcount++;
        Boolean bandera = true;
        while (p != null && bandera == true) {
            if (p.getSw() == 0) {
                if (p.getData().equals(data)) {
                    System.out.print("El nivel del dato es " + levelcount);
                    bandera = false;
                }
            } else {
                levelcount = showDataLevel(p.getLinkList(), data, levelcount);
                //levelcount++;
            }
            p = p.getLink();
        }
        return levelcount;
    }

    public int showHeight(Node r, int heightcount) {
        Node p = r;
        heightcount++;
        while (p != null) {
            if (p.getSw() == 0) {
                //no tiene que hacer nada
            } else {
                heightcount = showHeight(p.getLinkList(), heightcount);
            }
            p = p.getLink();
        }
        return heightcount;
    }
}
