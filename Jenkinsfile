pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw clean install'
            }
        }

        stage('Docker Build') {
            steps{
                 sh 'docker build shopping-cart'
                 sh 'docker pull 13andrew13/shopping-cart'
            }
        }
    }
}
