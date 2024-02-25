pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jommi123/FarToCel.git'
                githubNotify(
                    result: currentBuild.result,
                    description: "Build #${env.BUILD_NUMBER}",
                    context: "Jenkins CI"
                )
                }
            }
        }
        stage('Build') {
           steps {
               bat 'mvn clean install'
           }
        }
        stage('Test') {
           steps{
               bat 'mvn test'
           }
            post {
                success {
                    // Publish JUnit test results
                    junit testResults: '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')

                    // Github coverage report
                    script {
                        def codeCoverage = jacoco(
                            includes: ['**/target/jacoco.exec'],
                            sourcePattern: '**/src/main/java',
                            classPattern: '**/target/classes',
                            changeBuildStatus: true
                        )
                        // GitHub comment with coverage report
                        githubCoverage(codeCoverage: codeCoverage, onlyChanged: true)
                }
            }
        }
    }
}
