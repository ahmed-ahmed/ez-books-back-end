pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
        sh 'docker build -t ezbook-back-end .'
      }
    }

    stage('deploy') {
      steps {
        sh 'docker rm -f backend || true '
        sh 'docker run -d -p 8090:8000 --name backend ezbook-back-end'
      }
    }

  }
  environment {
    mvnHome = 'apache-maven-3.6.2'
    JAVA_HOME = 'jdk9.0.4'
  }
}