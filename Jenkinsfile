pipeline {
    agent any

    tools {
        // Имена JDK/Gradle должны совпадать с тем, что настроено в Jenkins (Global Tool Configuration)
        jdk 'jdk17'
        gradle 'Gradle-8'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Test') {
            steps {
                // Для Linux-агента:
                sh './gradlew test'
                // Для Windows-агента вместо строки выше можно использовать:
                // bat 'gradlew.bat test'
            }
        }
    }

    post {
        always {
            junit 'build/test-results/test/*.xml'
        }
    }
}

