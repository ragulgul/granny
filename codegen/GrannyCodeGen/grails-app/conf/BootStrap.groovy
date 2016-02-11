import com.granny.codegen.Concept
import com.granny.codegen.enums.PropertyType
import com.granny.codegen.repo.Repository
import com.granny.codegen.ConceptProperty


class BootStrap {

    def velocityEngine
    def grailsApplication

    def init = { servletContext ->

        //velocityEngine.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM, this)
        //velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("file.resource.loader.path", grailsApplication.config.velocityTemplatePath);
        velocityEngine.setProperty("file.resource.loader.cache", true);
        //velocityEngine.setProperty("file.resource.loader.modificationCheckInterval", 3000);
        velocityEngine.init()

        /**
         * Seed the system with one concept
         */
        if(Concept.count()==0){
            createConcept()
        }
    }

    def destroy = {

    }

    def createConcept(){
        def concept = new Concept(name: "Menu",description:"This is the collection of food items categorized by meal type")
        def repo = new Repository(uri:"com.granny.food",shorthand: "food")
        repo.save(failOnError: true)
        concept.repository = repo
        concept.save(failOnError: true)

        ConceptProperty prop1 = new ConceptProperty(propertyType:PropertyType.String,name: "category",belongsToConcept:concept)
        prop1.save(failOnError: true)
        ConceptProperty prop2 = new ConceptProperty(propertyType:PropertyType.Boolean,name: "available",belongsToConcept:concept)
        prop2.save(failOnError: true)
        ConceptProperty prop3 = new ConceptProperty(propertyType:PropertyType.String,name: "description",belongsToConcept:concept)
        prop3.save(failOnError: true)
        ConceptProperty prop4 = new ConceptProperty(propertyType:PropertyType.String,name: "name",belongsToConcept:concept)
        prop4.save(failOnError: true)

        concept.addToConceptProperties(prop1)
        concept.addToConceptProperties(prop2)
        concept.addToConceptProperties(prop3)
        concept.addToConceptProperties(prop4)
        concept.save(failOnError: true)
    }

}
