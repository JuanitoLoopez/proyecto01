/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/

public class Solver{

    public Solver(){
        //Sientase libre de implementar el contructor de la forma que usted lo desee
        
    }

    public String solve(Maze maze){
        //Implemente su metodo aqui. Sientase libre de implementar métodos adicionales

        String result = "[";
        boolean isExit = false;
        
        while(!isExit) {
            
            Node node = maze.getStartingSpace();
            System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z " + node.zIndex);
            
            // ALGORITMO DE BUSQUEDA startNode => actualNode
            // result += moveToSouth(maze, node);

            if(node.east) {
                node = maze.moveEast(node);
                System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z " + node.zIndex);
                if(maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                    Node.resetNodesCount();
                    result += "E";
                    return result + "]";
                } else {
                    result += "E,";
                }
            }

            if(node.south) {
                node = maze.moveSouth(node);
                System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z " + node.zIndex);
                if(maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                    Node.resetNodesCount();
                    result += "S";
                    return result + "]";
                } else {
                    result += "S,";
                }
            }

            if(node.up) {
                node = maze.moveUp(node); // U
                System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z " + node.zIndex);
                if(maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                    Node.resetNodesCount();
                    result += "U";
                    return result + "]";
                } else {
                    result += "U,";
                }
            }

            if(node.north) {
                node = maze.moveNorth(node);
                System.out.println("node: " + "x "+ node.xIndex + ", y " + node.yIndex + ", z " + node.zIndex);
                if(maze.isExitSpace(node.xIndex, node.yIndex, node.zIndex)) {
                    Node.resetNodesCount();
                    result += "N";
                    return result + "]";
                } else {
                    result += "N,";
                }
            }


            // maze.moveNorth(actualNode); // N
            // maze.moveWest(actualNode); // W
            // maze.moveDown(actualNode); // D           

            isExit = true;

        }

        return result + "]";
    }

    String moveToSouth(Maze maze, Node actualNode) {
        if(actualNode.south) {
            maze.moveSouth(actualNode);
        }
        return "S";
    }

}