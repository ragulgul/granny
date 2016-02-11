package com.granny.codegen

import grails.transaction.Transactional
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.tools.generic.DisplayTool

@Transactional
class ConceptGeneratorService {

    def velocityEngine

    def grailsApplication

    def generateConcept(Concept concept) {
        concept.loadUsedConcepts()
        Template template = velocityEngine.getTemplate(grailsApplication.config.conceptTemplate.toString())
        VelocityContext context = new VelocityContext();
        context.put("display",new DisplayTool())
        context.put("concept",concept)
        context.put("conceptProperties",concept.conceptProperties)
        context.put("repository",concept.repository)
        context.put("repositoryuri",concept.repository.uri)
        context.put("usesConcepts",concept.usesConcepts.collect({
            it.repository.uri
        }))
        StringWriter writer = new StringWriter();
        template.merge(context,writer)
        return writer.toString()
    }

}
