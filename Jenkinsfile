pipeline {
    agent any
    tools {
        maven 'Maven3'
    }

    stages {
        stage('拉取项目并打包') {
            steps {
                echo '开始拉取项目...'
                sh """
                rm -rf demo
                git clone git@github.com:zhangjinning/demo.git
                cd /var/jenkins_home/workspace/demo-pipeline/demo
                mvn clean package
                """
                echo '打包项目完成...'
            }
        }
        stage('发送到远程服务器') {
            steps {
                echo '开始发送...'
                sshPublisher(publishers: [sshPublisherDesc(configName: 'local_server', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/var/app/', remoteDirectorySDF: false, removePrefix: 'demo/target', sourceFiles: '**/demo-0.0.1-SNAPSHOT.jar'), sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/var/app/', remoteDirectorySDF: false, removePrefix: 'demo', sourceFiles: '**/Dockerfile')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
                echo '发送完成...'
            }
        }
        stage('执行构建应用...') {
            steps {
                echo '开始构建...'
                sh """
                ssh root@192.168.236.128 "
                    cd /var/app;
                    ls;
                    docker stop demoAppContainer;
                    docker rm demoAppContainer;
                    docker rmi demo-app;
                    docker build -t demo-app .;
                    docker run -d -p 8090:8090 --name demoAppContainer demo-app;
                    rm -rf Dockerfile;
                    rm -rf demo-0.0.1-SNAPSHOT.jar;
                "
                """
                echo '构建完成...'
            }
        }
    }
}
