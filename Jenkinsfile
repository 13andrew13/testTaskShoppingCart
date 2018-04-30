pipeline {
    agent any
    stages {
        stage('Build') {
            steps {

                sh './mvnw pac-B -DskipTests clean package'
            }
        }
    }
}