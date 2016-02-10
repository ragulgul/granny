package com.granny.codegen

import grails.transaction.Transactional
import org.apache.velocity.Template
import org.apache.velocity.VelocityContext

@Transactional
class ConceptGeneratorService {

    def velocityEngine

    def grailsApplication

    def generateConcept(Concept concept) {
        Template template = velocityEngine.getTemplate(grailsApplication.config.conceptVMPath.toString())
        VelocityContext context = new VelocityContext();
        context.put("context",concept)
        context.put("conceptProperties",concept.conceptProperties)
        context.put("repository",concept.repository)
        StringWriter writer = new StringWriter();
        template.merge(context,writer)
        return writer.toString()
    }

}
