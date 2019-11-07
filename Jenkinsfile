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
		sudo cp  /var/lib/jenkins/workspace/ez-books-back-end_master/target/*.jar .
		sh "pid=`lsof -i:8000 -t`; kill -TERM $pid || kill -KILL $pid"
		nohup java -jar `ls -p api*.jar| grep -v /` -Dserver.port=8000 &
		'''
      }
    }

  }
}