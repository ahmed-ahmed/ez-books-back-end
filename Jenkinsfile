pipeline {
  agent any
  environment {
  		mvnHome = tool 'apache-maven-3.6.2'
        JAVA_HOME = tool 'jdk9.0.4'
  }
  stages {
    stage('Build') {
     steps {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
	      script{
	         if (isUnix()) {
	            sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean install'
	         } else {
	            bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean install/)
	         }
	      }
      }
     }
    }
    stage('deploy') {
      steps {
        sh '''cd /opt/deploy/back-end
		sudo rm -rf **.** *
		sudo cp -R ${workspace}/target/*.jar .'''
      }
    }

  }
}