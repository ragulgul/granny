import com.granny.codegen.Concept
import com.granny.codegen.enums.PropertyType
import com.granny.codegen.repo.Repository
import com.granny.codegen.ConceptProperty


class BootStrap {

    def velocityEngine
    def grailsApplication

    def init = { servletContext ->

        velocityEngine.setProperty("file.resource.loader.path", grailsApplication.config.velocityTemplatePath);
        velocityEngine.setProperty("file.resource.loader.cache", true);
        velocityEngine.init()
        /**
         * Seed the system with a couple of concepts
         */
        if(Concept.count()==0){
            def propList = []
            propList.add([propertyType:PropertyType.String,name: "category"])
            propList.add([propertyType:PropertyType.Boolean,name: "available"])
            propList.add([propertyType:PropertyType.String,name: "description"])
            propList.add([propertyType:PropertyType.String,name: "name"])
            def menuConcept = createConcept("Menu","This is a restaurant menu","com.granny.food","food",propList)

            propList.clear()
            propList.add([propertyType:PropertyType.Complex,name: "belongsToMenu",referencedConcept:menuConcept])
            propList.add([propertyType:PropertyType.Boolean,name: "available"])
            propList.add([propertyType:PropertyType.String,name: "name"])
            propList.add([propertyType:PropertyType.String,name: "description"])
            propList.add([propertyType:PropertyType.Double,name: "price"])
            def foodConcept = createConcept("FoodItem","This is a restaurant food item","com.granny.food","food",propList)
        }

    }

    def destroy = {

    }

    def createConcept(String conceptName, String conceptDesc,String repoURI, String repoShortHand,List propertyMap){

        def concept = new Concept(name: conceptName,description:conceptDesc)
        def repo = new Repository(uri:repoURI,shorthand: repoShortHand)
        repo.save(failOnError: true)
        concept.repository = repo
        concept.save(failOnError: true)

        propertyMap.each {
            ConceptProperty prop = new ConceptProperty(it as Map)
            prop.setBelongsToConcept(concept)
            prop.save()
            concept.addToConceptProperties(prop)
        }

        concept.save(failOnError: true)
    }

}
