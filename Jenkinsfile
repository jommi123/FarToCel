pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
    }

    tools {
        maven 'Maven 3.9.6'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jommi123/FarToCel.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    def mavenHome = tool 'Maven'
                    bat "${mavenHome}/bin/mvn clean install"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    def mavenHome = tool 'Maven'
                    bat "${mavenHome}/bin/mvn test"
                }
            }
            post {
                success {
                    // Publish JUnit test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')
                }
            }
        }
    }
}