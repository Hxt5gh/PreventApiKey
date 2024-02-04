
    android {

       defaultConfig {
        // Load app.properties file
        val appPropertiesFile = rootProject.file("app.properties")
        val appProperties = Properties()
        appProperties.load(FileInputStream(appPropertiesFile))
        
        // Define API_KEY constant
        buildConfigField("String", "API_KEY", appProperties.getProperty("API_KEY"))
        buildConfigField("String", "KTOR_IP_ADDRES", appProperties.getProperty("KTOR_IP_ADDRES"))
      }
    

       buildFeatures {
        buildConfig = true
       }
 
    }
// create a file name app.properties and add your api keys eg( API_KEY = "some api key " ) and add that to .gitignore file
// and in your project 
//  val url = BuildConfig.API_KEY
