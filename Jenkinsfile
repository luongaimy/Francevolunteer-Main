pipeline {
    agent any
    tools{
    	maven 'Maven'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }

            post {
            	success {
            		echo "Archiving the Artifact"
            		archiveArtifacts artifacts: "**/*.war"
            	}

            }
        }

        stage('Deploy to Tomcat') {
            steps {
                deploy adapters: [tomcat9(credentialsId: '23a84c94-b144-46ab-8aa4-e76d77ac9e67', path: '', url: 'http://localhost:8081/')], contextPath: '/ept', war: '**/*.war'
            }
        }
    }
}
