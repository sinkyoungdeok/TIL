

## 목록 
- [1. 설치 명령어](#1-설치-명령어)




## 1. 설치 명령어 

### 관련 오픈소스 클론
```
git clone https://github.com/apache/lucene.git
git clone https://github.com/elastic/elasticsearch.git
git clone https://github.com/HowookJeong/elasticsearch-analysis-arirang.git
git clone https://github.com/HowookJeong/arirang-analyzer-6.git
git clone https://github.com/HowookJeong/arirang.morph.git
```

### JENV 구성 
```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
brew install jenv
brew tap AdoptOpenJDK/openjdk
```

```
echo 'export PATH="$HOME/.jenv/bin:$PATH"' >> ~/.zshrc
echo 'eval "$(jenv init -)"' >> ~/.zshrc
source ~/.zshrc
```

jdk 설치 
```
brew install --cask adoptopenjdk11
```

jenv 추가 
```
jenv add /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
```

```
jenv enable-plugin export 
jenv global 11.0
jenv local 11.0
```


### elastic search 다운로드 
```
wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-8.3.1-darwin-aarch64.tar.gz
wget https://artifacts.elastic.co/downloads/kibana/kibana-8.3.1-darwin-aarch64.tar.gz
wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-8.3.1-darwin-aarch64.tar.gz
wget https://artifacts.elastic.co/downloads/logstash/logstash-8.3.1-darwin-x86_64.tar.gz

tar -xvzf elasticsearch-8.3.1-darwin-aarch64.tar.gz
tar -xvzf kibana-8.3.1-darwin-aarch64.tar.gz
tar -xvzf filebeat-8.3.1-darwin-aarch64.tar.gz
tar -xvzf logstash-8.3.1-darwin-x86_64.tar.gz
```

