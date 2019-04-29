# -*- coding: utf-8 -*-
"""
Created on Fri Apr 26 14:23:31 2019

@author: varunshrivastava
"""

class Graph:
    
    vertices = 0
    verticesBag = []
    
    def __init__(self):
        self.initGraph(13)
        self.initEdges()

    def initGraph(self, vertices):
        self.vertices = vertices
        for v in range(vertices):
            self.verticesBag.append([])
            
    def addEdge(self, v, w):
        self.verticesBag[v].append(w)
        self.verticesBag[w].append(v)

    def adjacentEdges(self, v):
        #for edge in self.verticesBag[v]:
         #   print(edge, end=" ")   
            
        return self.verticesBag[v]
            
    def initEdges(self):
        with open('graph.txt') as graphFile:
            lines = graphFile.readlines()
            for line in lines:
                vw = line.strip().split(" ")
                self.addEdge(int(vw[0]), int(vw[1]))
            
# graph = Graph()
# graph.adjacentEdges(0)