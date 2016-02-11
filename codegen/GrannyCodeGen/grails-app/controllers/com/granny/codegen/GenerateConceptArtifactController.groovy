package com.granny.codegen

class GenerateConceptArtifactController {

    def conceptGeneratorService

    def generateConceptArtifact() {
        def conceptList = Concept.findAll()
        def buffer = new StringBuffer()
        conceptList.each {
            buffer.append(conceptGeneratorService.generateConcept(it))
        }
        render buffer.toString()
    }
}
