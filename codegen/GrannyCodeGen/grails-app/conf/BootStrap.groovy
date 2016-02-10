import org.apache.velocity.app.VelocityEngine

class BootStrap {

    def velocityEngine

    def init = { servletContext ->
        //velocityEngine.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM, this)
        velocityEngine.init()
    }
    def destroy = {
    }
}
