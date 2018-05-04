pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                sh './mvnw clean install'
            }
        }
        stage('Build docker image'){
            steps{
                sh "docker build -t 'myapp:dockerfile'"
                sh 'docker run -i -t myapp:latest'
            }
        }
    }
}