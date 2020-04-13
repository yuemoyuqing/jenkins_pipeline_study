# Jenkins全局变量

## 查看pipeline env全局变量
1. 使用`${Jenkins_url/jon_name/task_name}/pipeline-syntax/globals`获取jenkins所有全局变量，jenkinsfile均可以直接使用。使用方式`${env_names}`

2. 可以点击`task_name`--->`pipeline ayntax(流水线语法)`----->`global variables(全局变量)`下`reference`进行查看

## 设置pipeline全局变量

1. 使用`声明式pipeline`，通过`environment`指令行进行设置全局变量。适用的位置取决于`environment`所在位置

2. `脚本式pipeline`,通过`withEnv`进行设置

```python
# declare pipeline
pipeline{
  agent any
  environment {
      CC = 'variables1,所有steps都可用'
  }
  stages {
    stage('Example'){
      environment {
        DEBUG_FLAGS = 'variables2,只在example stage中可用'
      }
      steps {
        sh 'printenv'
      }
    }
  }
}


# stript pipeline
node {
  withEnv(["PATH+MAVEN=${tool 'M3'}/bin"]){
    sh 'mvn -B verify'
  }
}
```

以上通过environment指令创建的环境变量，可以使用`$env.param_name`以及`$param_name`进行引用
## 动态设置环境变量
1. 可以通过`returnStatus`和`returnStdout`
  使用`returnStdout`时，返回字符串末尾会加上一个空格，使用.trim()去掉

```python
pipeline{
  agent any
  environment{
    CC = """${sh(
        returnStdout:true,
        script:'echo "clang"'
    )}""""
  }
  # 使用returnStatus
  EXIT_STATUS = """${sh(
    returnStatus:true,
    script:'exit 1 '
  )}"""
}
```
