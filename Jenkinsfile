pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        withEnv(overrides: ["MVN_HOME=$mvnHome"]) {
          script {
            if (isUnix()) {
              sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean install'
              sh 'docker build -t ezbook-back-end .'
            } else {
              bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean install/)
            }
          }

        }

      }
    }

    stage('deploy') {
      steps {
        sh 'docker rm -f backend || true '
        sh 'docker run -d -p 8090:8000 -t backend ezbook-back-end'
      }
    }

  }
  environment {
    mvnHome = 'apache-maven-3.6.2'
    JAVA_HOME = 'jdk9.0.4'
  }
}