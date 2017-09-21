import minitwitter.CustomUserDetailsService
import minitwitter.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener, ref('hibernateDatastore'))
    userDetailsService(CustomUserDetailsService){
        grailsApplication = ref('grailsApplication')
    }
}
