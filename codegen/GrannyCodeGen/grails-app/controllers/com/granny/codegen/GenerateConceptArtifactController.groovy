package com.granny.codegen

class GenerateConceptArtifactController {

    def conceptGeneratorService

    def generateConceptArtifact() {
        def conceptList = Concept.findAll()
        def response = conceptGeneratorService.generateConcept(conceptList.get(0))
        render response
    }
}
