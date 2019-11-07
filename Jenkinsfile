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
        sh 'docker run -d -p 8000:8090 ezbook-back-end'
      }
    }

  }
}