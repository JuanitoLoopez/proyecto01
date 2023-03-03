/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/

public class Solver {

    private boolean isExit = false;
    private Node node;

    public Solver() {
        // Sientase libre de implementar el contructor de la forma que usted lo desee

    }

    public String solve(Maze maze) {
        // Implemente su metodo aqui. Sientase libre de implementar métodos adicionales

        String result = "[";
        isExit = false;

        while (!isExit) {
            // System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z
            // " + node.zIndex);

            node = maze.getStartingSpace();

            if (!isExit)
                result += moveToEast(maze);
            if (!isExit)
                result += moveToSouth(maze);
            if (!isExit)
                result += moveToUp(maze);
            if (!isExit)
                result += moveToNorth(maze);
            if (!isExit)
                result += moveToWest(maze);
            if (!isExit)
                result += moveToDown(maze);

            // if (node.east) {
            // node = maze.moveEast(node);
            // if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
            // Node.resetNodesCount();
            // isExit = true;
            // return result + "E]";
            // } else {
            // result += "E,";
            // }
            // }

            // if (node.south) {
            // node = maze.moveSouth(node);
            // if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
            // Node.resetNodesCount();
            // isExit = true;
            // return result + "S]";
            // } else {
            // result += "S,";
            // }
            // }

            // if (node.up) {
            // node = maze.moveUp(node); // U
            // if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
            // Node.resetNodesCount();
            // isExit = true;
            // return result + "U]";
            // } else {
            // result += "U,";
            // }
            // }

            // if (node.north) {
            // node = maze.moveNorth(node);
            // if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
            // Node.resetNodesCount();
            // isExit = true;
            // return result + "N]";
            // } else {
            // result += "N,";
            // }
            // }

            // if (node.west) {
            // node = maze.moveWest(node);
            // if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
            // Node.resetNodesCount();
            // isExit = true;
            // return result + "W]";
            // } else {
            // result += "W,";
            // }
            // }

            // if (node.down) {
            // node = maze.moveDown(node);
            // if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
            // Node.resetNodesCount();
            // isExit = true;
            // return result + "D]";
            // } else {
            // result += "D,";
            // }
            // }

            // isExit = true;
        }

        return result + "]";
    }

    private String moveToEast(Maze maze) {
        if (node.east) {
            System.out.println("SI FUNCIONA ==> EAST");
            node = maze.moveEast(node);

            if (node.danger)
                return "";

            if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                isExit = true;
                Node.resetNodesCount();
                return "E";
            } else {
                return "E,";
            }
        }
        return "";
    }

    private String moveToSouth(Maze maze) {
        if (node.south) {
            System.out.println("SI FUNCIONA ==> SOUTH");
            node = maze.moveSouth(node);

            if (node.danger)
                return "";

            System.out.println("SI FUNCIONA ==> SOUTH-1");
            if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                isExit = true;
                Node.resetNodesCount();
                return "S";
            } else {
                return "S,";
            }
        }
        return "";
    }

    private String moveToNorth(Maze maze) {
        if (node.north) {
            node = maze.moveNorth(node);

            if (node.danger)
                return "";

            if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                isExit = true;
                Node.resetNodesCount();
                return "N";
            } else {
                return "N,";
            }
        }
        return "";
    }

    private String moveToUp(Maze maze) {
        if (node.up) {
            node = maze.moveUp(node);

            if (node.danger)
                return "";

            if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                isExit = true;
                Node.resetNodesCount();
                return "U";
            } else {
                return "U,";
            }
        }
        return "";
    }

    private String moveToWest(Maze maze) {
        if (node.west) {
            node = maze.moveWest(node);

            if (node.danger)
                return "";

            if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                isExit = true;
                Node.resetNodesCount();
                return "W";
            } else {
                return "W,";
            }
        }
        return "";
    }

    private String moveToDown(Maze maze) {
        if (node.down) {
            node = maze.moveDown(node);

            if (node.danger)
                return "";

            if (maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                isExit = true;
                Node.resetNodesCount();
                return "D";
            } else {
                return "D,";
            }
        }
        return "";
    }

}