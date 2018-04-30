pipeline {

    stages {
       agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
           }
        stage('Build') {
            steps {
                sh 'apt-get install maven'
                sh 'mvn -B -DskipTests clean package'
                sh 'mvn install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}