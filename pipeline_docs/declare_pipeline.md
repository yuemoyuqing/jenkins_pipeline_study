# 声明式pipeline
声明式pipeline相对于stript pipeline语法更丰富，更容易理解和编写

## 声明式pipeline基本结构
1. 每个声明语句必须独立一行，行尾无需使用分号
2. 声明块（black{}）只能包含`区块（sections)`,`指令(directives)`，`步骤(steps)`或者`赋值语句`
  + 区块：通常包含一个或多个指令或步骤，例如：agent、post、stages、steps
  + 指令：environment、options、parameters、trigger(触发)、stage、tool、when
  + 步骤：可以使用“step reference”参考中记录的所有可用步骤，包含完整的步骤列表，链接：https://jenkis.io/doc/pipeline/steps

## 声明式pipeline语法细节
详细细节，参见https://jenkins.io/doc/book/pipeline/syntax,列举声明式pipeline语法支持的指令步骤等

## 声明式pipeline基本结构

```python
pipeline{
  agent any
  stages{
    stage('Build'){
      steps {
        # 构建阶段步骤
        echo "This is a build step"
      }
    }
    stage('Test'){
      steps{
        # 测试阶段步骤
        echo "This is a Test step"
      }
    }
    stage('Deploy'){
      steps{
        # 部署阶段步骤
        echo "This is a Deploy step"
      }
    }
  }
}
```
