pipeline {
    agent any
    environment {
        PATH = "${env.PATH};C:\\Windows\\System32" // Update the PATH to include the directory of cmd.exe
    }

  stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jommi123/FarToCel.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
                // Notify GitHub of build result
                githubNotify(
                    result: currentBuild.result,
                    description: "Build #${env.BUILD_NUMBER}",
                    context: "Jenkins CI"
                )
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                success {
                    // Publish JUnit test results
                    junit testResults: '**/target/surefire-reports/TEST-*.xml'
                    // Generate JaCoCo code coverage report
                    jacoco(execPattern: '**/target/jacoco.exec')

                    // Publish coverage report to GitHub
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
}