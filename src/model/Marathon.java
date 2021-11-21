package model;

public class Marathon {


    private Programmer root;
    private boolean doesntExits;

    public Marathon() {
        this.doesntExits = false;
    }

    public void addProgrammer(String name, String phone, String address, String email) {
        if (root == null) {
            root = new Programmer(name, phone, address, email);
        } else {
            try {
                Programmer newProgrammer = new Programmer(name, phone, address, email);
                root.insert(newProgrammer);
            } catch (ProgrammerAlreadyExists e) {
                System.out.println(e);
            }
        }
    }

    public Programmer deleteProgrammer(Programmer current, String name) {
        if(current!=null) {
            if (current.getName().compareTo(name) == 0) {
                if (current.getLeft() == null && current.getRight() == null) {
                    return null;
                } else if (current.getLeft() != null && current.getRight() != null) {

                    Programmer aux = getMin(current.getRight());
                    Programmer rightT = deleteProgrammer(current.getRight(), aux.getName());
                    aux.setLeft(current.getLeft());
                    aux.setRight(rightT);
                    return aux;

                } else if (current.getLeft() != null) {
                    return current.getLeft();
                } else {
                    return current.getRight();
                }
            } else if (name.compareTo(current.getAddress()) < 0) {
                Programmer leftT = deleteProgrammer(current.getLeft(), name);
                current.setLeft(leftT);
            } else {
                Programmer newRightTree = deleteProgrammer(current.getRight(), name);
                current.setRight(newRightTree);
            }
        }
        else{
            doesntExits=true;
            return null;
        }
        return current;
    }

    public Programmer searchProgrammer(Programmer node, String name) {
        if (node == null) {
            return null;
        }
        if (node.getName().compareTo(name) == 0) {
            return node;
        }
        if (name.compareTo(node.getName()) < 0) {
            return searchProgrammer(node.getLeft(), name);
        } else {
            return searchProgrammer(node.getRight(), name);
        }
    }

    public void inOrder(Programmer node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.println(node.getName());
        inOrder(node.getRight());
    }



    public Programmer triggerSearchProgrammer(String name) {
        return searchProgrammer(root, name);
    }

    public void triggerDelete(String name) {
        if (root != null) {
            root = deleteProgrammer(root, name);
        }
        else{
            doesntExits=true;
        }
    }

    public void triggerInOrder() {
        inOrder(root);
    }

    public Programmer getMin(Programmer current) {

        if (current.getLeft() == null) {
            return current;
        } else {
            return getMin(current.getLeft());
        }
    }

    public boolean isDoesntExits() {
        return doesntExits;
    }

    public void setDoesntExits(boolean doesntExits) {
        this.doesntExits = doesntExits;
    }


}

