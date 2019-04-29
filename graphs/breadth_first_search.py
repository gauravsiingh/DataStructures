# -*- coding: utf-8 -*-
"""
Created on Mon Apr 29 14:22:43 2019

@author: varunshrivastava
"""

import undirected_graph;


class VertexInfo:
    vertex = None
    isMarked = False
    edgeTo = None
    
    def __init__(self, vertex, isMarked = False, edgeTo = None):
        self.vertex = vertex
        self.isMarked = isMarked
        self.edgeTo = edgeTo
        
    def printInfo(self):
        print("vertex: {}, isMarked: {}, edgeTo: {}"
              .format(self.vertex, self.isMarked, self.edgeTo))
    
    
class GraphTraversal:
    
    graph = None
    verticesInfo = []
    
    def __init__(self, graph):
        self.graph = graph
        for v in range(self.graph.vertices):
            self.verticesInfo.append(VertexInfo(v, False, None))
    
    def dfs(self, s): 
        
        #self.verticesInfo[s].printInfo()
        self.verticesInfo[s].isMarked = True

        for edge in self.graph.adjacentEdges(s):
            if False == self.verticesInfo[edge].isMarked:
                self.dfs(edge)
                self.verticesInfo[s].edgeTo = edge
                
    def vertexInfo(self, vertex):
        self.verticesInfo[vertex].printInfo()
        
    def allVerticesInfo(self):
        for vertex in self.verticesInfo:
            vertex.printInfo()
            
graph = undirected_graph.Graph()
traverseGraph = GraphTraversal(graph)
traverseGraph.dfs(0)
traverseGraph.vertexInfo(6)
traverseGraph.vertexInfo(4)
traverseGraph.vertexInfo(3)
traverseGraph.vertexInfo(5)   
traverseGraph.vertexInfo(0)   

print("All Info")
traverseGraph.allVerticesInfo()  