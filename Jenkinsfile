pipeline {

    agent any
    
    stages {
        stage('Build') {
            steps {
                dir("crmbackend"){
                sh 'gradle clean build -x test'}
            }
        }
        stage('Delivery') {
            steps {
                fileOperations([fileCopyOperation(
                    excludes: '',
                    flattenFiles: false,
                    includes: 'crmbackend\\build\\libs\\**',
                    targetLocation: "C:\\CRM\\UX"
                )])
               
            }
        }
        
    }
}
