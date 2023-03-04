import java.util.ArrayList;

/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/

public class Solver {
    
    private ArrayList<String> route;
    private boolean exit = false;

    public Solver() {
        route = new ArrayList<String>();
    }

    public String solve(Maze maze) {
        route.clear();
        exit = false;
        Node startNode = maze.getStartingSpace();

        solveRecursive(maze, startNode, exit);
        return route.toString().replace(" ", "");
    }

    private boolean solveRecursive(Maze maze, Node currentNode, boolean exit) {

        System.out.print("Result: " + route.toString());
        System.out.println(" Node: x="+currentNode.xIndex+" y="+currentNode.yIndex+" z="+currentNode.zIndex );

        // Consultamos el siguiente paso
        if(currentNode.north && maze.moveNorth(currentNode).isExit) {
            route.add("N");
            return true;
        } 
        if(currentNode.east && maze.moveEast(currentNode).isExit) {
            route.add("E");
            return true;
        } 
        if(currentNode.south && maze.moveSouth(currentNode).isExit) {
            route.add("S");
            return true;
        } 
        if(currentNode.west && maze.moveWest(currentNode).isExit) {
            route.add("W");
            return true;
        } 
        if(currentNode.up && maze.moveUp(currentNode).isExit) {
            route.add("U");
            return true;
        } 
        if(currentNode.down && maze.moveDown(currentNode).isExit) {
            route.add("D");
            return true;
        }
        
        // Realizamos recursividad
        if(!exit) {
            if (currentNode.north && !currentNode.danger && !maze.moveNorth(currentNode).isExit) {
                route.add("N");
                exit = solveRecursive( maze, maze.moveNorth(currentNode), exit );
                if(exit) return true;
            }
            if (currentNode.east && !currentNode.danger && !maze.moveEast(currentNode).isExit) {
                route.add("E");
                exit = solveRecursive( maze, maze.moveEast(currentNode), exit );
                if(exit) return true;
            }
            if (!exit && currentNode.south && !currentNode.danger && !maze.moveSouth(currentNode).isExit) {
                route.add("S");
                exit = solveRecursive( maze, maze.moveSouth(currentNode), exit );
                if(exit) return true;
            }
            if (currentNode.west && !currentNode.danger && !maze.moveWest(currentNode).isExit) {
                route.add("W");
                exit = solveRecursive( maze, maze.moveWest(currentNode), exit );
                if(exit) return true;
            }
            if (currentNode.up && !currentNode.danger && !maze.moveUp(currentNode).isExit) {
                route.add("U");
                exit = solveRecursive( maze, maze.moveUp(currentNode), exit );
                if(exit) return true;
            }
            if (currentNode.down && !currentNode.danger && !maze.moveDown(currentNode).isExit) {
                route.add("D");
                exit = solveRecursive( maze, maze.moveDown(currentNode), exit );
                if(exit) return true;
            }
        }
        
        return false;
    }
}
