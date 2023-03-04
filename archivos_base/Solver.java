import java.util.ArrayList;

public class Solver {
    
    private ArrayList<String> route;
    private ArrayList<String> shortestRoute;
    private boolean exit = false;

    public Solver() {
        route = new ArrayList<String>();
    }

    public String solve(Maze maze) {
        route.clear();
        exit = false;
        
        Node startNode = maze.getStartingSpace();

        solveRecursive(maze, startNode, exit, null);
        shortestRoute = shortRoute(maze, route);

        return shortestRoute.toString().replace(" ", "");
    }

    private ArrayList<String> shortRoute(Maze maze, ArrayList<String> route) {
        //TODO make implementation
        
        Node finalNode = maze.getStartingSpace();
        route.remove(finalNode);

        return route;
    }

    private boolean solveRecursive(Maze maze, Node currentNode, boolean exit, Node lastNode) {

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
            if (currentNode.north && !currentNode.danger && !maze.moveNorth(currentNode).isExit && lastNode != maze.moveNorth(currentNode) ) {
                route.add("N");
                exit = solveRecursive( maze, maze.moveNorth(currentNode), exit, currentNode );
                if(exit) return true;
            }
            if (currentNode.east && !currentNode.danger && !maze.moveEast(currentNode).isExit && lastNode != maze.moveEast(currentNode) ) {
                route.add("E");
                exit = solveRecursive( maze, maze.moveEast(currentNode), exit, currentNode );
                if(exit) return true;
            }
            if (currentNode.south && !currentNode.danger && !maze.moveSouth(currentNode).isExit && lastNode != maze.moveSouth(currentNode) ) {
                route.add("S");
                exit = solveRecursive( maze, maze.moveSouth(currentNode), exit, currentNode );
                if(exit) return true;
            }
            if (currentNode.west && !currentNode.danger && !maze.moveWest(currentNode).isExit && lastNode != maze.moveWest(currentNode) ) {
                route.add("W");
                exit = solveRecursive( maze, maze.moveWest(currentNode), exit, currentNode );
                if(exit) return true;
            }
            if (currentNode.up && !currentNode.danger && !maze.moveUp(currentNode).isExit && lastNode != maze.moveUp(currentNode) ) {
                route.add("U");
                exit = solveRecursive( maze, maze.moveUp(currentNode), exit, currentNode );
                if(exit) return true;
            }
            if (currentNode.down && !currentNode.danger && !maze.moveDown(currentNode).isExit && lastNode != maze.moveDown(currentNode) ) {
                route.add("D");
                exit = solveRecursive( maze, maze.moveDown(currentNode), exit, currentNode );
                if(exit) return true;
            }
        }
        
        return false;
    }

}
