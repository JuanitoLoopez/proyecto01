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

        // System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z
        // " + node.zIndex);
        // -CASO BASE [] -CASO RECUSIVO [S] [N] [E] [W] [U] [D] [S,N] [S,E] [S,W] [E,N]
        // [E,S] [N,E] [S,N,E] [S,N,W] [S,N,U] [S,N,D] [S,E,N] [S,E,U] [S,E,E]
        
        while (!isExit) {
            node = maze.getStartingSpace();

            if (!isExit && node.east)
                result += moveToEast(maze);
            if (!isExit && node.south)
                result += moveToSouth(maze);
            if (!isExit && node.up)
                result += moveToUp(maze);
            if (!isExit && node.north)
                result += moveToNorth(maze);
            if (!isExit && node.west)
                result += moveToWest(maze);
            if (!isExit && node.down)
                result += moveToDown(maze);

            // solve(maze);
            isExit = true;
        }

        return result + "]";
    }

    private String moveToEast(Maze maze) {
        if (node.east) {
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
            node = maze.moveSouth(node);

            if (node.danger)
                return "";

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