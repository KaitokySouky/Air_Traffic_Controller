package classes;
import java.util.*;
public class Node implements Comparable<Node> {
    private final String name;
    private String adresse;
    private Integer distance =Integer.MAX_VALUE;
    private List<Node> shortestPath = new LinkedList<>();
    private Map<Node,Integer> adjacentNodes = new HashMap<>();
    
    public Node(String name,String adresse) {
        this.name = name;
        this.adresse=adresse;
    }

    

    public void addAdjacentNode(Node node ,int weight){
        adjacentNodes.put(node,weight);
    }




    
    public String getName() {
        return name;
    }





    public Integer getDistance() {
        return distance;
    }





    public void setDistance(Integer distance) {
        this.distance = distance;
    }





    public List<Node> getShortestPath() {
        return shortestPath;
    }





    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }





    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }





    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }





    @Override
    public int compareTo(Node node){
         return Integer.compare(this.distance,node.getDistance());
    }



    public String getAdresse() {
        return adresse;
    }



    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
