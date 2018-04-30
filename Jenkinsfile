pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'apt-get install maven'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}