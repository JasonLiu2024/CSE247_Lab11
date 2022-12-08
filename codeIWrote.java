//for the run() method
while(pq.isEmpty() == false) {
    		PQEntry<VertexAndDist, Integer> uHandle = pq.extractMin();//get node
    		VertexAndDist uVD = uHandle.getElement();
    		Vertex uVTX = uVD.getVertex();
    		
    		for(Edge e : uVTX.edgesFrom()) {
    			int lenUV = weights.get(e);
    			int alt = uVD.getDistance() + lenUV;
    			
    			PQEntry<VertexAndDist, Integer> vHandle = handles.get(e.to);
    			
    			VertexAndDist vd1 = vHandle.getElement();
    			
    			int distV = vd1.getDistance();
    			Vertex vVTX = vd1.getVertex();

    			
    			if(alt < distV) {
    				vd1.setDistance(alt);
    				parentEdges.put(vVTX, e);
    				vHandle.updatePriority(alt); 
    			}
    			
    		}
    		
    	}
    }
    
    
//for the returnPath() method
    public LinkedList<Edge> returnPath(Vertex endVertex) {
    	LinkedList<Edge> path = new LinkedList<Edge>();
	
    	//
    	Vertex whatever = endVertex;
    	while(whatever.equals(startVertex) == false) {
    		Edge e = parentEdges.get(whatever); //edge leading to whatever
    		path.addFirst(e);
    		whatever = e.from;
    	}
    	//
 
    	return path;
    }
