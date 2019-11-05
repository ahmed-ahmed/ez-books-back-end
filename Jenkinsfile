pipeline {
  agent any
  def mvnHome
  
  stages {
	stage('Preparation') { // for display purposes         
      mvnHome = tool 'apache-maven-3.6.2'
	  env.JAVA_HOME = tool 'jdk9.0.4'
	}
    stage('Build') {
      // Run the maven build
      withEnv(["MVN_HOME=$mvnHome"]) {
         if (isUnix()) {
            sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean install'
         } else {
            bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean install/)
         }
      }
    }
	stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archiveArtifacts 'target/*.jar'
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