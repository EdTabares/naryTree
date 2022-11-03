package nary_tree;

import javax.swing.JOptionPane;

public class Nary_Tree {

    public static void main(String[] args) {
        menuPpal();
    }

    public static void menuPpal() {
        int opcion = 0;
        //String data = JOptionPane.showInputDialog("Ingrese un String para generar el árbol Binario: ");
        //char[] dataCh = data.toCharArray();
        TreeN tree = new TreeN();
        //tree.create(dataCh);
        String menu = "***MAIN MENU N-ARY TREES***\n"
                + "1- Show\n"
                + "2- Insert\n"
                + "3- Delete\n"
                + "4- Search data\n"
                + "5- Show roots\n"
                + "6- Show sheets quantity\n"
                + "7- Show sheets\n"
                + "8- Show tree grade\n"
                + "9- Show grade\n"
                + "10- Show childs\n"
                + "11- Show siblings\n"
                + "12- Show node'slevel\n"
                + "13- Show height\n"
                + "14- Show parent\n"                
                + "0- Salir";
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                Node p = tree.getHead();
                switch (opcion) {
                    case 1:
                        if (tree.getHead() == null) {
                            JOptionPane.showMessageDialog(null, "The tree is empty");
                        } else {
                            tree.show(p);
                        }
                        break;

                    case 2:
                        String data = JOptionPane.showInputDialog(null, "Write the data to insert: \n");
                        if (tree.getHead() == null) {
                            tree.insert(data);
                        } else {
                            String father = JOptionPane.showInputDialog(null, "Write the data's father: \n");
                            tree.insert(p, father, data);
                        }

                        break;
                    case 3:
                        String delete = JOptionPane.showInputDialog(null, "Write the data to delete: \n");
                        if (tree.getHead() == null) {
                            JOptionPane.showMessageDialog(null, "The tree is empty");
                        } else {
                            tree.delete(p, delete);
                        }

                        break;
                    case 4:
                        if (tree.getHead() == null) {
                            JOptionPane.showMessageDialog(null, "The tree is empty");
                        } else {
                            String dataSearch = JOptionPane.showInputDialog(null, "Write the data to search");
                            String x = tree.search(p, dataSearch);
                            JOptionPane.showMessageDialog(null, x);
                        }
                        break;

                    case 5:
                        tree.showRoot(p);
                        break;

                    case 6:
                        int quantity = tree.counSheet(p, 0);
                        JOptionPane.showMessageDialog(null, "These are " + quantity + " sheets");
                        break;

                    case 7:
                        tree.showSheets(p);
                        break;

                    case 8:
                        int gradeTree = tree.treeGrade(p, 0);
                        JOptionPane.showMessageDialog(null, "The grade tree is: " + gradeTree);
                        break;

                    case 9:
                        String data2 = JOptionPane.showInputDialog("Write the data");
                        boolean bandera = true;
                        tree.nodeGrade(p, data2, bandera);
                        break;

                    case 10:
                        String data3 = JOptionPane.showInputDialog("Write the data to see the childs");
                        tree.showChilds(p, data3);
                        break;

                    case 11:
                        String sibling = JOptionPane.showInputDialog("Write the data to see its siblings");
                        tree.showSiblings(p, sibling);
                        break;

                    case 12:
                        String dataLevel = JOptionPane.showInputDialog("Write the data to see its level");
                        tree.showDataLevel(p, dataLevel, 0);
                        break;

                    case 13:
                        int contAlt = tree.showHeight(p, 0);
                        JOptionPane.showMessageDialog(null, "La altura del arbol es " + contAlt);
                        break;

                    case 14:
                        String dataFather = JOptionPane.showInputDialog("Write the data to see its father");
                        if (p.getData().equals(dataFather)) {
                            JOptionPane.showMessageDialog(null, "El dato no tiene padre");
                        } else {
                            String father = tree.getFather(p, p, dataFather);
                            JOptionPane.showMessageDialog(null, "El padre es :" + father);
                        }
                        break;

                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);

    }

}
