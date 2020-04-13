# Jenkins定义安全凭据
Jenkins拉取代码的时候，如果没有配置credential或者配置不对，最终会导致git代码拉取失败
通过credential->system->glable credential->add credential来添加credential

## Jenkins credential类别

+ secret text（安全密文），类似于API的security Token
+ Username and password（用户密码对），可以是独立的字段，也可以为`:`分割的字符串。`例如：username：password`。一般是git的账号与密码
+ secrete file 保存至文件中的加密内容
+ SSH Username with private key,SSH公钥/私钥

## Credential scope（credential作用域）
主要有两种

+ global
   credential用于pipeline项目/其他项目，选择此项将credential应用于pipeline项目及其所有插件对象
+ System
   credential用于jenkins实例本身和系统管理功能（例如电子邮件认证，代理连接等）等交互。选择此项会将credential的应用于单个对象

## 添加Credential

+ scope字段中，选择Global或者System
+ 将credential本身添加到所选择的credential类型的相应字段中。例如Username and Password，对应字段指定credential的Username和Password
+ ID字段中，指定一个有意义的Credential ID
+ 添加一个描述

# Jenkins安全凭据处理
声明式Pipeline Environment指令，是一个`键值对`序列，该序列定义环境变量，适用于所有步骤或者特定某阶段的步骤，取决于environment指令在流水线内的位置

另外，environment指令提供方法credentials()，该方法可以再Jenkins环境中用于通过标识符（添加credential是ID）访问预定义的安全凭证。
