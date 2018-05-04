pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                sh './mvnm clean install'
            }
        }
        stage('Build docker image'){
            steps{
                sh 'docker build -t "myapp:dockerfile"'
                sh 'docker run -i -t myapp:latest'
            }
        }
    }
}