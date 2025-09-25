def call(String projectname, String imagetage, String dockerhubuser){
  sh "docker build -t "${dockerhubuser}/${projectname}:/{imagetage} ."
}
